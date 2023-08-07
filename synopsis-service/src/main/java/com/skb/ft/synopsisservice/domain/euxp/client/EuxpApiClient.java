package com.skb.ft.synopsisservice.domain.euxp.client;

import com.skb.ft.synopsisservice.domain.euxp.vo.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.infra.feign.HeaderConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "euxpApi", url = "${env.EUXP_URI}", configuration = HeaderConfiguration.class)
public interface EuxpApiClient {
    @GetMapping(value = "/contents/synopsis",consumes = "application/json")
    public EuxpSynopsisResponseDto requestEuxpSynopsis(@SpringQueryMap EuxpRequestParam euxpRequestParam);
}
