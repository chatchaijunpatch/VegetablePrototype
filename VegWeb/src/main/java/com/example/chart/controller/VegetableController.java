package com.example.chart.controller;

import com.example.chart.entities.Vegetable;
import com.example.chart.services.UserService;
import com.example.chart.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/vegetable")
public class VegetableController {
    @Autowired
    private VegetableService service;
    @Autowired
    private UserService userServices;


    @GetMapping
    public String getVegetables(Model model, Authentication authentication) {
        userServices.setLoginUser(authentication.getName()); //set login
//        System.out.println(authentication.getName());
//        System.out.println(authentication.getPrincipal());
        model.addAttribute("vegetables", service.getAll());
        return "index";
    }

    @GetMapping("/add")
    public String getAdd(){
        return "add";
    }

    @PostMapping("/add")
    public String addVegetable(@ModelAttribute Vegetable vegetable, Model model) {
        // พอรับเข้ามาจะเอาเข้า List
        service.addVegetable(vegetable);

        return "redirect:/vegetable";
    }


}
