package com.skb.ft.synopsisservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SynopsisServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SynopsisServiceApplication.class, args);
    }

}
