package com.skb.ft.synopsisservice.domain.synopsis.dto;

import com.skb.ft.synopsisservice.domain.euxp.dto.EuxpSynopsisResponseDto;
import com.skb.ft.synopsisservice.domain.scs.dto.ScsDirectviewResponseDto;
import com.skb.ft.synopsisservice.domain.smd.dto.SmdLikeHateResponseDto;
import com.skb.ft.synopsisservice.domain.synopsis.vo.PlayInfo;
import com.skb.ft.synopsisservice.domain.synopsis.vo.PurchaseInfo;
import com.skb.ft.synopsisservice.domain.synopsis.vo.SynopsisBanner;
import com.skb.ft.synopsisservice.domain.synopsis.vo.SynopsisInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SynopsisPageResponseDto {
    SynopsisInfo synopsisInfo;
    SynopsisBanner synopsis_banner;
    PurchaseInfo purchaseInfo;
    PlayInfo playInfo;
    EuxpSynopsisResponseDto euxpSynopsis;
    ScsDirectviewResponseDto scsDirectview;
    SmdLikeHateResponseDto smdLikeHate;
}
