package com.skb.ft.synopsisservice.domain.synopsis;

import com.skb.ft.synopsisservice.domain.euxp.EuxpService;
import com.skb.ft.synopsisservice.domain.euxp.client.EuxpRequestParam;
import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.domain.scs.ScsService;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewRequestDto;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SynopsisServiceImpl implements SynopsisService{
    private final EuxpService euxpService;
    private final ScsService scsService;
    @Override
    public SynopsisPageResponseDto getSynopsisPage(SynopsisPageRequestDto synopsisPageRequestDto){
        EuxpRequestParam euxpRequestParam=EuxpRequestParam.builder().build();
        EuxpSynopsisResponseDto euxpSynopsisResponseDto= euxpService.callEuxpResponse(euxpRequestParam);

        ScsDirectviewRequestDto scsDirectviewRequestDto = ScsDirectviewRequestDto.builder().build();
        ScsDirectviewResponseDto scsDirectviewResponseDto= scsService.callScsDirectviewResponse(scsDirectviewRequestDto);
        //TODO building
        return null;
    }
}
