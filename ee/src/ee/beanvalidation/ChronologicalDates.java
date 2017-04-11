package ee.beanvalidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {ChronologicalDatesValidator.class})
@Target({TYPE})
@Retention(RUNTIME)
public @interface ChronologicalDates {
    String message() default "dates invalid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
