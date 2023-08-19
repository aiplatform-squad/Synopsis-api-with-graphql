package com.skb.ft.synopsisservice.domain.synopsis.vo;

import com.skb.ft.synopsisservice.domain.euxp.vo.StillCut;
import com.skb.ft.synopsisservice.domain.common.YN;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayInfo {
    YN yn_directView;
    String trailer_url;
    List<StillCut> stillCuts;
    String three_min_preview_url;
    String cw_call_id;
}
