package com.skb.ft.synopsisservice.api;

import com.skb.ft.synopsisservice.domain.euxp.EuxpService;
import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpRequestParamDto;
import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.domain.smd.SmdService;
import com.skb.ft.synopsisservice.domain.smd.dto.SmdRequestParamDto;
import com.skb.ft.synopsisservice.domain.smd.dto.SmdLikeHateResponseDto;
import com.skb.ft.synopsisservice.domain.scs.ScsService;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewRequestDto;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.SynopsisService;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageResponseDto;
import com.skb.ft.synopsisservice.global.util.MeasureExecutionTime;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.QueryMapping;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {
    private final EuxpService euxpService;
    private final SmdService smdService;
    private final ScsService scsService;
    private final SynopsisService synopsisService;
    @QueryMapping
    public EuxpSynopsisResponseDto euxpSynopsisQuery(@Arguments EuxpRequestParamDto euxpRequestParamDto){
        EuxpSynopsisResponseDto  euxpSynopsisResponseDto = euxpService.callEuxpResponse(euxpRequestParamDto);
        return euxpSynopsisResponseDto;
    }
    @QueryMapping
    public SmdLikeHateResponseDto smdLikeHateQuery(@Arguments SmdRequestParamDto smdRequestParamDto){
        SmdLikeHateResponseDto smdLikeHateResponseDto = smdService.callSmdLikeHateResponse(smdRequestParamDto);
        return smdLikeHateResponseDto;
    }
    @QueryMapping
    public ScsDirectviewResponseDto scsDirectviewQuery(@Arguments ScsDirectviewRequestDto scsDirectviewRequestDto){
        ScsDirectviewResponseDto scsDirectviewResponseDto=scsService.callScsDirectviewResponse(scsDirectviewRequestDto);
        return  scsDirectviewResponseDto;
    }
    @MeasureExecutionTime
    @QueryMapping
    public SynopsisPageResponseDto synopsisPageViewQuery(@Argument SynopsisPageRequestDto inputParam){
    return synopsisService.getSynopsisPage(inputParam);
    }
    @MeasureExecutionTime
    @QueryMapping
    public SynopsisPageResponseDto synopsisPageViewQueryWebClient(@Argument SynopsisPageRequestDto inputParam){
        return synopsisService.getSynopsisPageWebClient(inputParam);
    }
}
