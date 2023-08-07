package com.skb.ft.synopsisservice.domain.euxp.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TmdbPntInfo {
    public double tmdb_pnt;
    public int tmdb_pnt_user_ncnt;
}
