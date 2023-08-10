package com.skb.ft.synopsisservice.domain.smd.client;

import com.skb.ft.synopsisservice.domain.smd.dto.SmdLikeHateResponseDto;
import com.skb.ft.synopsisservice.global.config.HttpHeaderConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "smdApi", url = "${env.SMD_URL}",configuration = HttpHeaderConfig.class)
public interface SmdApiClient {
    @GetMapping(value = "/sd-ui5service", consumes = "application/json") //consumes는 client가 서버에 보내는 타입. produecs는 서버에서 받아오는 타입
    public SmdLikeHateResponseDto requestSmdGetLikeHate(@SpringQueryMap SmdRequestParam smdRequestParam);
}
