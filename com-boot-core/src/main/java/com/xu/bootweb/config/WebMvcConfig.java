package com.xu.bootweb.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xu.bootweb.interceptor.MyInterceptor;
import com.xu.bootweb.resolvers.MyArgumentResolver;
import com.xu.bootweb.resolvers.MyViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.nio.charset.Charset;
import java.util.List;

/**
 * <p>
 *     spring boot2 注意加载静态资源问题：
 *
 * </p>
 * @author xuhongda on 2019/6/12
 * com.xu.bootweb.config
 * com-boot-ex
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {


    @Autowired
    private MyInterceptor myInterceptor;

    @Autowired
    private MyViewResolver myViewResolver;

    @Autowired
    private MyArgumentResolver myArgumentResolver;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(myInterceptor).addPathPatterns("/*")
                .excludePathPatterns("/admin/**");

    }


    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

        resolvers.add(myArgumentResolver);
    }


    /**
     * 配置请求视图映射
     */
    @Bean
    public InternalResourceViewResolver resourceViewResolver()
    {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        //请求视图文件的前缀地址
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        //请求视图文件的后缀
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    /**
     * 关键-视图解析器配置
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

        registry.viewResolver(resourceViewResolver());
        // 添加自己的视图解析器
        registry.viewResolver(myViewResolver);
    }

    /**
     * 拦截 url 中带有 /static 的请求 ，映射到 static 目录
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/").setCachePeriod(31556926);
        //favicon.ico 图标
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/static/").setCachePeriod(31556926);
    }

    /**
     * <mvc:view-controller path="/user/register" view-name="demo-signUp"/>
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user/register").setViewName("demo-signUp");
        registry.addViewController("/socket").setViewName("socket");
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(
                Charset.forName("UTF-8"));
        converter.setWriteAcceptCharset(false);
        return converter;
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public MappingJackson2HttpMessageConverter messageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(getObjectMapper());
        return converter;
    }

    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
        //super.configureMessageConverters(converters);
        //解决中文乱码
        converters.add(responseBodyConverter());
        //解决 添加解决中文乱码后 上述配置之后，返回json数据直接报错 500：no converter for return value of type
        converters.add(messageConverter());
    }

    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }




}
