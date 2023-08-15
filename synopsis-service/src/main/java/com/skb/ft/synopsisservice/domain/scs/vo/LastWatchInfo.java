package com.skb.ft.synopsisservice.domain.scs.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LastWatchInfo {
    public String ris_id;
    public String epsd_id;
    public String epsd_rslu_id;
    public String trans_type;
    public String watch_rt;
    public String watch_time;
}
