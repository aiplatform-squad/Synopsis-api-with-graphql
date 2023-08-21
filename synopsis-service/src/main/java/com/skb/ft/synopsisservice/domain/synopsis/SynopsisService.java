package com.skb.ft.synopsisservice.domain.synopsis;

import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewResponseDto;
import com.skb.ft.synopsisservice.domain.smd.dto.SmdLikeHateResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageRequestDto;
import com.skb.ft.synopsisservice.domain.synopsis.dto.SynopsisPageResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.vo.*;
import org.springframework.stereotype.Service;

@Service
public interface SynopsisService {
    SynopsisPageResponseDto getSynopsisPage(SynopsisPageRequestDto synopsisPageRequestDto);

    SynopsisInfo buildSynopsisInfo(EuxpSynopsisResponseDto euxpSynopsisResponseDto, SmdLikeHateResponseDto smdLikeHateResponseDto);

    PlayInfo buildPlayInfo(EuxpSynopsisResponseDto euxpSynopsisResponseDto, ScsDirectviewResponseDto scsDirectviewResponseDto);

    PurchaseInfo buildPurchaseInfo(EuxpSynopsisResponseDto euxpSynopsisResponseDto, ScsDirectviewResponseDto scsDirectviewResponseDto);

    TitleContent buildTitle(EuxpSynopsisResponseDto euxpSynopsisResponseDto);

    UserActivity buildUserActivity(SmdLikeHateResponseDto smdLikeHateResponseDto);
    public SynopsisPageResponseDto getSynopsisPageWebClient(SynopsisPageRequestDto synopsisPageRequestDto) ;
}
