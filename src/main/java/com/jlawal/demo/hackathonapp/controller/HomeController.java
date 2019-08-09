package com.jlawal.demo.hackathonapp.controller;

import com.jlawal.demo.hackathonapp.utility.AppHelper;
import com.jlawal.demo.hackathonapp.utility.AppValues;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
    @GetMapping(value = {"/", "/hackathonapp", "/hackathonapp/home"})
    public ModelAndView displayHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageTitle", "Welcome To ");
        modelAndView.addObject("pageLinks", AppHelper.pageLinks);
        modelAndView.setViewName(AppValues.HOME_PAGE.val());
        return modelAndView;
    }
}
