package com.ychs.lawfirmsys.config;

import com.ychs.lawfirmsys.util.JacksonObjectMapper;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

/**
 * 实现前后端跨域
 *
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/25
 */
@Slf4j
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置所有的请求
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOriginPatterns("*");
    }

    // 通过knife4j生成接口文档
    @Bean
    public Docket docket1() {
        log.info("开始生成接口文档...");
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("律师与合同管理系统项目接口文档")
                .version("2.0")
                .description("律师与合同管理系统项目接口文档")
                .build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("管理端接口")
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ychs.lawfirmsys.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    @Value("${pictureFile.path}")
    private String selfImage;
    @Value("${pictureFile.path-mapping}")
    private String selfImage_mapping;


     // 设置静态资源映射
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("开始设置静态资源映射...");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler(selfImage_mapping + "**").addResourceLocations("file:" + selfImage);

    }

    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        log.info("扩展消息转换器");
        //创建一个消息转化器对象
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        //需要为消息转化器设置一个对象转换器,对象转换器可以将java对象序列化为json数据
        converter.setObjectMapper(new JacksonObjectMapper());
        //将之间的消息转换器加入到容器
        converters.add(0,converter);
    }
}


