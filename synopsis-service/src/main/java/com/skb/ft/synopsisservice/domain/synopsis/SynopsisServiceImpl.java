package com.skb.ft.synopsisservice.domain.synopsis;

import com.skb.ft.synopsisservice.domain.euxp.EuxpService;
import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.domain.euxp.vo.Banner;
import com.skb.ft.synopsisservice.domain.scs.ScsService;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewResponseDto;
import com.skb.ft.synopsisservice.domain.smd.SmdService;
import com.skb.ft.synopsisservice.domain.smd.dto.SmdLikeHateResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.vo.SynopsisPage;
import com.skb.ft.synopsisservice.domain.synopsis.vo.PlayInfo;
import com.skb.ft.synopsisservice.domain.synopsis.vo.PurchaseInfo;
import com.skb.ft.synopsisservice.domain.synopsis.vo.SynopsisBanner;
import com.skb.ft.synopsisservice.domain.synopsis.vo.SynopsisInfo;
import com.skb.ft.synopsisservice.global.common.FailResult;
import com.skb.ft.synopsisservice.global.common.Result;
import com.skb.ft.synopsisservice.global.common.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class SynopsisServiceImpl implements SynopsisService {
    private final EuxpService euxpService;
    private final ScsService scsService;
    private final SmdService smdService;

    @Override
    public SynopsisPageResponseDto getSynopsisPage(SynopsisPageRequestDto synopsisPageRequestDto) {
        EuxpSynopsisResponseDto euxpSynopsisResponseDto = euxpService.loadEuxpSynopsisPage(synopsisPageRequestDto);
        ScsDirectviewResponseDto scsDirectviewResponseDto = scsService.loadSmdSynopsisPage(synopsisPageRequestDto);
        SmdLikeHateResponseDto smdLikeHateResponseDto = smdService.loadSmdSynopsisPage(synopsisPageRequestDto);

        List<Result> resultList = new ArrayList<>();

        //EuxpResult 생성
        Result euxpResult = Result.builder()
                .api("euxpSynmopsisApi").result(euxpSynopsisResponseDto.getResult()).reason(euxpSynopsisResponseDto.getReason()).build();
        if (Objects.isNull(euxpSynopsisResponseDto.getErrorMessage())) {
            resultList.add(new SuccessResult(euxpResult));
        } else {
            resultList.add(new FailResult(euxpResult, euxpSynopsisResponseDto.getErrorMessage()));
        }

        //SCS
        Result smdResult = Result.builder()
                .api("smdLikeHateApi").result(smdLikeHateResponseDto.getResult()).reason(smdLikeHateResponseDto.getReason()).build();
        if (Objects.isNull(smdLikeHateResponseDto.getErrorMessage())) {
            resultList.add(new SuccessResult(smdResult));
        } else {
            resultList.add(new FailResult(smdResult, smdLikeHateResponseDto.getErrorMessage()));
        }

        //scs
        Result scsResult = Result.builder()
                .api("scsDirectviewApi").result(scsDirectviewResponseDto.getResult()).reason(scsDirectviewResponseDto.getReason()).build();
        if (Objects.isNull(scsDirectviewResponseDto.getErrorMessage())) {
            resultList.add(new SuccessResult(scsResult));
        } else {
            resultList.add(new FailResult(scsResult, scsDirectviewResponseDto.getErrorMessage()));
        }

        SynopsisInfo synopsisInfo = this.buildSynopsisInfo(euxpSynopsisResponseDto, smdLikeHateResponseDto);
        PlayInfo playInfo = this.builePlayInfo(euxpSynopsisResponseDto, scsDirectviewResponseDto);
        PurchaseInfo purchaseInfo = this.purchaseInfo(euxpSynopsisResponseDto, scsDirectviewResponseDto);

        SynopsisPage synopsisPage
                = SynopsisPage.builder()
                .euxpSynopsis(euxpSynopsisResponseDto)
                .scsDirectview(scsDirectviewResponseDto)
                .smdLikeHate(smdLikeHateResponseDto)
                .synopsisInfo(synopsisInfo)
                .playInfo(playInfo)
                .purchaseInfo(purchaseInfo)
                .build();

        if (euxpSynopsisResponseDto.getTotal_banner_count() != 0) {
            synopsisPage.setSynopsis_banners(this.banner(euxpSynopsisResponseDto.getBanners()));
        }
        SynopsisPageResponseDto synopsisPageResponseDto = SynopsisPageResponseDto.builder()
                .result(resultList)
                .synopsisPage(synopsisPage).build();
        return synopsisPageResponseDto;
    }

    @Override
    public SynopsisInfo buildSynopsisInfo(EuxpSynopsisResponseDto euxpSynopsisResponseDto, SmdLikeHateResponseDto smdLikeHateResponseDto) {
        SynopsisInfo synopsisInfo;
        if (Objects.isNull(euxpSynopsisResponseDto.getErrorMessage()) && "0000".equals(euxpSynopsisResponseDto.getResult())) {
            synopsisInfo = SynopsisInfo.builder()
                    .title(euxpSynopsisResponseDto.getContents().getTitle())
                    .synopsis_content(euxpSynopsisResponseDto.getContents().getSris_snss_cts())
                    .release_year(euxpSynopsisResponseDto.getContents().getOpen_yr())
                    .watch_level(euxpSynopsisResponseDto.getContents().getWat_lvl_cd())
                    .running_time(Integer.parseInt(euxpSynopsisResponseDto.getContents().getPlay_tms_val()))
                    .prize_history(euxpSynopsisResponseDto.getContents().getSite_review().getPrize_history())
                    .directors(euxpSynopsisResponseDto.getContents().getDirector())
                    .actors(euxpSynopsisResponseDto.getContents().getActor())
                    .available_resolution(euxpSynopsisResponseDto.getContents().getEpsd_rslu_info().get(0).getRslu_typ_cd())
                    .build();
        } else {
            synopsisInfo = SynopsisInfo.builder().build();
        }
        if (Objects.isNull(smdLikeHateResponseDto.getErrorMessage()) && "OK".equals(smdLikeHateResponseDto.getResult())) {
            synopsisInfo.setLike_rate(smdLikeHateResponseDto.getLike_rate());
        }
        return synopsisInfo;
    }

    @Override
    public PlayInfo builePlayInfo(EuxpSynopsisResponseDto euxpSynopsisResponseDto, ScsDirectviewResponseDto scsDirectviewResponseDto) {
        PlayInfo playInfo;
        if (Objects.isNull(euxpSynopsisResponseDto.getErrorMessage()) && "0000".equals(euxpSynopsisResponseDto.getResult())) {
            playInfo = PlayInfo.builder()
                    .preview_url(euxpSynopsisResponseDto.getContents().getPreview().get(0).getRtsp_cnt_url())
                    .build();
        }else{
            playInfo=PlayInfo.builder().build();
        }
        if(Objects.isNull(scsDirectviewResponseDto.getErrorMessage())&&"0000".equals(scsDirectviewResponseDto.getResult())){
            playInfo.setYn_directView(scsDirectviewResponseDto.getPpv_products().get(0).getYn_directview());
        }
        return playInfo;
    }

    @Override
    public PurchaseInfo purchaseInfo(EuxpSynopsisResponseDto euxpSynopsisResponseDto, ScsDirectviewResponseDto scsDirectviewResponseDto) {
        PurchaseInfo purchaseInfo;
        if (Objects.isNull(euxpSynopsisResponseDto.getErrorMessage()) && "0000".equals(euxpSynopsisResponseDto.getResult())) {
            purchaseInfo=PurchaseInfo.builder()
                    .sale_price_vat(euxpSynopsisResponseDto.getPurchares().get(0).getSale_prc_vat())
                    .build();
        }else{
            purchaseInfo=PurchaseInfo.builder().build();
        }
        if(Objects.isNull(scsDirectviewResponseDto.getErrorMessage())&&"0000".equals(scsDirectviewResponseDto.getResult())){
            purchaseInfo.setYn_purchase(scsDirectviewResponseDto.getPpv_products().get(0).getYn_purchase());
            purchaseInfo.setAvail_period(scsDirectviewResponseDto.getPpv_products().get(0).getPeriod());
        }
        return purchaseInfo;
    }

    List<SynopsisBanner> banner(List<Banner> banners) {
        if (banners == null) {
            return null;
        }
        List<SynopsisBanner> synopsisBanners = new ArrayList<>();
        for (Banner b : banners) {
            synopsisBanners.add(SynopsisBanner.builder()
                    .banner_off_image_path(b.getBnr_off_img_path())
                    .banner_on_image_path(b.getBnr_on_img_path()).build());
        }
        return synopsisBanners;
    }

}
