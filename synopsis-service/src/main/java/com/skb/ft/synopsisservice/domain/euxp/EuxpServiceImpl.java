package com.skb.ft.synopsisservice.domain.euxp;

import com.skb.ft.synopsisservice.domain.euxp.client.EuxpApiClient;
import com.skb.ft.synopsisservice.domain.euxp.client.EuxpRequestParam;
import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.domain.euxp.vo.Content;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
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

    @Override
    public EuxpSynopsisResponseDto loadEuxpSynopsisPage(SynopsisPageRequestDto synopsisPageRequestDto) {
        EuxpRequestParam euxpRequestParam=EuxpRequestParam.builder()
                .epsd_id(synopsisPageRequestDto.getEpsd_id())
                .IF(synopsisPageRequestDto.getIF())
                .menu_stb_svc_id(synopsisPageRequestDto.getEuxp_menu_stb_svc_id())
                .search_type(synopsisPageRequestDto.getEuxp_search_type())
                .stb_id(synopsisPageRequestDto.getStb_id())
                .yn_recent(synopsisPageRequestDto.getEuxp_yn_recent()).build();
        EuxpSynopsisResponseDto euxpSynopsisResponseDto= this.callEuxpResponse(euxpRequestParam);
        return euxpSynopsisResponseDto;
    }

}
