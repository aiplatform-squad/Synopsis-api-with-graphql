package com.skb.ft.synopsisservice.domain.scs;

import com.skb.ft.synopsisservice.domain.scs.client.ScsApiClient;
import com.skb.ft.synopsisservice.domain.scs.client.ScsRequestParam;
import com.skb.ft.synopsisservice.domain.scs.vo.ScsResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScsServiceImpl implements ScsService{
    private final ScsApiClient scsApiClient;
    @Override
    public ScsResponseDto callScsResponse(ScsRequestParam scsRequestParam) {
        ScsResponseDto scsResponseDto = scsApiClient.requestScs(scsRequestParam);
        return scsResponseDto;
    }
}
