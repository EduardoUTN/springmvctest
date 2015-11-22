package com.edu.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class HomeController {

/*    @RequestMapping("")
    public ModelAndView hello(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        return new ModelAndView("welcome");
    }*/

    @RequestMapping("")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome to WebStore!");
        model.addAttribute("tagline", "The one and only amazing webstore");
        return "forward:/welcome/greeting";
    }

    @RequestMapping("/welcome/greeting")
    public String gretting() {
        return "welcome";
    }

}
