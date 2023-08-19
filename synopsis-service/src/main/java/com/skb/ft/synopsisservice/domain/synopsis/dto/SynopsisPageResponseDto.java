package com.skb.ft.synopsisservice.domain.synopsis.dto;

import com.skb.ft.synopsisservice.domain.synopsis.vo.SynopsisPage;
import com.skb.ft.synopsisservice.global.common.Result;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class SynopsisPageResponseDto {
    List<Result>  result;
    SynopsisPage synopsisPage;
}