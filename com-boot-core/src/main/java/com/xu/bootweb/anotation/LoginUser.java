package com.xu.bootweb.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author by xuhongda 2021/5/2
 * com.xu.core
 * spring-practice
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {

    String name() default "root";

    String password() default "root";
}
