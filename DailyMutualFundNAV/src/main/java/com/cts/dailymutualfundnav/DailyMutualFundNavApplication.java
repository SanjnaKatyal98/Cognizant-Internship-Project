package com.cts.dailymutualfundnav;

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
public class DailyMutualFundNavApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyMutualFundNavApplication.class, args);
	}
	@Bean
    public Docket configureSwagger() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .paths(PathSelectors.ant("/DailyMutualFundNAV/**")) 
                .apis(RequestHandlerSelectors.basePackage("com.cts.dailymutualfundnav.controller")).build()
                .apiInfo(apiInfo());
    }
 
    private ApiInfo apiInfo() {
        return new ApiInfo("DailyMutualFund Api", "Sample API for DailyMutualFund", "1.0", "path/to/terms",
                new Contact("Portfolio", "http://www.google.com", "Portfolio@gmail.com"), "API License",
                "http://www.google.com", Collections.emptyList());
    }
}
