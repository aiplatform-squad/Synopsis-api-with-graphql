package com.skb.ft.synopsisservice.domain.scs;

import com.skb.ft.synopsisservice.domain.scs.client.ScsApiClient;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewRequestDto;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScsServiceImpl implements ScsService{
    private final ScsApiClient scsApiClient;
    @Override
    public ScsDirectviewResponseDto callScsDirectviewResponse(ScsDirectviewRequestDto scsDirectviewRequestDto) {
        ScsDirectviewResponseDto scsDirectviewResponseDto = scsApiClient.requestScsDirectview(scsDirectviewRequestDto);
        return scsDirectviewResponseDto;
    }
}
