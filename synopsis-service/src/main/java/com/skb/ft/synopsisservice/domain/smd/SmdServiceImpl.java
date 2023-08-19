package com.skb.ft.synopsisservice.domain.smd;

import com.skb.ft.synopsisservice.web.SmdApiClient;
import com.skb.ft.synopsisservice.domain.smd.dto.SmdRequestParamDto;
import com.skb.ft.synopsisservice.domain.smd.dto.SmdLikeHateResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
import com.skb.ft.synopsisservice.domain.common.YN;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SmdServiceImpl implements SmdService{
    private final SmdApiClient smdApiClient;
    @Override
    public SmdLikeHateResponseDto callSmdLikeHateResponse(SmdRequestParamDto smdRequestParamDto) {
        SmdLikeHateResponseDto smdLikeHateResponseDto;
        try {
            smdLikeHateResponseDto = smdApiClient.requestSmdGetLikeHate(smdRequestParamDto);
        }catch (Exception e){
           smdLikeHateResponseDto=SmdLikeHateResponseDto.builder()
                   .errorMessage(e.getMessage()).build();
           return smdLikeHateResponseDto;
        }
        if (smdRequestParamDto.getTotal_yn()== YN.Y){
        int likeTotalNum=Integer.parseInt(smdLikeHateResponseDto.getLike_total());
        int dislikeTotalNum=Integer.parseInt(smdLikeHateResponseDto.getDislike_total());
        int likeRate=calculateLikeRate(likeTotalNum, dislikeTotalNum);
        smdLikeHateResponseDto.setLike_rate(likeRate);}
        return smdLikeHateResponseDto;
    }
    @Override
    public SmdLikeHateResponseDto loadSmdSynopsisPage(SynopsisPageRequestDto synopsisPageRequestDto) {
        SmdRequestParamDto smdRequestParamDto = SmdRequestParamDto.builder()
                .m(synopsisPageRequestDto.getSmd_m())
                .IF(synopsisPageRequestDto.getIF())
                .mac_address(synopsisPageRequestDto.getMac_address())
                .series_id(synopsisPageRequestDto.getSeries_id())
                .total_yn(synopsisPageRequestDto.getSmd_total_yn())
                .stb_id(synopsisPageRequestDto.getScs_stb_id())
                .version_sw(synopsisPageRequestDto.getSmd_version_sw()).build();
        SmdLikeHateResponseDto smdLikeHateResponseDto= this.callSmdLikeHateResponse(smdRequestParamDto);
        return smdLikeHateResponseDto;
    }
    private int calculateLikeRate(int likeTotalNum, int dislikeTotalNum) {
        return Math.round(likeTotalNum*100/(likeTotalNum+dislikeTotalNum));
    }
}
