package com.edu.repository;

import com.edu.domain.Product;

import java.util.List;

/**
 * Created by ed on 10/25/15.
 */

public interface ProductRepository {

    Product getProductById(String productId);

    List<Product> getAllProducts();
}
