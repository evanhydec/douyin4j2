package com.example.service.video.impl;

import com.example.DTO.Cond.favouriteCond;
import com.example.DTO.Cond.followCond;
import com.example.DTO.Cond.videoCond;
import com.example.DTO.videoDto;
import com.example.service.favourite.favouriteService;
import com.example.service.follow.followService;
import com.example.service.video.videoService;
import com.example.utils.cover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class videoServiceImpl implements videoService {
    private final String local;
    private final String realPath;
    private final String playUrl;
    private final String coverUrl;
    private final String saveVUrl;
    private final String saveCUrl;

    @Autowired
    private com.example.dao.videoDao videoDao;

    @Autowired
    private followService followService;

    @Autowired
    private favouriteService favouriteService;

    public videoServiceImpl() {
        try {
            realPath = ResourceUtils.getURL("classpath:").getPath() + "static/";
            local = "http://192.168.2.111/douyin/static/";
            saveVUrl = realPath + "videos";
            saveCUrl = realPath + "covers";
            playUrl = local + "videos/";
            coverUrl = local + "covers/";
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void publish(MultipartFile file, String title, Integer uid) {
        String name = file.getOriginalFilename();
        String suffix = name.substring(name.lastIndexOf("."));
        name = UUID.randomUUID() + suffix;

        try {
            //by local
            File target = new File(saveVUrl, name);
            file.transferTo(target);
            String url = cover.getScreenshot(target.getPath(), saveCUrl);
            Integer res = videoDao.createVideo(new videoCond(
                    title,
                    playUrl + name,
                    coverUrl + url,
                    uid
            ));

            //by qiNiu
//            String playUrl = qiniuUtil.upload2qiNiu(file.getInputStream(), name);
//            videoDao.createVideo(new videoCond(
//               title,
//               playUrl,
//               playUrl + "?vframe/jpg/offset/1",
//               uid
//            ));
        } catch (Exception e) {
            throw new RuntimeException("publish action wrong");
        }
    }

    @Override
    public List<videoDto> list(Integer uid, Integer token) {
        List<videoDto> videos = videoDao.getVideosByUid(uid);
        String check = followService.checkFollow(new followCond(token, uid));
        if (check.equals("yes")) {
            for (videoDto video : videos) {
                video.getAuthor().setIs_follow(true);
            }
        }
        return videos;
    }

    @Override
    public List<videoDto> feed(Long time, Integer uid) {
        List<videoDto> videos = videoDao.getVideosByTime(time);
        for (videoDto video : videos) {
            if (followService.checkFollow(new followCond(uid, video.getAuthor().getId())).equals("yes")) {
                video.getAuthor().setIs_follow(true);
            }
            if (favouriteService.checkFavourite(new favouriteCond(uid, video.getId())).equals("yes")) {
                video.setIs_favorite(true);
            }
        }
        return videos;
    }

    @Override
    public List<videoDto> getAll(List<Integer> ids) {
        return videoDao.getVideosByIds(ids);
    }

    @Override
    public void update(videoDto videoDto) {
        videoDao.updateVideo(videoDto);
    }
}
