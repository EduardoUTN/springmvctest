package com.edu.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by ed on 12/2/15.
 */

@Target( {METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = CategoryValidator.class)
@Documented
public @interface Category {
    String message() default "{com.edu.validator.Category.message}";

    Class<?>[] groups() default {};

    public abstract Class<? extends Payload>[] payload() default {};
}
