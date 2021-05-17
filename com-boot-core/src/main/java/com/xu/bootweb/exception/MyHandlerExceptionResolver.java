package com.xu.bootweb.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author by xuhongda 2021/5/16
 * com.xu.bootweb.exception
 * com-boot-ex
 * 自定义 异常解析器在处理完 handler 后调用，只会使用一个异常解析器
 **/
@Slf4j
@Configuration
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class MyHandlerExceptionResolver implements HandlerExceptionResolver  {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        log.info("<--自定义异常解析器 work on-->");

        try {
            return handlerException(response,handler,ex);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private ModelAndView handlerException(HttpServletResponse response, Object handler, Exception ex) throws IOException {
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, ex.getMessage());
        log.info("ex = ",ex);
        return new ModelAndView();
    }
}
