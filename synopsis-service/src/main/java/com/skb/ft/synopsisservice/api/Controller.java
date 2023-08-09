package com.skb.ft.synopsisservice.api;

import com.skb.ft.synopsisservice.domain.euxp.EuxpService;
import com.skb.ft.synopsisservice.domain.euxp.client.EuxpRequestParam;
import com.skb.ft.synopsisservice.domain.euxp.vo.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.domain.smd.SmdService;
import com.skb.ft.synopsisservice.domain.smd.client.SmdRequestParam;
import com.skb.ft.synopsisservice.domain.smd.vo.SmdLikeHateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.Map;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {
    private final EuxpService euxpService;
    private final SmdService smdService;
    @QueryMapping
    public EuxpSynopsisResponseDto euxpQuery(@Arguments EuxpRequestParam euxpRequestParam){
        EuxpSynopsisResponseDto  euxpSynopsisResponseDto = euxpService.callEuxpResponse(euxpRequestParam);
        return euxpSynopsisResponseDto;
    }
    @QueryMapping
    public SmdLikeHateResponseDto smdLikeHateQuery(@Arguments SmdRequestParam smdRequestParam){
        SmdLikeHateResponseDto smdLikeHateResponseDto = smdService.callSmdLikeHateResponse(smdRequestParam);
        return smdLikeHateResponseDto;
    }

}
