package com.edu.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by ed on 4/23/16.
 */
public class CartItem implements Serializable {

    private static final long serialVersionUID = -7335374176618818825L;

    private Product product;
    private int quantity;
    private BigDecimal totalPrice;

    public CartItem() {
        // TODO Auto-generated constructor stub
    }

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
        this.totalPrice = product.getUnitPrice();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.updateTotalPrice();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.updateTotalPrice();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void updateTotalPrice() {
        totalPrice = this.product.getUnitPrice().multiply(new BigDecimal(this.quantity));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return quantity == cartItem.quantity &&
                Objects.equals(product, cartItem.product) &&
                Objects.equals(totalPrice, cartItem.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity, totalPrice);
    }
}
