package com.skb.ft.synopsisservice.domain.smd.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmdLikeHateResponseDto {
    public String result;
    public String reason;
    public String IF;
    public String like;
    public String dislike;
    public String updateDate;
    public String like_total;
    public String dislike_total;
    public String updateDate_total;
    public int like_rate;
}
