package com.skb.ft.synopsisservice.web;

import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpRequestParamDto;
import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.global.config.HttpHeaderConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "euxpApi", url = "${env.EUXP_URL}", configuration = HttpHeaderConfig.class)
public interface EuxpApiClient {
    @GetMapping(value = "/contents/synopsis",consumes = "application/json")
    public EuxpSynopsisResponseDto requestEuxpSynopsis(@SpringQueryMap EuxpRequestParamDto euxpRequestParamDto);
}
