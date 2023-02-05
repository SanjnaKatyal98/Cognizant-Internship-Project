package com.cts.dailyshareprice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients
@EnableSwagger2
public class DailySharePriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailySharePriceApplication.class, args);
	}
	@Bean
    public Docket configureSwagger() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .paths(PathSelectors.ant("/DailySharePrice/**")) 
                .apis(RequestHandlerSelectors.basePackage("com.cts.dailyshareprice.controller")).build()
                .apiInfo(apiInfo());
    }
 
    private ApiInfo apiInfo() {
        return new ApiInfo("DailySharePrice Api", "Sample API for DailySharePrice", "1.0", "path/to/terms",
                new Contact("Portfolio", "http://www.google.com", "Portfolio@gmail.com"), "API License",
                "http://www.google.com", Collections.emptyList());
    }

}
