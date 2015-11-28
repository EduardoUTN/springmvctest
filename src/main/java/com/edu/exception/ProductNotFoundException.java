package com.edu.exception;

/**
 * Created by ed on 11/28/15.
 */

public class ProductNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -694354952032299587L;

    private String productId;

    public ProductNotFoundException(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
