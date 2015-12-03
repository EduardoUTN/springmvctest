package com.edu.validator;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Created by ed on 12/2/15.
 */

@Component
public class CategoryValidator implements ConstraintValidator<Category, String> {

    public void initialize(Category category) {
        /* intentionally left blank; this is the place to initialize the
        *  constraint annotation for any sensible default values.
        */
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(Category.allowedCategories.contains(value) == true) {
            return true;
        } else return false;
    }
}
