package com.myusufalpian.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class HomeController {

    @GetMapping
    public String welcome(Model model){
        String messages = "Welcome to Mini Project Muhammad Yusuf Alpian";
        model.addAttribute("msg", messages);
        return "index";
    }
}
