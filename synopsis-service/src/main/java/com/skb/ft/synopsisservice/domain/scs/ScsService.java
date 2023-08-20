package com.skb.ft.synopsisservice.domain.scs;

import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewRequestDto;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
import org.springframework.stereotype.Service;
@Service
public interface ScsService {
    ScsDirectviewResponseDto callScsDirectviewResponse(ScsDirectviewRequestDto scsDirectviewRequestDto);
    ScsDirectviewResponseDto loadSmdSynopsisPage(SynopsisPageRequestDto synopsisPageRequestDto);
    public ScsDirectviewResponseDto callScsDirectviewResponseWebClient(ScsDirectviewRequestDto scsDirectviewRequestDto);
    ScsDirectviewResponseDto loadSmdSynopsisPageWebCleitn(SynopsisPageRequestDto synopsisPageRequestDto);
}
