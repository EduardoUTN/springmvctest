package com.edu.service;

import com.edu.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ed on 10/26/15.
 */

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(String productId);

    List<Product> getProductsByCategory(String category);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
}
