package com.edu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ed on 10/22/15.
 */

@Controller
public class HelloController {

    @RequestMapping("")
    public ModelAndView hello(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        return new ModelAndView("hello");
    }
}
