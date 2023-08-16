package com.skb.ft.synopsisservice.domain.synopsis;

import com.skb.ft.synopsisservice.domain.euxp.EuxpService;
import com.skb.ft.synopsisservice.domain.euxp.client.EuxpRequestParam;
import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.domain.scs.ScsService;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewRequestDto;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewResponseDto;
import com.skb.ft.synopsisservice.domain.smd.SmdService;
import com.skb.ft.synopsisservice.domain.smd.client.SmdRequestParam;
import com.skb.ft.synopsisservice.domain.smd.dto.SmdLikeHateResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SynopsisServiceImpl implements SynopsisService{
    private final EuxpService euxpService;
    private final ScsService scsService;
    private final SmdService smdService;
    @Override
    public SynopsisPageResponseDto getSynopsisPage(SynopsisPageRequestDto synopsisPageRequestDto){
        EuxpRequestParam euxpRequestParam=EuxpRequestParam.builder()
                .epsd_id(synopsisPageRequestDto.getEpsd_id())
                .IF(synopsisPageRequestDto.getIF())
                .menu_stb_svc_id(synopsisPageRequestDto.getEuxp_menu_stb_svc_id())
                .search_type(synopsisPageRequestDto.getEuxp_search_type())
                .stb_id(synopsisPageRequestDto.getStb_id())
                .yn_recent(synopsisPageRequestDto.getEuxp_yn_recent()).build();
        EuxpSynopsisResponseDto euxpSynopsisResponseDto= euxpService.callEuxpResponse(euxpRequestParam);

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
        ScsDirectviewResponseDto scsDirectviewResponseDto= scsService.callScsDirectviewResponse(scsDirectviewRequestDto);

        SmdRequestParam smdRequestParam=SmdRequestParam.builder()
                .m(synopsisPageRequestDto.getSmd_m())
                .IF(synopsisPageRequestDto.getIF())
                .mac_address(synopsisPageRequestDto.getMac_address())
                .series_id(synopsisPageRequestDto.getSeries_id())
                .total_yn(synopsisPageRequestDto.getSmd_total_yn())
                .stb_id(synopsisPageRequestDto.getScs_stb_id())
                .version_sw(synopsisPageRequestDto.getSmd_version_sw()).build();
        SmdLikeHateResponseDto smdLikeHateResponseDto= smdService.callSmdLikeHateResponse(smdRequestParam);

        //TODO building
        SynopsisPageResponseDto synopsisPageResponseDto=SynopsisPageResponseDto.builder()
                .euxpSynopsis(euxpSynopsisResponseDto)
                .scsDirectview(scsDirectviewResponseDto)
                .smdLikeHate(smdLikeHateResponseDto).build();
        return synopsisPageResponseDto;
    }
}
