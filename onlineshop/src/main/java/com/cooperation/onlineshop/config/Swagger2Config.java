package com.cooperation.onlineshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;


/**
 * Swagger2配置类
 * 在与spring boot集成时，放在与Application.java同级的目录下。
 * 通过@Configuration注解，让Spring来加载该类配置。
 * 再通过@EnableSwagger2注解来启用Swagger2。
 * Author: zyg
 * Date: 2020-03-26 10:49
 * http://localhost:8080/swagger-ui.html
 */
@Configuration
@EnableSwagger2
//@Profile({"dev", "test"})// @Profile({"dev", "test"})注解是在开发环境和测试环境的时候加载该类，线上生产环境为安全不建议创建swagger的bean
public class Swagger2Config {

    // 定义分隔符
    private static final String splitor = ";";

    @Bean
    public Docket ProductApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                .select()
                .build()
                .apiInfo(productApiInfo());
    }

    private ApiInfo productApiInfo() {
        ApiInfo apiInfo = new ApiInfo("XXX系统数据接口文档",
                "文档描述。。。",
                "1.0.0",
                "API TERMS URL",
                "联系人邮箱",
                "license",
                "license url");
        return apiInfo;
    }


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("spring-test-interface")
                //加载配置信息
                .apiInfo(apiInfo())
                //设置全局参数
                .globalOperationParameters(globalParamBuilder())
                //设置全局响应参数
                .globalResponseMessage(RequestMethod.GET,responseBuilder())
                .globalResponseMessage(RequestMethod.POST,responseBuilder())
                .globalResponseMessage(RequestMethod.PUT,responseBuilder())
                .globalResponseMessage(RequestMethod.DELETE,responseBuilder())
                .directModelSubstitute(LocalDateTime.class, Date.class)
                .directModelSubstitute(LocalDate.class, String.class)
                .directModelSubstitute(LocalTime.class, String.class)
                .directModelSubstitute(ZonedDateTime.class,String.class)
                .select()
                /**
                 * 加载swagger 扫描包
                 */
//                .apis(RequestHandlerSelectors.any())
//                .apis(basePackage("com.mes7801.server"+splitor+"com.mes7801.service"))
//                .apis(basePackage("com.mes7801.server.controller"+splitor+"com.evjrsf.server.controller"))
                .apis(basePackage("com.cooperation.onlineshop.controller"))
                .paths(PathSelectors.any())
                .build()
                //设置安全认证
                .securitySchemes(security());

    }

    /**
     * 获取swagger创建初始化信息
     * @return
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("慧都科技", "", "sales@evget.com");
        return new ApiInfoBuilder().title("MES7801 测试文档").description("dev by 慧都科技").contact(contact)
                .version("1.1.0").build();
    }

    /**
     * 安全认证参数
     * @return
     */
    private List<ApiKey> security() {
        List<ApiKey> list=new ArrayList<>();
        list.add(new ApiKey("token", "token", "header"));
        return list;
    }

    /**
     * 构建全局参数列表
     * @return
     */
    private List<Parameter> globalParamBuilder(){
        List<Parameter> pars = new ArrayList<>();
        pars.add(parameterBuilder("token","令牌","string","header",false).build());
        return pars;
    }

    /**
     * 创建参数
     * @return
     */
    private ParameterBuilder parameterBuilder(String name,String desc,String type ,String parameterType,boolean required) {
        ParameterBuilder tokenPar = new ParameterBuilder();
        tokenPar.name(name).description(desc).modelRef(new ModelRef(type)).parameterType(parameterType).required(required).build();
        return tokenPar;
    }

    /**
     * 创建全局响应值
     * @return
     */
    private List<ResponseMessage> responseBuilder() {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(200).message("响应成功").build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").build());
        return responseMessageList;
    }

    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage)     {
        return input -> {
            // 循环判断匹配
            for (String strPackage : basePackage.split(splitor)) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }
}

