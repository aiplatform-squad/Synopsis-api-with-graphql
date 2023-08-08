package com.skb.ft.synopsisservice.domain.smd.client;

import com.skb.ft.synopsisservice.global.common.YN;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SmdRequestParam {
    String stb_id;
    String IF;
    String m;
    String series_id;
    String version_sw;
    String mac_address;
    YN total_yn;
}
