package com.skb.ft.synopsisservice.domain.euxp.vo;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TmdbPntInfo {
    public double tmdb_pnt;
    public int tmdb_pnt_user_ncnt;
}
