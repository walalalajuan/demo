package com.example.demo.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Alan.Juan
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.info.title}")
    private String apiTitle;
    @Value("${swagger.info.description}")
    private String apiDescription;
    @Value("${swagger.info.version}")
    private String apiVersion;
    @Value("${swagger.info.license}")
    private String apiLicense;

    @Bean
    public Docket initializeApiByController() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build()
                .apiInfo(customizeApiInfo());
    }

    @Bean
    public UiConfiguration uiConfiguration() {
        return UiConfigurationBuilder
                .builder()
                .operationsSorter(OperationsSorter.ALPHA)
                .build();
    }

    @Bean
    public ApiInfo customizeApiInfo() {
        return new ApiInfo(
                apiTitle,
                apiDescription,
                apiVersion,
                "",
                ApiInfo.DEFAULT_CONTACT,
                apiLicense,
                "",
                Collections.emptyList());
    }

}