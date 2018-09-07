package okkpp.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 访问 /swagger-ui 查看接口文档或测试
 * @author okkpp
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

	static final Logger log = LoggerFactory.getLogger(Swagger2Config.class);
	
	@Bean
    public Docket createRestApi() {
        log.info("加载Swagger2");
        return new Docket(DocumentationType.SWAGGER_2)
//              .host(host)
                .apiInfo(apiInfo()).select()
                //扫描指定包中的swagger注解
//              .apis(RequestHandlerSelectors.basePackage("cn.exrick.controller"))
                //扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("teddy-admin")
                .version("1.0.0")
                .build();
    }
}
