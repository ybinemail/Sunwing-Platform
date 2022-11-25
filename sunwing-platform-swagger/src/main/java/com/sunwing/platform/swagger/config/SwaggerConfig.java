package com.sunwing.platform.swagger.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configurable
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean(value = "SunWingApi")
    public Docket SunWingApi(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("2.X 版本")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sunwing.*.*.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder().version("1.0.0")
                .title("spring cloud swagger2")
                .description("spring cloud swagger2 文档说明")
                .termsOfServiceUrl("www.sunwing.com")
                .build();
    }
}
