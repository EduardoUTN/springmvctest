package com.edu.service;

import com.edu.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ed on 10/26/15.
 */

public interface ProductService {

    void addProduct(Product product);

    Product getProductById(String productId);

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByManufacturer(String manufacturer);

    Set<Product> getProductsByPrice(BigDecimal low, BigDecimal high);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
}
