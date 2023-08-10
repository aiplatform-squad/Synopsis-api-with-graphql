package com.skb.ft.synopsisservice.domain.euxp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.skb.ft.synopsisservice.domain.euxp.vo.Contents;
import com.skb.ft.synopsisservice.domain.euxp.vo.Purchare;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EuxpSynopsisResponseDto {
    public String result;
    public String reason;
    public String request_time;
    public Contents contents;
    public ArrayList<Purchare> purchares;
    public ArrayList<Object> series;
    public int total_banner_count;
    public String response_time;
    @JsonProperty("IF")
    public String iF;
    public ArrayList<Object> banners;
}
