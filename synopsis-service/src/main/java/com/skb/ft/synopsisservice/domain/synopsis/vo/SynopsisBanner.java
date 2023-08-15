package com.skb.ft.synopsisservice.domain.synopsis.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SynopsisBanner {
    String banner_text_image;
    String banner_PLCC;
}
