package com.skb.ft.synopsisservice.domain.smd;

import com.skb.ft.synopsisservice.domain.smd.client.SmdRequestParam;
import com.skb.ft.synopsisservice.domain.smd.vo.SmdLikeHateResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface SmdService {
    public SmdLikeHateResponseDto callSmdLikeHateResponse(SmdRequestParam smdRequestParam);
}
