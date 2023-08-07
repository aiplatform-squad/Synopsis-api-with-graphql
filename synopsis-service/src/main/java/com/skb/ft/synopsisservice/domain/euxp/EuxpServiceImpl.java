package com.skb.ft.synopsisservice.domain.euxp;

import com.skb.ft.synopsisservice.domain.euxp.client.EuxpApiClient;
import com.skb.ft.synopsisservice.domain.euxp.client.EuxpRequestParam;
import com.skb.ft.synopsisservice.domain.euxp.vo.EuxpSynopsisResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class EuxpServiceImpl implements EuxpService{
    private final EuxpApiClient euxpApiClient;

    @Override
    public EuxpSynopsisResponseDto callEuxpResponse(EuxpRequestParam euxpRequestParam) {
        EuxpSynopsisResponseDto  euxpSynopsisResponseDto =euxpApiClient.requestEuxpSynopsis(euxpRequestParam);
        return euxpSynopsisResponseDto;
    }

}
