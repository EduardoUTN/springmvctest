package com.edu.web;

import com.edu.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

/**
 * Created by ed on 5/15/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-dispatcher-servlet.xml")
@WebAppConfiguration
public class ProductControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testGetProducts() throws Exception{
        this.mockMvc.perform(get("/products"))
                .andExpect(model().attributeExists("products"));
    }

    @Test
    public void tesGetProductById() throws Exception{
        //Arrange
        Product product = new Product("P1234", "iPhone 5S", new BigDecimal(500));

        //Act & Assert
        this.mockMvc.perform(get("/products/product")
                .param("id", "P1234")).andExpect(model().attributeExists("product"))
                .andExpect(model().attribute("product", product));
    }
}
