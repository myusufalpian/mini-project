package com.myusufalpian.controllers;

import com.myusufalpian.services.SiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class HomeController {

    @Autowired
    private SiswaService siswaService;

    @GetMapping
    public String welcome(Model model){
        String messages = "Data Siswa";
        model.addAttribute("msg", messages);
        model.addAttribute("siswa", siswaService.findAll());
        return "index";
    }

}
