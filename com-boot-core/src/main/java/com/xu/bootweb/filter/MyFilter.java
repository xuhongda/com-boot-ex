package com.xu.bootweb.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

/**
 * @author xuhongda on 2018/11/29
 * com.xu.bootweb.filter
 * com-boot-ex
 */
@WebFilter(filterName = "my_filter_1", urlPatterns = "/hello/*")
@Order(1)
@Slf4j
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("{}\tmy_filter_1\t被创建", new Date());
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Enumeration<String> parameterNames = request.getParameterNames();
        if (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            String parameter = request.getParameter(s);
            log.info("请求参数：{}", parameter);
        }
        log.info("一个拦截器。。。");
        long l = System.currentTimeMillis();
        log.info("时间毫秒数{}", l);
        if (true) {
            //放行
            chain.doFilter(request, response);
        } else {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print(l + "毫秒没有过拦截条件");
        }
    }


    @Override
    public void destroy() {

    }
}
