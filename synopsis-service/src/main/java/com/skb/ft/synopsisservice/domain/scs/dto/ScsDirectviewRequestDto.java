package com.skb.ft.synopsisservice.domain.scs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScsDirectviewRequestDto {
    public String response_format;
    public String ver;
    public String stb_id;
    public String hash_id;
    public String ui_name;
    public String sris_id;
    public String synopsis_type;
    public List<PpvProductRequestDto> ppv_products;
}

