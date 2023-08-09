package com.skb.ft.synopsisservice.domain.scs.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class usePpvOmniPpmInfo {
    public String omni_m_pid;
    public String omni_m_pname;
    public String omni_m_total_count;
    public String omni_m_use_count;
    public String omni_m_rest_count;
    public String omni_m_rest_count_valid_date;
}
