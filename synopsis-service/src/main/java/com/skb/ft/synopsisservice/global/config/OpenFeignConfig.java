package com.skb.ft.synopsisservice.global.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenFeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
//        NONE, No logging (DEFAULT).
//        BASIC, Log only the request method and URL and the response status code and execution time.
//        HEADERS, Log the basic information along with request and response headers.
//        FULL, Log the headers, body, and metadata for both requests and responses
    }


}
