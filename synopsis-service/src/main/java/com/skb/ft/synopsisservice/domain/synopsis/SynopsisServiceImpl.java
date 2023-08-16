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
import com.skb.ft.synopsisservice.domain.synopsis.vo.PlayInfo;
import com.skb.ft.synopsisservice.domain.synopsis.vo.PurchaseInfo;
import com.skb.ft.synopsisservice.domain.synopsis.vo.SynopsisInfo;
import com.skb.ft.synopsisservice.global.common.YN;
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
        SynopsisPageResponseDto synopsisPageResponseDto
                =SynopsisPageResponseDto.builder()
                .euxpSynopsis(euxpSynopsisResponseDto)
                .scsDirectview(scsDirectviewResponseDto)
                .smdLikeHate(smdLikeHateResponseDto)
                .synopsisInfo(
                        SynopsisInfo.builder()
                                .title(euxpSynopsisResponseDto.getContents().getTitle())
                                .like_rate(smdLikeHateResponseDto.getLike_rate())
                                .synopsis_content(euxpSynopsisResponseDto.getContents().getSris_snss_cts())
                                .release_year(euxpSynopsisResponseDto.getContents().getOpen_yr())
                                .watch_level(euxpSynopsisResponseDto.getContents().getWat_lvl_cd())
                                .running_time(Integer.parseInt(euxpSynopsisResponseDto.getContents().getPlay_time()))
                                .prize_history(euxpSynopsisResponseDto.getContents().getSite_review().getPrize_history())
                                .directors(euxpSynopsisResponseDto.getContents().getDirector())
                                .actors(euxpSynopsisResponseDto.getContents().getActor())
                                .available_resolution(euxpSynopsisResponseDto.getContents().getEpsd_rslu_info().get(0).getRslu_typ_cd())
                                .build()
                )
                .playInfo(
                        PlayInfo.builder()
                                .preview_url(euxpSynopsisResponseDto.getContents().getPreview().get(0).getRtsp_cnt_url())
                                .yn_directView(scsDirectviewResponseDto.getPpv_products().get(0).getYn_directview())
                                .build())
                .purchaseInfo(
                        PurchaseInfo.builder()
                                .yn_purchase(scsDirectviewResponseDto.getPpv_products().get(0).getYn_purchase())
                                .avail_period(scsDirectviewResponseDto.getPpv_products().get(0).getPeriod())
                                .sale_price_vat(euxpSynopsisResponseDto.getPurchares().get(0).getSale_prc_vat())
                                .build()
                )
                .build();
        return synopsisPageResponseDto;
    }


}
