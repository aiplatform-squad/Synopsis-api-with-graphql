package com.skb.ft.synopsisservice.domain.synopsis.vo;

import com.skb.ft.synopsisservice.global.common.YN;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserActivity {
    YN yn_like;
    YN yn_dislike;
    YN yn_bookmark;
}
