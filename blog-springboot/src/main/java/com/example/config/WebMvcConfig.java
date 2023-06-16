//package com.example.config;
//
///**
// * @Description
// * @Author LZ.
// * @Date 2022/11/15 10:47
// * @Version 1.0
// */
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurerAdapter {
//
//    // 设置跨域访问
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://127.0.0.1:8080")
//                .allowedMethods("GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "TRACE")
//                .allowCredentials(true);
//    }
//}
