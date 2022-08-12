package com.myusufalpian.controllers;

import com.myusufalpian.models.entities.SiswaEntity;
import com.myusufalpian.models.repos.SiswaRepository;
import com.myusufalpian.services.SiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public/siswa/data")
public class DataSiswaController {

    @Autowired
    private SiswaService siswaService;

    @GetMapping
    public String siswa(Model model){
        String message = "Data Siswa";
        model.addAttribute("msg", message);
        model.addAttribute("siswa", siswaService.findAll());
        return "siswa";
    }

    @GetMapping("/addSiswa")
    public String addSiswa(Model model){
        model.addAttribute("siswa", new SiswaEntity());
        return "addSiswa";
    }

    @PostMapping("/save")
    public String save(SiswaEntity siswaEntity, Model model){
        siswaService.save(siswaEntity);
        String message = "Data Siswa";
        model.addAttribute("msg", message);
        model.addAttribute("siswa", siswaService.findAll());
        return "siswa";
    }
}
