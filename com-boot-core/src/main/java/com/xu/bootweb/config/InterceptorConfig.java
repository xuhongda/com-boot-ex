package com.xu.bootweb.config;

import com.xu.bootweb.interceptor.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <P>
 *     配置 Interceptor 拦截 内容
 * </P>
 * @author xuhongda on 2018/12/15
 * com.xu.bootweb.config
 * com-boot-ex
 */
@Configuration
@EnableWebMvc
public class InterceptorConfig implements WebMvcConfigurer {

    private final MyInterceptor myInterceptor;

    @Autowired
    public InterceptorConfig(MyInterceptor myInterceptor) {
        this.myInterceptor = myInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(myInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/admin/**");

    }

}
