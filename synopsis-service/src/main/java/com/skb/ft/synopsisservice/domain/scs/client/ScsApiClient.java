package com.skb.ft.synopsisservice.domain.scs.client;

import com.skb.ft.synopsisservice.domain.euxp.client.EuxpRequestParam;
import com.skb.ft.synopsisservice.domain.euxp.vo.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.domain.scs.vo.ScsResponseDto;
import com.skb.ft.synopsisservice.global.config.HttpHeaderConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "scsApi", url = "${SCS_URI}",configuration = HttpHeaderConfig.class)
public interface ScsApiClient {
    @PostMapping(value="",consumes = "application/json")
    public ScsResponseDto requestScs(@SpringQueryMap ScsRequestParam scsRequestParam);
}
