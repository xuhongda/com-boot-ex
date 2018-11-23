package validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author xuhongda on 2018/9/25
 * com.xu.bootweb.validator
 * com-boot-ex
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {
    //成员已无入参无抛出异常申明可以有默认值
    String message() default "自定义注解";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
