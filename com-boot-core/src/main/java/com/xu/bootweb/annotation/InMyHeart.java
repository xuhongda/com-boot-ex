package com.xu.bootweb.annotation;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author xuhongda on 2021/4/28
 * com.xu.bootweb.annotation
 * com-boot-ex
 * 在参数上使用该注解，将验证传入的 Girl 是否在我的 memory 中
 */
@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface InMyHeart {

    String name() default "huang&yan&liu";

}
