package com.xu.bootweb.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author xuhongda on 2018/12/15
 * com.xu.bootweb.aspect
 * com-boot-ex
 */
@Aspect
@Component
@Slf4j
public class MyAspect {


    /**
     * <p>
     * 第一个 * ： 任何返回值
     * 第二个 * ： 类中任何方法
     * ..      :  任何请求参数
     * </P>
     */
    @Around("execution(* com.xu.bootweb.controller.OtherController.*(..))") //切点
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

}
