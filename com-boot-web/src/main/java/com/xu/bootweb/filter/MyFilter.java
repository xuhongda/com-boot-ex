package com.xu.bootweb.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author xuhongda on 2018/11/29
 * com.xu.bootweb.filter
 * com-boot-ex
 */
@WebFilter(urlPatterns = "/hello/test1")
@Order(1)
@Slf4j
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("一个拦截器。。。");

        long l = System.currentTimeMillis();
        log.info("时间毫秒数{}", l);
        if (l % 2 == 0) {
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
