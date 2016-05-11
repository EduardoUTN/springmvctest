package com.edu.exception;

/**
 * Created by ed on 4/25/16.
 */

public class InvalidCartException extends RuntimeException {

    private static final long serialVersionUID = 7031195584608474337L;
    private String cartId;

    public InvalidCartException(String cartId) {
        this.cartId = cartId;
    }

    public String getCartId() {
        return cartId;
    }
}
