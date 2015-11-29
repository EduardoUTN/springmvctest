package com.edu.web;

import com.edu.domain.Product;
import com.edu.exception.NoProductsFoundUnderCategoryException;
import com.edu.exception.ProductNotFoundException;
import com.edu.repository.ProductRepository;
import com.edu.service.ProductService;
import com.sun.javafx.sg.prism.NGShape;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.applet.resources.MsgAppletViewer;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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

    @InitBinder
    public void initialiseBinder(WebDataBinder binder) {
        binder.setAllowedFields("productId", "name", "unitPrice", "description", "manufacturer", "category", "unitsInStock", "productImage","condition", "productPdfManual", "language");
        binder.setDisallowedFields("unitsInOrder", "discontinued");
    }

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
        List<Product> products = productService.getProductsByCategory(productCategory);

        if(products == null || products.isEmpty()) {
            throw new NoProductsFoundUnderCategoryException();
        }

        model.addAttribute("products", products);

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

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleError(HttpServletRequest request, ProductNotFoundException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidProductId", exception.getProductId());
        mav.addObject("exception", exception);
        mav.addObject("url", request.getRequestURL() + "?" + request.getQueryString());
        mav.setViewName("productNotFound");
        return mav;
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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
        return "addProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public  String processAddNewProductForm(@ModelAttribute("newProduct") Product productToBeAdded, BindingResult result, HttpServletRequest request) {
        String[] suppressedFields = result.getSuppressedFields();
        if(suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }

        MultipartFile productImage = productToBeAdded.getProductImage();
        MultipartFile productPdfManual = productToBeAdded.getProductPdfManual();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        String dir = rootDirectory + "resources" + File.separator + "images" + File.separator + productToBeAdded.getProductId() + ".jpg";
        if(productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(dir));
            }catch (Exception e) {
                throw new RuntimeException("Product Image saving failed", e);
            }
        }
        if(productPdfManual != null && !productPdfManual.isEmpty()) {
            try {
                dir = rootDirectory + "resources" + File.separator + "pdf" + File.separator + productToBeAdded.getProductId() + ".pdf";
                productPdfManual.transferTo(new File(dir));
            }catch (Exception e) {
                throw new RuntimeException("Product PDF Manual saving failed", e);
            }
        }
        productService.addProduct(productToBeAdded);
        return "redirect:/products";
    }
}
