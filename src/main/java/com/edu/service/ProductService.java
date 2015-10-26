package com.edu.service;

import com.edu.domain.Product;

import java.util.List;

/**
 * Created by ed on 10/26/15.
 */

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(String productId);
}
