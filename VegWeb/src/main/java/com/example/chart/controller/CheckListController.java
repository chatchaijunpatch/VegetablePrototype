package com.example.chart.controller;

import com.example.chart.entities.Cart;
import com.example.chart.entities.VegOrder;
import com.example.chart.entities.Vegetable;
import com.example.chart.services.OrderService;
import com.example.chart.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

import static java.lang.Integer.parseInt;

@Controller
@RequestMapping("/order")
public class CheckListController {
    @Autowired
    private OrderService service;
    private List<VegOrder> cart = new ArrayList<>();
    @Autowired
    private VegetableService vegetableService;

    @GetMapping("/list")
    public String getCheckPage(Model model, Authentication authentication){
        model.addAttribute("veglist", service.getDummy(authentication.getName()));
        return "checklist";
    }
    @GetMapping("/list/edit/{id}")
    public String editPayment(@PathVariable UUID id, Model model,Authentication authentication){
        System.out.println(service.getDummyByID(id).getCartList());
        VegOrder set = service.getOneById(id);
        Calendar calndr = Calendar.getInstance();
        set.setPayment(calndr.getTime());
        set.setStatus("Payment");
        vegetableService.update(service.getDummyByID(id).getCartList());
        service.update(set);
        return "redirect:/order/list";
    }
    @GetMapping("/list/remove/{id}")
    public String removePayment(@PathVariable UUID id, Model model,Authentication authentication){
        VegOrder set = service.getOneById(id);
        service.delete(set);
        return "redirect:/order/list";
    }
}
