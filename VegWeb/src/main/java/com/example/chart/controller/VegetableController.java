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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;


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
    public String addVegetable(@ModelAttribute("amount") Object amount,@ModelAttribute("price") Object price,@ModelAttribute("name") String name, RedirectAttributes redirectAttrs,Model model) {
        try {

        if (name.equals("Select Veggie")){
            redirectAttrs.addFlashAttribute("error","Please Select Vegetable");
            return "redirect:add";
        }
        else if ( Integer.parseInt(price.toString()) <= 0){
            if (Integer.parseInt(price.toString()) < 0){
                redirectAttrs.addFlashAttribute("error","Price cannot be negative");
            }
            else {
                redirectAttrs.addFlashAttribute("error","Please Select price");
            }
            return "redirect:add";
        }
        else if (Integer.parseInt(amount.toString()) <= 0){
            if (Integer.parseInt(amount.toString()) < 0){
                redirectAttrs.addFlashAttribute("error","Amount cannot be negative");
            }
            else {
                redirectAttrs.addFlashAttribute("error","Please Select amount");
            }
            return "redirect:add";
        }
        System.out.println(amount);
        Vegetable vegetable = new Vegetable(UUID.randomUUID(),name,Integer.parseInt(price.toString()), Integer.parseInt(amount.toString()));
        // พอรับเข้ามาจะเอาเข้า List
        service.addVegetable(vegetable);
        return "redirect:/vegetable";}
        catch (NumberFormatException e){
            redirectAttrs.addFlashAttribute("error","Please input Price or Amount");
            return "redirect:add";
        }

    }


}
