package com.skb.ft.synopsisservice.domain.synopsis.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TitleContent {
    String title_img;
    String title_txt;
}
