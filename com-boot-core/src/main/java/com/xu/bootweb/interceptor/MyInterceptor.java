package com.xu.bootweb.interceptor;

import com.xu.bootweb.mapper.CityMapper;
import entity.City;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 自定义拦截器；相比于Filter 有了 handler 对象可以获取到请求方法名,参数对象,参数值
 * spring 容器已经被初始化可以使用spring容器中已经注册的资源
 * </p>
 *
 * @author xuhongda on 2018/12/15
 * com.xu.bootweb.interceptor
 * com-boot-ex
 */
@Component
@Slf4j
public class MyInterceptor implements HandlerInterceptor {
    /**
     * 假设 这是一个 黑名单
     */
    @Autowired
    private CityMapper cityMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        List<City> cities = cityMapper.selectByExample(null);
        log.info("size = {}", cities.size());
        log.info("{}", request.getQueryString());
        String requestURI = request.getRequestURI();
        log.info("uri = {}", requestURI);
        log.info("preHandle");
        log.info("handler = {}", handler);
        // return false; //false 将不会往后执行
        return true;
    }

    /**
     * <p>
     * 如果在controller 中发生异常，将不会执行postHandle，而是执行完preHandle后执行afterCompletion
     * </p>
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        log.info("postHandle");

    }

    /**
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {
        log.info("afterCompletion");
    }

}
