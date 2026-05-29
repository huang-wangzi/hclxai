package com.hclx.hclx_ai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域访问配置类
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("init CORS");
        registry
                //配置允许访问的路径
                .addMapping("/**")
                //放行域名
                .allowedOrigins("*")
                //放行请求方式
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                //放行请求头
                .allowedHeaders("*")
                //可读取的响应头
                .exposedHeaders("*")
                .maxAge(3600);
    }
}
