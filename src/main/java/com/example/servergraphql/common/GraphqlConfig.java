package com.example.servergraphql.common;

import graphql.scalars.ExtendedScalars;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphqlConfig {




        @Bean
        public RuntimeWiringConfigurer runtimeWiringConfigurer() {
            return wiringBuilder -> wiringBuilder
                    .scalar(ExtendedScalars.Date)
                    .scalar(ExtendedScalars.DateTime)
                    .scalar(ExtendedScalars.GraphQLBigDecimal);

        }




}
