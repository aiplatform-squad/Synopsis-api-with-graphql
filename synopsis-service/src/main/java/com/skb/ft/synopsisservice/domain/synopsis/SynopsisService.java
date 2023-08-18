package com.skb.ft.synopsisservice.domain.synopsis;

import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface SynopsisService {
    SynopsisPageResponseDto getSynopsisPage(SynopsisPageRequestDto synopsisPageRequestDto);
}
