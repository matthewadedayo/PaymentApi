package com.payment.config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


    @Configuration
    @EnableSwagger2
    @ConditionalOnProperty(value = "exo.swagger-ui.enable", havingValue = "true")
    public class SwaggerConfig  extends WebMvcConfigurerAdapter{

            @Bean
        public Docket newsApi() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                    .paths(PathSelectors.any())
                    .build();
            //.pathMapping(ExoConstants.APP_OLD_URL);
        }

        private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("BANK APIs")
                    .description("Full documentation of the bank APIs")
                    .termsOfServiceUrl("www.com")
                    .contact(new Contact("Anifannu Adedayo", "www.com", ""))
                    .version("2.0")
                    .build();
        }






        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry)
        {
            //enabling swagger-ui part for visual documentation
            registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
            registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        }

}