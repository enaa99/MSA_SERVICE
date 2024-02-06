package com.membership;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@OpenAPIDefinition(
        info=@Info(title = "membership_service",
        description="membership service 명세",
        version="v1")
)
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi chatOpenApi() {
        String[] paths = {"com.membership"};
        return GroupedOpenApi.builder()
                .group("MEMBERSHIP API v1")
                .pathsToMatch(paths)
                .build();
    }

}
