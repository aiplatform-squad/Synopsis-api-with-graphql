package com.skb.ft.synopsisservice.domain.scs.vo;

import com.skb.ft.synopsisservice.global.common.YN;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
        public String prd_prc_id;
        public String epsd_id;
        public YN yn_directview;
        public YN yn_purchase;
        public Object end_date;
        public Object end_date_hhmm;
        public String period;
        public String period_hour;
        public String period_min;
        public YN yn_recv_gift;
        public String recv_gift_sts_cd;
        public String ppm_free_join_yn;
        public String ppm_free_join_perd_cd;
        public String ppm_free_join_perd_end_dt;
        public List<usePpvOmniPpmInfo> use_ppv_omni_ppm_info;
}
