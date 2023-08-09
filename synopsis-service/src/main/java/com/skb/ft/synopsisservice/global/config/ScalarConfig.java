package com.skb.ft.synopsisservice.global.config;

import graphql.Scalars;
import graphql.scalars.ExtendedScalars;
import graphql.scalars.alias.AliasedScalar;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class ScalarConfig {
    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        GraphQLScalarType Date = ExtendedScalars.newAliasedScalar("Date").aliasedScalar(Scalars.GraphQLString).build();
        return wiringBuilder -> wiringBuilder.scalar(Date).scalar(ExtendedScalars.Json).scalar(ExtendedScalars.Object);
    }

}
