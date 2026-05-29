package com.hclx.hclx_ai.controller;

import com.hclx.hclx_ai.entity.ChatMSG;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotBlank;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

//用于验证请求参数合法性
@Validated
//表示可以返回数据，而不只是页面
@RestController
//请求路径
@RequestMapping("/ai_chat")
public class AiChatController {

    // 自动依赖注入
    @Autowired
    ChatClient chatClient;
    @Resource
    RedisTemplate<String, List<ChatMSG>> redisTemplate;

    // 全局通信记录
    HashMap<String, List<Message>> map = new HashMap<>();

    @GetMapping("/say")
    public String say(@NotBlank(message = "查询消息不可为空") String msg,
                      @NotBlank(message = "用户ID不可为空") String userId
    ) {

        //根据userId加载历史记录
        List<ChatMSG> msgList = redisTemplate.opsForValue().get(userId);
        //限制历史记录长度小于10
        if (msgList == null) {
            msgList = new LinkedList<>();
        } else if (msgList.size() > 10) {
            msgList = msgList.subList(msgList.size() - 10, msgList.size());
        }

        //将用户留言添加至集合
        msgList.add(ChatMSG.user(msg));

        //4.发送请求，调用AI接口
        String content = chatClient
                .prompt()
                .messages(msgList.stream().map(ChatMSG::transfer).collect(Collectors.toList()))
                .call()
                .content();
        //将gpt返回的消息，追加到历史记录中
        msgList.add(ChatMSG.ai(content));
        //存入redis数据库
        redisTemplate.opsForValue().set(userId, msgList);
        return content;
    }

    @GetMapping("/getId")
    public String getId(){
        String userId = UUID.randomUUID().toString();

        //状态：
        //      key：userId
        //      value: list
        // 用户获取id时，向map中添加该用户id，和空的list集合
//        List<Message> list = new ArrayList<>();
//        map.put(userId, list);

        List<ChatMSG> list = new LinkedList<>();
        //向redis中存储数据：
        redisTemplate.opsForValue().set(userId, list);

        return userId;
    }














}
