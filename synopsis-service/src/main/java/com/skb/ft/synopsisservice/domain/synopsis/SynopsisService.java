package com.skb.ft.synopsisservice.domain.synopsis;

import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageResponseDto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface SynopsisService {
    SynopsisPageResponseDto getSynopsisPage(SynopsisPageRequestDto synopsisPageRequestDto);
}
