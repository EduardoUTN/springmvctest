package com.edu.repository.impl;

import com.edu.domain.Product;
import com.edu.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by ed on 10/25/15.
 */

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> listOfProducts = new ArrayList<Product>();

    public InMemoryProductRepository() {
        Product iPhone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
        iPhone.setDescription("New Apple Smart Phone 5s with 4.00-inch 640x1136	display	and	8-megapixel	rear camera");
        iPhone.setCategory("Smart Phone");
        iPhone.setManufacturer("Apple");
        iPhone.setUnitsInStock(1000);

        Product laptop_dell = new Product("P1235", "Dell Inspiron", new BigDecimal(700));
        laptop_dell.setDescription("Dell	Inspiron 14-inch Laptop (Black) with 3rd Generation	Intel Core processors");
        laptop_dell.setCategory("Laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1000);

        Product tablet_nexus = new Product("P1236", "Nexus 7", new BigDecimal(300));
        tablet_nexus.setDescription("Google Nexus	7 is the lightest 7	inch tablet	With a quad-core Qualcomm SnapdragonTM S4 Pro processor");
        tablet_nexus.setCategory("Tablet");
        tablet_nexus.setManufacturer("Google");
        tablet_nexus.setUnitsInStock(1000);

        listOfProducts.add(iPhone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_nexus);
    }

    public void addProduct(Product product) {
        listOfProducts.add(product);
    }

    public Product getProductById(String productId) {
        Product productById = null;

        for (Product product : listOfProducts) {
            if (productId != null && product.getProductId() != null && product.getProductId().equals(productId)) {
                productById = product;
                break;
            }
        }
        if (productId == null) {
            throw new IllegalArgumentException("No products	found with the product id: "+ productId);
        }
        return productById;
    }

    public List<Product> getAllProducts() {
        return listOfProducts;
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<Product>();

        for (Product product: listOfProducts) {
            if(category.equalsIgnoreCase(product.getCategory())) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<Product>();
        Set<Product> productsByCategory = new HashSet<Product>();

        Set<String> criterias = filterParams.keySet();

        if (criterias.contains("brand")) {
            for(String brandName: filterParams.get("brand")) {
                for(Product product: listOfProducts) {
                    if(brandName.equalsIgnoreCase(product.getManufacturer())) {
                        productsByBrand.add(product);
                    }
                }
            }
        }

        if (criterias.contains("category")) {
            for(String category: filterParams.get("category")) {
                productsByCategory.addAll(this.getProductsByCategory(category));
            }
        }

        productsByCategory.retainAll(productsByBrand);

        return productsByCategory;
    }

    public List<Product> getProductsByManufacturer(String manufacturer) {
        List<Product> productsByManufacturer = new ArrayList<Product>();

        for(Product product: listOfProducts) {
            if(manufacturer.equalsIgnoreCase(product.getManufacturer()));
            productsByManufacturer.add(product);
        }
        return productsByManufacturer;
    }

    public Set<Product> getProductsByPrice(BigDecimal low, BigDecimal high) {
        Set<Product> productsByPrice = new HashSet<Product>();

        for(Product product: listOfProducts) {
            if((low.compareTo(product.getUnitPrice())) < 0 && (high.compareTo(product.getUnitPrice())) > 0) {
                productsByPrice.add(product);
            }
        }

        return productsByPrice;
    }

}
