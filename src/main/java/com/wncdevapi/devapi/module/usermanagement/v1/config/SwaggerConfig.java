package com.wncdevapi.devapi.module.usermanagement.v1.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	static final String detailDescription = "The Business Banking Microservice is a RESTful API that provides PD teams with out of the box functionality for Digital Insight's Business Banking suite of products. \n \n"
			+"Below is a list of available REST API calls for business banking resources.";
	@Bean
	public Docket postsApiV1() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("usermanagement-V1").select()
				.apis(RequestHandlerSelectors
						.basePackage("com.wncdevapi.devapi.module.usermanagement.v1.controller")).paths(regex("/usermanagement/v1/.*")).build().apiInfo(metaDataV1());
	}
	
	@Bean
	public Docket postsApiV2() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("usermanagement-V2").select()
				.apis(RequestHandlerSelectors
						.basePackage("com.wncdevapi.devapi.module.usermanagement.v1.controller")).paths(regex("/usermanagement/v2/.*")).build().apiInfo(metaDataV2());
	}
	
	 private ApiInfo metaDataV1() {
	        ApiInfo apiInfo = new ApiInfo(
	                "WNC API",
	                "Address Risk API for WNC",
	                "1.0",
	                "Terms of service",
	                new Contact("Bourntec", "", ""),
	               "Apache License Version 2.0",
	                "https://www.apache.org/licenses/LICENSE-2.0");
	        return apiInfo;
	    }
	 private ApiInfo metaDataV2() {
	        ApiInfo apiInfo = new ApiInfo(
	                "WNC API",
	                "Address Risk API for WNC",
	                "2.0",
	                "Terms of service",
	                new Contact("Bourntec", "", ""),
	               "Apache License Version 2.0",
	                "https://www.apache.org/licenses/LICENSE-2.0");
	        return apiInfo;
	    }
	 
	 
	 private ApiInfo apiInfo() {
		    return new ApiInfoBuilder()
		            .title("Overview")
		            .description(detailDescription)
		            .termsOfServiceUrl("http://springfox.io")
		            .contact("springfox")
		            .license("Apache License Version 2.0")
		            .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
		            .version("1.0")
		            .build();
		}
}
