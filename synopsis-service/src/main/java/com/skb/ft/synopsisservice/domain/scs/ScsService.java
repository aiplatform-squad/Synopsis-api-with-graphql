package com.skb.ft.synopsisservice.domain.scs;

import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewRequestDto;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewResponseDto;
import org.springframework.stereotype.Service;
@Service
public interface ScsService {
    ScsDirectviewResponseDto callScsDirectviewResponse(ScsDirectviewRequestDto scsDirectviewRequestDto);
}
