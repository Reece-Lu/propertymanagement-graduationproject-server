package com.reecelu.pmsserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket restApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Standard interface")
                .apiInfo(apiInfo("Use Swagger to build RESTful APIs in Spring Boot", "1.0"))
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.reecelu.pmsserver.controller"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/complex"); // Set the base URL path here
    }

    /**
     * http://localhost:9091/swagger-ui/index.html
     *
     * @return
     */
    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfoBuilder()
                .title("Residential Complex Management System interface description")
                .contact(new Contact("Yuwen Lu", "https://www.meetyuwen.com", "luyuwen2000@163.com"))
                .version(version)
                .build();
    }
}
