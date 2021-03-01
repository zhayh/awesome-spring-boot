package com.example.spring.restful.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author : zhayh
 * @date : 2021-3-1 16:57
 * @description :
 */


//@Configuration
//@EnableSwagger2  // 开启SwaggerAPI文档相关的功能
public class SwaggerConfig {
    /**
     * 配置接口文档的title、描述、服务协议、版本等信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot利用swagger构建api文档")
                .description("简单优雅的restful风格")
                .termsOfServiceUrl("http://www.niit.com")
                .version("1.0")
                .build();
    }

    /**
     * basePackage()：表示扫描哪个package下面的Controller类作为API接口文档的内容范围
     * paths()：表示 那个请求路径下控制器的映射方法，作为API接口文件的内容范围
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.spring.restful"))
                .paths(PathSelectors.regex("/rest/.*"))
                .build();
    }
}

// 生产环境禁用
// @Profile({"dev", "test"})
// @ConditionalOnProperty(name = "swagger.enable", havingValue = "true")
