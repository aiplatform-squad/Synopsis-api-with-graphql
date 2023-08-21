package com.skb.ft.synopsisservice.domain.euxp;

import com.skb.ft.synopsisservice.web.EuxpApiClient;
import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpRequestParamDto;
import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
import com.skb.ft.synopsisservice.web.WebClient.WebClientService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientException;

@RequiredArgsConstructor
@Slf4j
@Service
public class EuxpServiceImpl implements EuxpService{
    private final EuxpApiClient euxpApiClient;
    private final WebClientService webClientService;

    @Override
    public EuxpSynopsisResponseDto callEuxpResponse(EuxpRequestParamDto euxpRequestParamDto) {
        EuxpSynopsisResponseDto euxpSynopsisResponseDto;
        try {
            euxpSynopsisResponseDto =euxpApiClient.requestEuxpSynopsis(euxpRequestParamDto);
        }catch (FeignException e){
            euxpSynopsisResponseDto=EuxpSynopsisResponseDto.builder()
                    .errorMessage(e.getMessage()).build();
        }
        return euxpSynopsisResponseDto;
    }
@Override
    public EuxpSynopsisResponseDto callEuxpResponseWebClient(EuxpRequestParamDto euxpRequestParamDto) {
        EuxpSynopsisResponseDto euxpSynopsisResponseDto;
        try {
            euxpSynopsisResponseDto =webClientService.requestEuxpWebclient();
        }catch (WebClientException e){
            euxpSynopsisResponseDto=EuxpSynopsisResponseDto.builder()
                    .errorMessage(e.getMessage()).build();
        }
        return euxpSynopsisResponseDto;
    }

    @Override
    public EuxpSynopsisResponseDto loadEuxpSynopsisPageWebClient(SynopsisPageRequestDto synopsisPageRequestDto) {
        EuxpRequestParamDto euxpRequestParamDto = EuxpRequestParamDto.builder()
                .epsd_id(synopsisPageRequestDto.getEpsd_id())
                .IF(synopsisPageRequestDto.getIF())
                .menu_stb_svc_id(synopsisPageRequestDto.getEuxp_menu_stb_svc_id())
                .search_type(synopsisPageRequestDto.getEuxp_search_type())
                .stb_id(synopsisPageRequestDto.getStb_id())
                .yn_recent(synopsisPageRequestDto.getEuxp_yn_recent()).build();
        EuxpSynopsisResponseDto euxpSynopsisResponseDto= this.callEuxpResponseWebClient(euxpRequestParamDto);
        return euxpSynopsisResponseDto;
    }

    @Override
    public EuxpSynopsisResponseDto loadEuxpSynopsisPage(SynopsisPageRequestDto synopsisPageRequestDto) {
        EuxpRequestParamDto euxpRequestParamDto = EuxpRequestParamDto.builder()
                .epsd_id(synopsisPageRequestDto.getEpsd_id())
                .IF(synopsisPageRequestDto.getIF())
                .menu_stb_svc_id(synopsisPageRequestDto.getEuxp_menu_stb_svc_id())
                .search_type(synopsisPageRequestDto.getEuxp_search_type())
                .stb_id(synopsisPageRequestDto.getStb_id())
                .yn_recent(synopsisPageRequestDto.getEuxp_yn_recent()).build();
        EuxpSynopsisResponseDto euxpSynopsisResponseDto= this.callEuxpResponse(euxpRequestParamDto);
        return euxpSynopsisResponseDto;
    }
}
