package cn.tedu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 创建接口文档的具体信息
                .apiInfo(apiInfo())
                // 创建选择器，控制哪些接口被加入文档
                .select()
                // 指定此包下的接口被加入文档
                .apis(RequestHandlerSelectors.basePackage("cn.tedu.controller"))//重点
                // 允许匹配所有的路径
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("接口文档标题")
                // 文档描述
                .description("文档内容描述")
                // 服务条款URL
                .termsOfServiceUrl("http://www.xxx.com")
                // 联系人信息
                .contact(new Contact("baobao", "http://baobao.com", "baobao@qq.com"))
                // 版本
                .version("1.0")
                .build();
    }
}
