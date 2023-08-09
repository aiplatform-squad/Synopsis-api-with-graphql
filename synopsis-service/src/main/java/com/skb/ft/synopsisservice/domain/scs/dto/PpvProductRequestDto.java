package com.skb.ft.synopsisservice.domain.scs.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize
public class PpvProductRequestDto{
    public String prd_prc_id;
    public String yn_prd_nscreen;
    public String prd_typ_cd;
    public String purc_pref_rank;
    public String possn_yn;
    public String epsd_id;

}
