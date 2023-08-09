package com.skb.ft.synopsisservice.domain.smd;

import com.skb.ft.synopsisservice.domain.smd.client.SmdApiClient;
import com.skb.ft.synopsisservice.domain.smd.client.SmdRequestParam;
import com.skb.ft.synopsisservice.domain.smd.vo.SmdLikeHateResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SmdServiceImpl implements SmdService{
    private final SmdApiClient smdApiClient;
    @Override
    public SmdLikeHateResponseDto callSmdLikeHateResponse(SmdRequestParam smdRequestParam) {
        SmdLikeHateResponseDto smdLikeHateResponseDto = smdApiClient.requestSmdGetLikeHate(smdRequestParam);
        int likeTotalNum=Integer.parseInt(smdLikeHateResponseDto.getLike_total());
        int dislikeTotalNum=Integer.parseInt(smdLikeHateResponseDto.getDislike_total());
        int likeRate=calculateLikeRate(likeTotalNum, dislikeTotalNum);
        smdLikeHateResponseDto.setLike_rate(likeRate);
        return smdLikeHateResponseDto;
    }

    private int calculateLikeRate(int likeTotalNum, int dislikeTotalNum) {
        return Math.round(likeTotalNum/(likeTotalNum+dislikeTotalNum)*100);
    }
}
