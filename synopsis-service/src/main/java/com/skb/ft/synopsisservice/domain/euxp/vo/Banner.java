package com.skb.ft.synopsisservice.domain.euxp.vo;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Banner {
    String	menu_nm	;
    String	        scn_mthd_cd	;
    String	lim_lvl_yn	;
    String	        bnr_on_img_path	;
    String	bnr_off_img_path	;
    String	        vas_svc_id	;
    String	vas_itm_id	;
    String	        vas_id	;
    String	bnr_det_typ_cd	;
    String	        call_typ_cd	;
    String	call_url	;
    String	        cw_call_id_val	;
    String	synon_typ_cd	;
    String	        cnts_typ_cd	;
    String	shcut_sris_id	;
    String	        shcut_epsd_id	;
    String	shcut_menu_id	;
    String	        bnr_expl	;
    String	exps_rslu_cd	;
    String	        bnr_epsd_rslu_id	;
    String	epsd_id	;
    String	        bnr_typ_cd	;
    String	prd_prc_id	;
    String	        prd_typ_cd	;
    String	asis_prd_typ_cd	;
    String	        sale_prc	;
    int	sale_prc_vat	;
    int	        prd_prc	;
    int	prd_prc_vat	;
    int	        is_compound_prd	;
}
