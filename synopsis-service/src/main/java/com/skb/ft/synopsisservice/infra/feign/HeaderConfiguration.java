package com.skb.ft.synopsisservice.infra.feign;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestHeader;

public class HeaderConfiguration {
    @Value("${env.AUTH_VAL}")
    String authVal;
    @Value("${env.CLIENT_ID}")
    String clientId;
    @Value("${env.TIMESTAMP}")
    String timestamp;
    @Value("${env.UUID}")
    String uuid;
    @Value("${env.TRACE}")
    String trace;
    @Value("${env.API_KEY}")
    String apiKey;
    @Bean
    public RequestInterceptor requestInterceptor(){
        return requestTemplate -> {
            requestTemplate.header("Auth_Val",authVal);
            requestTemplate.header("Client_ID",clientId);
            requestTemplate.header("TimeStamp",timestamp);
            requestTemplate.header("UUID",uuid);
            requestTemplate.header("Timestamp",timestamp);
            requestTemplate.header("Api_Key",apiKey);
        };
    }
}
