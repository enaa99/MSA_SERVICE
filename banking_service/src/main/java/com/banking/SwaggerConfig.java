package com.banking;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@OpenAPIDefinition(
        info=@Info(title = "register_banking_service",
        description="register_banking_service 명세",
        version="v1")
)
@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi chatOpenApi() {
        String[] paths = {"/banking/**"};
        return GroupedOpenApi.builder()
                .group("REGISTERBANK API v1")
                .pathsToMatch(paths)
                .build();
    }

}
