package com.xu.bootweb.config;

import com.xu.bootweb.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

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


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/hello/**")
                .excludePathPatterns("/admin/**");

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

}
