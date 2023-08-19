package com.skb.ft.synopsisservice.global.error;

import feign.RetryableException;
import graphql.GraphQLError;
import graphql.execution.AbortExecutionException;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.net.BindException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @GraphQlExceptionHandler
    public GraphQLError bindErrorHandle(BindException ex) {
        return GraphQLError.newError().errorType(ErrorType.BAD_REQUEST).message("데이터 바인드 과정이 옳지 않습니다").build();
    }
    @GraphQlExceptionHandler
    public GraphQLError GraphQlError(Exception e){
        return GraphQLError.newError().message(e.getMessage()).build();
    }
}
