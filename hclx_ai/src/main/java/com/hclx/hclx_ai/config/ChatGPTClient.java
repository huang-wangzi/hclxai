package com.hclx.hclx_ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * GPT配置类
 */
@Configuration
public class ChatGPTClient {
    @Bean
    public ChatClient initGPT4(ChatClient.Builder builder) {
        return builder.build();
    }
}
