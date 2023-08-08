package com.skb.ft.synopsisservice.domain.smd.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skb.ft.synopsisservice.domain.euxp.vo.Contents;
import com.skb.ft.synopsisservice.domain.euxp.vo.Purchare;
import com.skb.ft.synopsisservice.domain.euxp.vo.StillCut;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmdGetLikeHateResponseDto {
    public String result;
    public String reason;
    public String IF;
    public String like;
    public String dislike;
    public String updateDate;
    public String like_total;
    public String dislike_total;
    public String updateDate_total;
}
