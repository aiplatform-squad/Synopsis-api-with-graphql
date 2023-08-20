package com.skb.ft.synopsisservice.domain.scs;

import com.skb.ft.synopsisservice.web.ScsApiClient;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewRequestDto;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
import com.skb.ft.synopsisservice.web.WebClient.WebClientService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientException;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScsServiceImpl implements ScsService{
    private final ScsApiClient scsApiClient;
    private final WebClientService webClientService;
    @Override
    public ScsDirectviewResponseDto callScsDirectviewResponse(ScsDirectviewRequestDto scsDirectviewRequestDto) {
        ScsDirectviewResponseDto scsDirectviewResponseDto;
        try {
            scsDirectviewResponseDto = scsApiClient.requestScsDirectview(scsDirectviewRequestDto);
        }catch (FeignException e){
            scsDirectviewResponseDto=ScsDirectviewResponseDto.builder()
                    .errorMessage(e.getMessage()).build();
        }
        return scsDirectviewResponseDto;
    }
    @Override
    public ScsDirectviewResponseDto callScsDirectviewResponseWebClient(ScsDirectviewRequestDto scsDirectviewRequestDto) {
        ScsDirectviewResponseDto scsDirectviewResponseDto;
        try {
            scsDirectviewResponseDto = webClientService.requestScsWebclient(scsDirectviewRequestDto);
        }catch (WebClientException e){
            scsDirectviewResponseDto=ScsDirectviewResponseDto.builder()
                    .errorMessage(e.getMessage()).build();
        }
        return scsDirectviewResponseDto;
    }

    @Override
    public ScsDirectviewResponseDto loadSmdSynopsisPageWebCleitn(SynopsisPageRequestDto synopsisPageRequestDto) {
        ScsDirectviewRequestDto scsDirectviewRequestDto = ScsDirectviewRequestDto.builder()
                .hash_id(synopsisPageRequestDto.getScs_hash_id())
                .ppv_products(synopsisPageRequestDto.getScs_ppv_products())
                .response_format(synopsisPageRequestDto.getScs_response_format())
                .synopsis_type(synopsisPageRequestDto.getScs_synopsis_type())
                .sris_id(synopsisPageRequestDto.getSeries_id())
                .stb_id(synopsisPageRequestDto.getScs_stb_id())
                .ui_name(synopsisPageRequestDto.getScs_ui_name())
                .ver(synopsisPageRequestDto.getScs_ver())
                .ppv_products(synopsisPageRequestDto.getScs_ppv_products()).build();
        ScsDirectviewResponseDto scsDirectviewResponseDto= this.callScsDirectviewResponseWebClient(scsDirectviewRequestDto);
        return scsDirectviewResponseDto;
    }

    @Override
    public ScsDirectviewResponseDto loadSmdSynopsisPage(SynopsisPageRequestDto synopsisPageRequestDto) {
        ScsDirectviewRequestDto scsDirectviewRequestDto = ScsDirectviewRequestDto.builder()
                .hash_id(synopsisPageRequestDto.getScs_hash_id())
                .ppv_products(synopsisPageRequestDto.getScs_ppv_products())
                .response_format(synopsisPageRequestDto.getScs_response_format())
                .synopsis_type(synopsisPageRequestDto.getScs_synopsis_type())
                .sris_id(synopsisPageRequestDto.getSeries_id())
                .stb_id(synopsisPageRequestDto.getScs_stb_id())
                .ui_name(synopsisPageRequestDto.getScs_ui_name())
                .ver(synopsisPageRequestDto.getScs_ver())
                .ppv_products(synopsisPageRequestDto.getScs_ppv_products()).build();
        ScsDirectviewResponseDto scsDirectviewResponseDto= this.callScsDirectviewResponse(scsDirectviewRequestDto);
        return scsDirectviewResponseDto;
    }
}
