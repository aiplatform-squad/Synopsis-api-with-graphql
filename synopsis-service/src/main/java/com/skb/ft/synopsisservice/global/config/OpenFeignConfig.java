package com.skb.ft.synopsisservice.global.config;

import feign.Logger;
import feign.RetryableException;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import graphql.execution.AbortExecutionException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import static java.lang.String.format;

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
    @Bean
    public ErrorDecoder errorDecoder(){
        return(methodKey, response)->{
            if(HttpStatus.Series.valueOf(response.status()) ==HttpStatus.Series.SERVER_ERROR){
                return new RetryableException(response.status(),
                        format("%s 요청이 성공하지 못했습니다. Retry 합니다. - status: %s, headers: %s", methodKey, response.status(), response.headers()),
                        response.request().httpMethod(),
                        null
                        ,response.request());
            } else if (HttpStatus.Series.valueOf(response.status()) ==HttpStatus.Series.CLIENT_ERROR) {
                return new AbortExecutionException(format("%s 요청이 성공하지 못했습니다. Retry 합니다. - status: %s, headers: %s", methodKey, response.status(), response.headers()));
            }
            return new IllegalStateException(format("%s 요청이 성공하지 못했습니다. - status: %s, headers: %s", methodKey, response.status(), response.headers()));
        };
    }

    @Bean
    public Retryer retryer(){
        // period: 실행 주기, maxPeriod: interval 이 더 클 경우 반환 maxAttempts: 최대 몇번 실행
        //1초 간격으로 최대 3회까지 재시도. 최대 재시도 간격은 2초
        return new Retryer.Default(1000,2000,3);
    }

}
