package com.skb.ft.synopsisservice.domain.smd;

import com.skb.ft.synopsisservice.domain.smd.dto.SmdRequestParamDto;
import com.skb.ft.synopsisservice.domain.smd.dto.SmdLikeHateResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface SmdService {
    public SmdLikeHateResponseDto callSmdLikeHateResponse(SmdRequestParamDto smdRequestParamDto);
    SmdLikeHateResponseDto loadSmdSynopsisPage(SynopsisPageRequestDto synopsisPageRequestDto);
    public SmdLikeHateResponseDto callSmdLikeHateResponseWebClient(SmdRequestParamDto smdRequestParamDto);
    SmdLikeHateResponseDto loadSmdSynopsisPageWebClient(SynopsisPageRequestDto synopsisPageRequestDto);
}
