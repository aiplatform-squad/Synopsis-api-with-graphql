package com.skb.ft.synopsisservice.domain.synopsis;

import com.skb.ft.synopsisservice.domain.euxp.EuxpService;
import com.skb.ft.synopsisservice.domain.euxp.client.EuxpRequestParam;
import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.domain.euxp.vo.Banner;
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
import com.skb.ft.synopsisservice.domain.synopsis.vo.SynopsisBanner;
import com.skb.ft.synopsisservice.domain.synopsis.vo.SynopsisInfo;
import com.skb.ft.synopsisservice.global.common.YN;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SynopsisServiceImpl implements SynopsisService{
    private final EuxpService euxpService;
    private final ScsService scsService;
    private final SmdService smdService;

@Override
    public SynopsisPageResponseDto getSynopsisPage(SynopsisPageRequestDto synopsisPageRequestDto) {
        EuxpSynopsisResponseDto euxpSynopsisResponseDto= euxpService.loadEuxpSynopsisPage(synopsisPageRequestDto);
        ScsDirectviewResponseDto scsDirectviewResponseDto=scsService.loadSmdSynopsisPage(synopsisPageRequestDto);
        SmdLikeHateResponseDto smdLikeHateResponseDto= smdService.loadSmdSynopsisPage(synopsisPageRequestDto);

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
        if(euxpSynopsisResponseDto.getTotal_banner_count()!=0){
            synopsisPageResponseDto.setSynopsis_banners(this.banner(euxpSynopsisResponseDto.getBanners()));
        }
        return synopsisPageResponseDto;
    }

    List<SynopsisBanner> banner(List<Banner> banners){
    if(banners==null){
        return null;
    }
        List<SynopsisBanner> synopsisBanners=new ArrayList<>();
        for (Banner b: banners) {
            synopsisBanners.add(SynopsisBanner.builder()
                    .banner_off_image_path(b.getBnr_off_img_path())
                    .banner_on_image_path(b.getBnr_on_img_path()).build());
        }
        return synopsisBanners;
    }

}
