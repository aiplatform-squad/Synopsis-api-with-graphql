package com.skb.ft.synopsisservice.domain.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class SuccessResult extends Result{

    public SuccessResult(Result result) {
        super(result.api, result.result, result.reason);
    }
}
