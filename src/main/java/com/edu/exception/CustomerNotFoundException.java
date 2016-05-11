package com.edu.exception;

/**
 * Created by ed on 5/10/16.
 */
public class CustomerNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 3092641149434570386L;

    private String customerId;

    public CustomerNotFoundException(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
