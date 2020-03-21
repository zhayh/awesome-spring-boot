package com.spring.api.swagger.config;

import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhayh
 * @date : 2020-3-20 16:03
 * @description : Swagger配置类
 */
@Data
@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix="swagger")
public class SwaggerConfig {
    private String title;
    private String desc;
    private String version;
    private String termsOfServiceUrl;
    private String license;
    private String licenseUrl;
    private String basePackage;
    private String groupName;
    private String contactName;
    private String contactUrl;
    private String contactEmail;

    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName(groupName)
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.POST, customerResponseMessage())
                .globalResponseMessage(RequestMethod.GET, customerResponseMessage())
                .forCodeGeneration(true).select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }
    /**
     * 配置页面展示的基本信息：标题、描述、版本、服务条款、联系方式等
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("消息管理")
                .description("消息管理 API 操作文档")
                .termsOfServiceUrl("http://localhost:8080")
                .contact(new Contact("niit", "http://www.niit.com", "admin@niit.com"))
                .version("1.0")
                .build();
    }

    private List<ResponseMessage> customerResponseMessage() {
        List<ResponseMessage> list = new ArrayList<>();
        list.add(new ResponseMessageBuilder().code(200).message("成功").build());
        list.add(new ResponseMessageBuilder().code(100).message("请求参数有误").build());
        list.add(new ResponseMessageBuilder().code(101).message("未授权").build());
        list.add(new ResponseMessageBuilder().code(102).message("禁止访问").build());
        list.add(new ResponseMessageBuilder().code(103).message("请求路径不存在").build());
        list.add(new ResponseMessageBuilder().code(104).message("服务器内部错误").build());
        return list;
    }

//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder().title(title).description(desc)
//                .version(version).termsOfServiceUrl(termsOfServiceUrl)
//                .licenseUrl(licenseUrl).license(license)
//                .contact(new Contact(contactName, contactUrl, contactEmail))
//                .build();
//    }
}
