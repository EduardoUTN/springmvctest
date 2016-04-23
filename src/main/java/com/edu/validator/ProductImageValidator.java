package com.edu.validator;

import com.edu.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by ed on 4/17/16.
 */

@Component
public class ProductImageValidator implements Validator{
    private static final long MAX_IMAGE_SIZE = 102400;

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        if(product.getProductImage() != null && product.getProductImage().getSize() >= MAX_IMAGE_SIZE) {
            errors.rejectValue("productImage", "com.edu.validator.ProductImageValidator.message");
        }
    }
}
