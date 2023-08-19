package com.skb.ft.synopsisservice.domain.synopsis;

import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewResponseDto;
import com.skb.ft.synopsisservice.domain.smd.dto.SmdLikeHateResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.vo.PlayInfo;
import com.skb.ft.synopsisservice.domain.synopsis.vo.PurchaseInfo;
import com.skb.ft.synopsisservice.domain.synopsis.vo.SynopsisInfo;
import org.springframework.stereotype.Service;

@Service
public interface SynopsisService {
    SynopsisPageResponseDto getSynopsisPage(SynopsisPageRequestDto synopsisPageRequestDto);

    SynopsisInfo buildSynopsisInfo(EuxpSynopsisResponseDto euxpSynopsisResponseDto, SmdLikeHateResponseDto smdLikeHateResponseDto);

    PlayInfo builePlayInfo(EuxpSynopsisResponseDto euxpSynopsisResponseDto, ScsDirectviewResponseDto scsDirectviewResponseDto);

    PurchaseInfo purchaseInfo(EuxpSynopsisResponseDto euxpSynopsisResponseDto, ScsDirectviewResponseDto scsDirectviewResponseDto);
}
