package com.ricardomongza.cart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {

    /** TODO:
     *         var purchase = new BasicPurchaseProcess();
     *         purchase.setCustomer(1);
     *         purchase.AddItemToCart(1, BigDecimal.valueOf(2));
     *         System.out.println(purchase);
     *         purchase.AddItemToCart(1, BigDecimal.valueOf(2));
     *         System.out.println(purchase);
     *         purchase.AddItemToCart(2, BigDecimal.valueOf(3.5));
     *         System.out.println(purchase);
     */

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("message", "Hello world");
        return "cart";
    }
}
