package com.edu.validator;

import com.edu.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.validation.BindException;
import org.springframework.validation.ValidationUtils;

import java.math.BigDecimal;

/**
 * Created by ed on 5/13/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-dispatcher-servlet.xml")
@WebAppConfiguration
public class ProductValidatorTest {

    @Autowired
    private ProductValidator productValidator;

    @Test
    public void product_without_UnitPrice_should_be_invalid() {
        //
        Product product = new Product();
        product.setCategory("Smart Phone");
        BindException bindException = new BindException(product, "product");

        //Act
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        //Assert
        Assert.assertEquals(1, bindException.getErrorCount());
        Assert.assertTrue(bindException.getLocalizedMessage().contains("Unit Price is Invalid. It cannot be empty"));
    }

    @Test
    public void product_with_existing_productId_invalid() {
        //Arrange
        Product product = new Product("P1234", "iPhone 5S", new BigDecimal(500));
        product.setCategory("Smart Phone");

        BindException bindException = new BindException(product, "product");

        //Act
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        //Assert
        Assert.assertEquals(1, bindException.getErrorCount());
        Assert.assertTrue(bindException.getLocalizedMessage().contains("A product already exists with this product id."));
    }

    @Test
    public void a_valid_product_should_not_get_any_error_during_validation() {
        //Arrange
        Product product = new Product("P986", "iPhone 5S", new BigDecimal(500));
        product.setCategory("Smart Phone");

        BindException bindException = new BindException(product, "product");

        //Act
        ValidationUtils.invokeValidator(productValidator, product, bindException);

        //Assert
        Assert.assertEquals(0, bindException.getErrorCount());
    }
}
