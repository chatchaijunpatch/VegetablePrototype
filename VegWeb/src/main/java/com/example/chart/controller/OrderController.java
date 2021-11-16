package com.example.chart.controller;

import com.example.chart.entities.Cart;
import com.example.chart.entities.VegOrder;
import com.example.chart.entities.Vegetable;
import com.example.chart.services.CartService;
import com.example.chart.services.OrderService;
import com.example.chart.services.VegetableService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private CartService service;
    @Autowired
    private OrderService orderService;
    private int total;
    @Autowired
    private VegetableService vegetableService;

    @GetMapping("")
    public String getOrder(Model model){
        total = service.priceCalculate();
        model.addAttribute("priceCal", total);
        model.addAttribute("price", service.getCart().size());
        model.addAttribute("carts",service.getCart());
        return "order";
    }
    @GetMapping("/address")
    public String getAddress(Model model){
        int total = service.priceCalculate();
        model.addAttribute("priceCal", total);
        return "address";
    }
    @PostMapping("/address")
        public String addOrder(Model model, @ModelAttribute VegOrder order, RedirectAttributes redirectAttrs){
        System.out.println(order.getCartList().toString().equals("[]"));
        if (((order.getName().equals("")) || (order.getSurname().equals(""))) || (order.getAddress().equals("")) || (order.getEmail().equals("")) || (order.getMobile().equals(""))){
            redirectAttrs.addFlashAttribute("error","Please Correct all");
            return "redirect:/order/address";
        }
        else if (order.getCartList().toString().equals("[]")){
            redirectAttrs.addFlashAttribute("error","Please put something in cart ");
            return "redirect:/order/address";
        }
        total = service.priceCalculate();
        model.addAttribute("priceCal", total);
        Calendar calndr = Calendar.getInstance();
        order.setDate(calndr.getTime());
        orderService.addOrder(order);
        service.removeall();
        return "redirect:/order/list";
        }






}
