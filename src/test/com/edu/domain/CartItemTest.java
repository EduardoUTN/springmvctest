package com.edu.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by ed on 5/13/16.
 */

public class CartItemTest {

    private CartItem cartItem;

    @Before
    public void setUp() {
        cartItem = new CartItem();
    }

    @Test
    public void cartItem_total_price_should_be_equal_to_product_unit_price_in_case_of_single_quantity() {
        //Arrange
        Product iPhone = new Product("P1234", "iPhone5", new BigDecimal(500));
        cartItem.setProduct(iPhone);

        //Act
        BigDecimal totalPrice = cartItem.getTotalPrice();

        //Assert
        Assert.assertEquals(iPhone.getUnitPrice(), totalPrice);
    }


}
