package com.skb.ft.synopsisservice.domain.smd.dto;

import com.skb.ft.synopsisservice.domain.common.YN;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmdRequestParamDto {
    String stb_id;
    String IF;
    String m;
    String series_id;
    String version_sw;
    String mac_address;
    YN total_yn;
}
