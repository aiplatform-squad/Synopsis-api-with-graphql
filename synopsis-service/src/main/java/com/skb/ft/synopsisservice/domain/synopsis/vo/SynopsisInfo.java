package com.skb.ft.synopsisservice.domain.synopsis.vo;

import com.skb.ft.synopsisservice.domain.euxp.vo.Site;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SynopsisInfo {
    float like_rate;
    double btv_like_rate;
    double tmdb_like_rate;
    List<Site> site_reviews;
    String summary;
    String release_year;
    String watch_level;
    int running_time;
    String available_resolution;
    List<Object> prize_history;
    String directors;
    String actors;
}
