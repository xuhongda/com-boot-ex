package com.xu.bootweb.aspect;

import entity.Account;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author xuhongda on 2018/12/15
 * com.xu.bootweb.aspect
 * com-boot-ex
 */
@Aspect
@Component
@Slf4j
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MyAspect {


    /**
     * <p>
     * 第一个 * ： 任何返回值
     * 第二个 * ： 类中任何方法
     * ..      :  任何请求参数
     * </P>
     * 切点
     */
    @Around("execution(* com.xu.bootweb.controller.OtherController.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable { //增强

        //参数对象个数
        Object[] args = pjp.getArgs();
        for (Object o : args) {
            log.info("参数：{}", o);
        }

        Object target = pjp.getTarget();
        log.info("目标:{}", target);

        log.info("{}", pjp);

        Object proceed = pjp.proceed();

        log.info("{}", proceed);
        return proceed;
    }

    /**
     *  执行顺序在参数解析后
     *  利用aop 做访问控制
     */

    @Around(value = "@annotation(com.xu.bootweb.anotation.LoginUser)")
    public Object login(ProceedingJoinPoint pjp) throws Throwable { //增强

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = sra.getRequest();
        String authType = request.getAuthType();
        Enumeration<String> headerNames = request.getHeaderNames();

        MethodSignature signature = (MethodSignature) pjp.getSignature();
        String[] parameterNames = signature.getParameterNames();

        for (String paramName : parameterNames) {
            log.info("paramName ：{}", paramName);

        }
        Class[] parameterTypes = signature.getParameterTypes();
        Object o = parameterTypes[0].newInstance();
        Account account = null;
        //参数对象个数
        Object[] args = pjp.getArgs();
        if (o instanceof Account) {
            account = (Account) o;
            account.setPassword("root");
            account.setUsername("root");
            args[0] = account;
        }

        Object target = pjp.getTarget();
        log.info("目标:{}", target);
        log.info("{}", pjp);
        Object proceed = null;
        proceed = pjp.proceed(args);
        log.info("{}", proceed);
        return proceed;
    }

}
