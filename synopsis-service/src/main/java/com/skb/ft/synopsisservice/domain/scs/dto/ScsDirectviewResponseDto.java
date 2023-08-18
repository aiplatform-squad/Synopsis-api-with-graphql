package com.skb.ft.synopsisservice.domain.scs.dto;

import com.skb.ft.synopsisservice.domain.scs.vo.LastWatchInfo;
import com.skb.ft.synopsisservice.domain.scs.vo.Product;
import com.skb.ft.synopsisservice.global.common.YN;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScsDirectviewResponseDto {
    public String IF;
    public String ver;
    public String ui_name;
    public String svc_name;
    public String result;
    public String reason;
    public String stb_id;
    public String mobile_id;
    public String is_bookmark;
    public YN yn_season_watch_all;
    public List<Product> ppv_products;
    public List<Product> pps_products;
    public LastWatchInfo last_watch_info;
}
