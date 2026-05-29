package com.hclx.hclx_ai.entity;

import lombok.Data;
import org.springframework.ai.chat.messages.AbstractMessage;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.UserMessage;

/**
 * 数据库所存消息的实体类
 *      为什么要创建这个实体类？
 *              原因是因为Redis无法存储java的Object对象，需要进行序列化和反序列化操作
 *              而UserMessage和AssistantMessage不支持序列化操作
 *              所以我们单独创建了一个实体类用于执行序列化和反序列化操作，以便将历史消息记录在Redis数据库中存取。
 */
@Data
public class ChatMSG {
    //消息类型：用户消息/AI助手消息
    private String type;
    //消息内容
    private String msg;

    public static final String USER = "user";
    public static final String AI = "ai";

    //传入用户消息，返回类型是用户消息的ChatMSG实体类对象
    public static ChatMSG user(String msg) {
        ChatMSG chatMSG = new ChatMSG();
        chatMSG.type = USER;
        chatMSG.msg = msg;
        return chatMSG;
    }

    //传入AI助手消息，返回类型是AI消息的ChatMSG实体类对象
    public static ChatMSG ai(String msg) {
        ChatMSG chatMSG = new ChatMSG();
        chatMSG.type = AI;
        chatMSG.msg = msg;
        return chatMSG;
    }

    //将ChatMSG实体类对象转为对应的 UserMessage或者AssistantMessage对象
    public AbstractMessage transfer(){
        if (USER.equals(type)){
            return new UserMessage(msg);
        }
        if (AI.equals(type)) {
            return new AssistantMessage(msg);
        }
        return null;
    }

}
