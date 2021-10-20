package com.example.chart.controller;

import com.example.chart.entities.Cart;
import com.example.chart.entities.VegOrder;
import com.example.chart.entities.Vegetable;
import com.example.chart.services.OrderService;
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

    @GetMapping("/list")
    public String getCheckPage(Model model, Authentication authentication){
        model.addAttribute("veglist", service.getDummy(authentication.getName()));
        return "checklist";
    }
    @GetMapping("/list/edit/{id}")
    public String editPayment(@PathVariable UUID id, Model model){
        VegOrder set = service.getOneById(id);
        Calendar calndr = Calendar.getInstance();
        set.setPayment(calndr.getTime());
        set.setStatus("Payment");
        service.update(set);
        return "redirect:/order/list";
    }
}
