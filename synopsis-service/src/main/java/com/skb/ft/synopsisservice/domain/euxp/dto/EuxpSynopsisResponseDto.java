package com.skb.ft.synopsisservice.domain.euxp.dto;

import com.skb.ft.synopsisservice.domain.euxp.vo.Banner;
import com.skb.ft.synopsisservice.domain.euxp.vo.Content;
import com.skb.ft.synopsisservice.domain.euxp.vo.Purchare;
import lombok.*;

import java.util.ArrayList;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EuxpSynopsisResponseDto {
    public String result;
    public String reason;
    public String request_time;
    public Content contents;
    public ArrayList<Purchare> purchares;
    public ArrayList<Object> series;
    public int total_banner_count;
    public String response_time;
    public String IF;
    public ArrayList<Banner> banners;
}
