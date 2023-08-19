package com.skb.ft.synopsisservice.domain.synopsis;

import com.skb.ft.synopsisservice.domain.common.YN;
import com.skb.ft.synopsisservice.domain.euxp.EuxpService;
import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.domain.euxp.vo.Banner;
import com.skb.ft.synopsisservice.domain.euxp.vo.Content;
import com.skb.ft.synopsisservice.domain.scs.ScsService;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewResponseDto;
import com.skb.ft.synopsisservice.domain.smd.SmdService;
import com.skb.ft.synopsisservice.domain.smd.dto.SmdLikeHateResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.vo.*;
import com.skb.ft.synopsisservice.domain.common.FailResult;
import com.skb.ft.synopsisservice.domain.common.Result;
import com.skb.ft.synopsisservice.domain.common.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class SynopsisServiceImpl implements SynopsisService{
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
        PlayInfo playInfo = this.buildPlayInfo(euxpSynopsisResponseDto, scsDirectviewResponseDto);
        PurchaseInfo purchaseInfo = this.buildPurchaseInfo(euxpSynopsisResponseDto, scsDirectviewResponseDto);
        TitleContent title=this.buildTitle(euxpSynopsisResponseDto);
        UserActivity userActivity=this.buildUserActivity(smdLikeHateResponseDto);


        SynopsisPage synopsisPage = SynopsisPage.builder()
                .euxpSynopsis(euxpSynopsisResponseDto)
                .scsDirectview(scsDirectviewResponseDto)
                .smdLikeHate(smdLikeHateResponseDto)
                .synopsis_type(euxpSynopsisResponseDto.getSeries().isEmpty()? SynopsisType.SHORTS:SynopsisType.SEASON)
                .title(title)
                .synopsisInfo(synopsisInfo)
                .userActivity(userActivity)
                .playInfo(playInfo)
                .purchaseInfo(purchaseInfo)
                .series(euxpSynopsisResponseDto.getSeries())
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
            Content contents=euxpSynopsisResponseDto.getContents();
            synopsisInfo = SynopsisInfo.builder()
                    .summary(contents.getSris_snss_cts())
                    .release_year(contents.getOpen_yr())
                    .watch_level(contents.getWat_lvl_cd())
                    .running_time(Integer.parseInt(contents.getPlay_tms_val()))
                    .prize_history(contents.getSite_review().getPrize_history())
                    .directors(contents.getDirector())
                    .actors(contents.getActor())
                    .available_resolution(contents.getEpsd_rslu_info().get(0).getRslu_typ_cd())
                    .btv_like_rate(contents.getSite_review().getBtv_pnt_info().get(0).getBtv_like_rate())
                    .tmdb_like_rate(contents.getSite_review().getTmdb_pnt_info().getTmdb_pnt())
                    .site_reviews(contents.getSite_review().getSites())
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
    public PlayInfo buildPlayInfo(EuxpSynopsisResponseDto euxpSynopsisResponseDto, ScsDirectviewResponseDto scsDirectviewResponseDto) {
        PlayInfo playInfo;
        if (Objects.isNull(euxpSynopsisResponseDto.getErrorMessage()) && "0000".equals(euxpSynopsisResponseDto.getResult())) {
            playInfo = PlayInfo.builder()
                    .trailer_url(euxpSynopsisResponseDto.getContents().getPreview().get(0).getRtsp_cnt_url())
                    .stillCuts(euxpSynopsisResponseDto.getContents().getStillCut())
                    .three_min_preview_url(euxpSynopsisResponseDto.getContents().getPreview().get(0).rtsp_cnt_url)
                    .cw_call_id(euxpSynopsisResponseDto.getContents().getCw_call_id())
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
    public PurchaseInfo buildPurchaseInfo(EuxpSynopsisResponseDto euxpSynopsisResponseDto, ScsDirectviewResponseDto scsDirectviewResponseDto) {
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

    @Override
    public TitleContent buildTitle(EuxpSynopsisResponseDto euxpSynopsisResponseDto) {
        TitleContent titleContent;
        if (Objects.isNull(euxpSynopsisResponseDto.getErrorMessage()) && "0000".equals(euxpSynopsisResponseDto.getResult())) {
            titleContent= TitleContent.builder().title_img(euxpSynopsisResponseDto.getContents().getTitle()).title_txt(euxpSynopsisResponseDto.getContents().getTitle_img_path()).build();
        }else{
            titleContent=null;
        }
        return titleContent;
    }

    @Override
    public UserActivity buildUserActivity(SmdLikeHateResponseDto smdLikeHateResponseDto) {
        UserActivity userActivity;
        if (Objects.isNull(smdLikeHateResponseDto.getErrorMessage()) && "OK".equals(smdLikeHateResponseDto.getResult())) {
            userActivity=UserActivity.builder().yn_like(smdLikeHateResponseDto.getLike().equals("1")? YN.Y:YN.N)
                    .yn_dislike(smdLikeHateResponseDto.getDislike().equals("1")? YN.Y:YN.N)
                    .build();
        }else{
            userActivity=null;
        }
        return userActivity;
    }

    List<SynopsisBanner> banner(List<Banner> banners) {
        if (banners == null) {
            return null;
        }
        List<SynopsisBanner> synopsisBanners = new ArrayList<>();
        for (Banner b : banners) {
            synopsisBanners.add(SynopsisBanner.builder()
                    .banner_off_image_path(b.getBnr_off_img_path())
                    .banner_on_image_path(b.getBnr_on_img_path())
                    .banner_typ_code(b.getBnr_typ_cd())
                    .call_url(b.getCall_url()).build());
        }
        return synopsisBanners;
    }

}
