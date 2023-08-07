package com.skb.ft.synopsisservice.domain.euxp.client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EuxpRequestParam {
    String stb_id;
    String IF;
    String search_type;
    YN yn_recent;
    String menu_stb_svc_id;
    String epsd_id;
}

enum YN {
    Y,
    N
}