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
    String banner_on_image_path;
    String banner_off_image_path;
}
