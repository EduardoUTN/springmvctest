package com.edu.validator;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ed on 12/2/15.
 */

@Component
public class CategoryValidator implements ConstraintValidator<Category, String> {

    List<String> allowedCategories;

    public void initialize(Category category) {
        this.allowedCategories = new ArrayList<>();
        this.allowedCategories.add("Smart Phone");
        this.allowedCategories.add("Tablet");
        this.allowedCategories.add("Laptop");
        /* intentionally left blank; this is the place to initialize the
        *  constraint annotation for any sensible default values.
        */
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(this.allowedCategories.contains(value) == true) {
            return true;
        } else return false;
    }
}
