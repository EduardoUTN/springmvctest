package com.edu.web;

import com.edu.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

/**
 * Created by ed on 10/24/15.
 */

@Controller
public class ProductController {

    @RequestMapping("/products")
    public String list(Model model) {
        Product iPhone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
        iPhone.setDescription("New Apple Smart Phone 5s with 4.00-inch 640x1136	display	and	8-megapixel	rear camera");
        iPhone.setCategory("Smart Phone");
        iPhone.setManufacturer("Apple");
        iPhone.setUnitsInStock(1000);

        model.addAttribute("product", iPhone);

        return "products";
    }
}
