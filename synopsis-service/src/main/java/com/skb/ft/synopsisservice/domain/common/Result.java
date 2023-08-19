package com.skb.ft.synopsisservice.domain.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class Result {
    String api;
    String result;
    String reason;

    public Result(String api, String result, String reason) {
        this.api = api;
        this.result = result;
        this.reason = reason;
    }
}
