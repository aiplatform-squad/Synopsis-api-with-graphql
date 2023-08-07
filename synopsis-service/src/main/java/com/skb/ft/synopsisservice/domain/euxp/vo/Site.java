package com.skb.ft.synopsisservice.domain.euxp.vo;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
@Data
@Builder
public class Site {
    public String site_cd;
    public String site_nm;
    public int bas_pnt;
    public double avg_pnt;
    public int review_cnt;
    public ArrayList<Object> reviews;
    public ArrayList<DistInfo> dist_info;
}
