package com.edu.validator;

import com.edu.domain.Product;
import com.edu.exception.ProductNotFoundException;
import com.edu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Created by ed on 12/2/15.
 */

@Component
public class ProductIdValidator implements ConstraintValidator<ProductId, String> {

    @Autowired
    ProductService productService;

    List<String> allowedCategories;

    public void initialize(ProductId constraintAnnotation) {

    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        Product product;
        try {
            product = productService.getProductById(value);
        } catch (ProductNotFoundException e) {
            return true;
        }

        if(product != null) {
            return false;
        }

        return true;
    }
}
