package com.skb.ft.synopsisservice.domain.smd;

import com.skb.ft.synopsisservice.domain.smd.client.SmdRequestParam;
import com.skb.ft.synopsisservice.domain.smd.dto.SmdLikeHateResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface SmdService {
    public SmdLikeHateResponseDto callSmdLikeHateResponse(SmdRequestParam smdRequestParam);
    SmdLikeHateResponseDto loadSmdSynopsisPage(SynopsisPageRequestDto synopsisPageRequestDto);
}
