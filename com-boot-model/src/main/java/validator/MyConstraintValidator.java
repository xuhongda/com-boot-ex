package validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

/**
 * @author xuhongda on 2018/9/25
 * com.xu.bootweb.validator
 * com-boot-ex
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {


    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("my validator init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Date date = new Date();
        if (date.hashCode() % 2 == 0) {
            return true;
        }
        return true;
    }
}
