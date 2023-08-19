package com.skb.ft.synopsisservice.domain.euxp.dto;

import com.skb.ft.synopsisservice.domain.common.YN;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EuxpRequestParamDto {
    String stb_id;
    String IF;
    String search_type;
    YN yn_recent;
    String menu_stb_svc_id;
    String epsd_id;
}

