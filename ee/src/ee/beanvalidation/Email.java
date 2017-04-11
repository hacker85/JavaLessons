package ee.beanvalidation;


import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@NotNull
@Size(min = 7)
@Pattern(regexp = "[a-z]*@[a-z]*\\.com")
@ReportAsSingleViolation
@Constraint(validatedBy = {})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
    String message() default "Email address doesn't look good";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}