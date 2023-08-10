package com.skb.ft.synopsisservice.api;

import com.skb.ft.synopsisservice.domain.euxp.EuxpService;
import com.skb.ft.synopsisservice.domain.euxp.client.EuxpRequestParam;
import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.domain.smd.SmdService;
import com.skb.ft.synopsisservice.domain.smd.client.SmdRequestParam;
import com.skb.ft.synopsisservice.domain.smd.dto.SmdLikeHateResponseDto;
import com.skb.ft.synopsisservice.domain.scs.ScsService;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewRequestDto;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.QueryMapping;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {
    private final EuxpService euxpService;
    private final SmdService smdService;
    private final ScsService scsService;
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
    @QueryMapping
    public ScsDirectviewResponseDto scsDirectviewQuery(@Arguments ScsDirectviewRequestDto scsDirectviewRequestDto){
        ScsDirectviewResponseDto scsDirectviewResponseDto=scsService.callScsDirectviewResponse(scsDirectviewRequestDto);
        return  scsDirectviewResponseDto;
    }

}
