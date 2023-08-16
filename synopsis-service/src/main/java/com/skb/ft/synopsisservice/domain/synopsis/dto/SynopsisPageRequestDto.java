package com.skb.ft.synopsisservice.domain.synopsis.dto;

import com.skb.ft.synopsisservice.domain.scs.dto.PpvProductRequestDto;
import com.skb.ft.synopsisservice.global.common.YN;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SynopsisPageRequestDto {
    private String IF;
    private String stb_id;
    private String series_id;
    private String mac_address;
    private String smd_m;
    private YN smd_total_yn;
    private String smd_version_sw;
    private String epsd_id;
    private String euxp_menu_stb_svc_id;
    private String euxp_search_type;
    private YN euxp_yn_recent;
    private String scs_stb_id;
    private String scs_response_format;
    private String scs_ver;
    private String scs_hash_id;
    private String scs_ui_name;
    private String scs_synopsis_type;
    private List<PpvProductRequestDto> scs_ppv_products;
}
