package com.skb.ft.synopsisservice.domain.synopsis.vo;

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
    String title;
    float like_rate;
    String synopsis_content;
    String release_year;
    String watch_level;
    int running_time;
    String available_resolution;
    List<String> prize_history;
    List<String> directors;
    List<String> actors;
}
