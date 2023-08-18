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
import com.skb.ft.synopsisservice.domain.synopsis.SynopsisService;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import java.util.Map;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {
    private final EuxpService euxpService;
    private final SmdService smdService;
    private final ScsService scsService;
    private final SynopsisService synopsisService;
    @QueryMapping
    public EuxpSynopsisResponseDto euxpSynopsisQuery(@Arguments EuxpRequestParam euxpRequestParam){
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
    @QueryMapping
    public SynopsisPageResponseDto synopsisPageViewQuery(@Argument SynopsisPageRequestDto inputParam){
        return synopsisService.getSynopsisPage(inputParam);

    }
}
