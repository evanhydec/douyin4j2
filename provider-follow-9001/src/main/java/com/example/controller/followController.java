package com.example.controller;

import com.example.DTO.Cond.followCond;
import com.example.DTO.Response.baseResponse;
import com.example.DTO.Response.usersResponse;
import com.example.DTO.userDto;
import com.example.service.follow.followService;
import com.example.utils.stringUtils;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relation")
public class followController {
    @Autowired
    private followService service;

    @PostMapping("/action")
    public baseResponse action(
            @RequestParam("token")
            String token,
            @RequestParam("to_user_id")
            Integer user_id,
            @RequestParam("action_type")
            String type
    ) {
        try {
            Integer uid = stringUtils.parse(token);
            service.follow(type, uid, user_id);
            return baseResponse.success(user_id, token);
        } catch (Exception e) {
            return baseResponse.fail(e.getMessage());
        }
    }

    @GetMapping("/follow/list")
    public usersResponse followList(
            @RequestParam("user_id")
            Integer user_id,
            @RequestParam("token")
            String token
    ) {
        try {
            Integer uid = stringUtils.parse(token);
            List<userDto> users = service.follows(uid, user_id);
            return new usersResponse(users, "0", "success");
        } catch (Exception e) {
            return new usersResponse(
                    null,
                    "1",
                    e.getMessage()
            );
        }
    }

    @GetMapping("/follower/list")
    public usersResponse followerList(
            @RequestParam("user_id")
            Integer user_id,
            @RequestParam("token")
            String token
    ) {
        try {
            Integer uid = stringUtils.parse(token);
            List<userDto> users = service.followers(uid, user_id);
            return new usersResponse(users, "0", "success");
        } catch (Exception e) {
            return new usersResponse(null, "1", e.getMessage());
        }
    }

    @PostMapping("/check")
    @HystrixCommand(fallbackMethod = "hystrixCheck")
    public String check(
            @RequestBody
            followCond followCond
            ) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        if (service.checkFollow(followCond)) {
            return "yes";
        }  else {
            return "no";
        }
    }

    public String hystrixCheck(followCond followCond) {
        System.out.println("服务异常，已熔断");
        return "no";
    }

}
