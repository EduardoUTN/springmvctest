package com.edu.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ed on 5/15/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("test-dispatcher-servlet.xml")
@WebAppConfiguration
public class CartRestControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    MockHttpSession session;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void read_method_should_return_correct_cart_Json_object() throws  Exception {
        //Arrange
        this.mockMvc.perform(put("/rest/cart/add/P1234").session(session))
                .andExpect(status().is(204));

        //Act
        this.mockMvc.perform(get("/rest/cart/" + session.getId()).session(session))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cartItems.P1234.product.productId").value("P1234"));
    }
}
