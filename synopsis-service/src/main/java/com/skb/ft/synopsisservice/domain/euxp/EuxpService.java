package com.skb.ft.synopsisservice.domain.euxp;

import com.skb.ft.synopsisservice.domain.euxp.client.EuxpRequestParam;
import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface EuxpService {
    EuxpSynopsisResponseDto callEuxpResponse(EuxpRequestParam euxpRequestParam);
    EuxpSynopsisResponseDto loadEuxpSynopsisPage(SynopsisPageRequestDto synopsisPageRequestDto);
}
