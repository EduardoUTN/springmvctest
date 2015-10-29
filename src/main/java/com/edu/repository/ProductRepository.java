package com.edu.repository;

import com.edu.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ed on 10/25/15.
 */

public interface ProductRepository {

    Product getProductById(String productId);

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
}
