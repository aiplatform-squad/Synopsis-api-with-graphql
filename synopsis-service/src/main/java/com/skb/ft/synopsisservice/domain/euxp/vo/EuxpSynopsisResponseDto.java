package com.skb.ft.synopsisservice.domain.euxp.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

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
