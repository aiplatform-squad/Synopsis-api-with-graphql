package com.skb.ft.synopsisservice.domain.euxp.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BtvPntInfo {
    public double btv_pnt;
    public int btv_like_ncnt;
    public double btv_like_rate;
    public int btv_ngood_ncnt;
    public double btv_ngood_rate;
}
