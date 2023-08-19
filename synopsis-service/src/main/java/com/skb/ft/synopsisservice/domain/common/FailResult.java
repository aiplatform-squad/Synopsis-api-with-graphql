package com.skb.ft.synopsisservice.domain.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class FailResult extends Result{
    String errorMessage;
    public FailResult(Result result, String message) {
        super(result.api, result.result, result.reason);
        this.errorMessage = message;
    }
}
