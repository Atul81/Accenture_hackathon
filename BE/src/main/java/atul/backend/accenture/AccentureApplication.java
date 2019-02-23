package atul.backend.accenture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@SpringBootApplication
@IntegrationComponentScan
@EnableIntegration
public class AccentureApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccentureApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Docket allApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("ALL Services").apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("atul.backend.accenture.controller")).paths(regex("/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Accenture Hackathon Customer Experience Theme").description("Accenture Hackathon")
                .contact(new Contact("Atul,  Rajeev , Shujaat", "+91-9411355956", "atulkp.eee13@nituk.ac.in"))
                .license("Licensed with Atul").version("SnapShot 1").build();
    }

}
