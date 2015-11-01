package com.edu.web;

import com.edu.domain.Product;
import com.edu.repository.ProductRepository;
import com.edu.service.ProductService;
import com.sun.javafx.sg.prism.NGShape;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.applet.resources.MsgAppletViewer;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by ed on 10/24/15.
 */

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping
    public String list(Model model) {

        model.addAttribute("products", productService.getAllProducts());

        return "products";
    }

    @RequestMapping("/all")
    public String allProducts(Model model) {

        model.addAttribute("products", productService.getAllProducts());

        return "products";
    }

    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
        model.addAttribute("products", productService.getProductsByCategory(productCategory));

        return "products";
    }

    @RequestMapping("/filter/{ByCriteria}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));

        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(@RequestParam("id") String productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @RequestMapping("/{category}/{price}")
    public String filterProducts(@PathVariable("category") String category,
                                 @MatrixVariable(pathVar = "price") Map<String, List<String>> priceParams,
                                 @RequestParam("manufacturer") String manufacturer,
                                 Model model) {
        Set<Product> filteredProducts = new HashSet<Product>();

        List<Product> productsByCategory = productService.getProductsByCategory(category);
        List<Product> productsByManufacturer = productService.getProductsByManufacturer(manufacturer);
        Set<Product> productsByPrice = new HashSet<Product>();

        BigDecimal low = new BigDecimal(priceParams.get("low").get(0));
        BigDecimal high = new BigDecimal(priceParams.get("high").get(0));
        productsByPrice.addAll(productService.getProductsByPrice(low, high));

        for(Product categoryProduct: productsByCategory) {
            for(Product manufacturerProduct: productsByManufacturer) {
                for(Product priceProduct: productsByPrice) {
                    if(priceProduct.equals(manufacturerProduct) && manufacturerProduct.equals(categoryProduct)) {
                        filteredProducts.add(priceProduct);
                    }
                }
            }
        }

        model.addAttribute("products", filteredProducts);

        return "products";
    }
}
