package com.api.msuser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;



@Configuration
public class OpenApiConfiguration {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("")
                .version("1.0.0")
                .build();
    }
    @Bean
    public UiConfiguration uiConfig(){
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                .showExtensions(false)
                .filter(false)
                .build();
    }
}
