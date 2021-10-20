package com.example.chart.controller;

import com.example.chart.entities.Cart;
import com.example.chart.services.CartService;
import com.example.chart.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService service;
    @Autowired
    private VegetableService vegetableService;


    @GetMapping("")
    public String index(Model model) {
        int total = service.priceCalculate();
        model.addAttribute("priceCal", total);
        model.addAttribute("carts",service.getCart());
        return "cart";
    }
    @PostMapping("")
    public String addCart(@ModelAttribute("num") int number,@ModelAttribute("name") UUID id,Model model) {
        if (number != 0) {
            if (!exists(id, service.getCart(), number)) {
                service.addCart(id,number);
            }
        }
        model.addAttribute("carts", service.getCart());
        return "redirect:/vegetable";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable UUID id,Model model) {
        service.removeCart(id);
        model.addAttribute("carts",service.getCart());
        return "redirect:/cart";
    }

    private boolean exists(UUID id, List<Cart> cart, int number) {

        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getVegetable().getId().equals(id)) {
                System.out.println(cart.get(i).getQuantity());
                if (cart.get(i).getQuantity()+number<=(vegetableService.getOneById(id).getAmount())){
                    cart.get(i).setQuantity(cart.get(i).getQuantity()+number);
                }
                else if (cart.get(i).getQuantity()+number > (vegetableService.getOneById(id).getAmount())){
                    cart.get(i).setQuantity(vegetableService.getOneById(id).getAmount());
                }
                return true;
            }
        }
        return false;
    }



}