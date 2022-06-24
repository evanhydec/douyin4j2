package com.example.dao;

import com.example.DTO.Cond.videoCond;
import com.example.DTO.videoDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface videoDao {
    Integer createVideo(@Param("video") videoCond video);
    Integer updateVideo(@Param("video") videoDto video);
    List<videoDto> getVideosByUid(@Param("id")Integer id);
    List<videoDto> getVideosByTime(@Param("time")Long time);
    List<videoDto> getVideosByIds(List<Integer> ids);
}
