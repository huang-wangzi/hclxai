package com.hclx.hclx_ai.controller;


import com.alibaba.fastjson2.JSONObject;
import com.hclx.hclx_ai.entity.ChatMSG;
import com.hclx.hclx_ai.entity.User;
import com.hclx.hclx_ai.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author springBoot-Learning
 * @since 2024-12-10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Resource
    RedisTemplate<String, List<ChatMSG>> redisTemplate;

    //注册接口： POST请求
    @PostMapping("/register")
    public JSONObject register(@RequestBody User user){
        //测试请求参数：
        System.out.println(user);

        //生成id
        String userId = UUID.randomUUID().toString();
        user.setId(userId);

        //将用户对象存入mysql数据库
//        boolean b = userService.save(user);

        boolean b = userService.addUser(user);


        JSONObject res = new JSONObject();
        if (b) {
            res.put("code", 200);
            res.put("msg", "注册成功");
            res.put("userId", userId);

            List<ChatMSG> list = new LinkedList<>();
            //向redis中存储数据：
            redisTemplate.opsForValue().set(userId, list);

        }else {
            res.put("code", 500);
            res.put("msg", "注册失败");
        }
        return res;
    }

    //登录接口： POST请求
    @PostMapping("/login")
    public JSONObject login(@RequestBody User user){
        System.out.println(user);

        User loginUser = userService.login(user.getUsername(), user.getPassword());

        JSONObject res = new JSONObject();
        if (loginUser != null) {
            res.put("code", 200);
            res.put("msg", "登录成功");
            res.put("userId", loginUser.getId());
        }else {
            res.put("code", 500);
            res.put("msg", "用户名或密码错误");
        }
        return res;
    }


}
