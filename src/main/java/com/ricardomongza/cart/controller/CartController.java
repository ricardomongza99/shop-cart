package com.ricardomongza.cart.controller;

import com.ricardomongza.cart.service.PurchaseProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class CartController {

    // TODO: Change to Purchase process type Interface
    private final PurchaseProcess purchaseProcess;

    @Autowired
    public CartController(PurchaseProcess purchaseProcess) {
        this.purchaseProcess = purchaseProcess;
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("cartItems", purchaseProcess.getCartItems());
        return "cart";
    }

    @PostMapping("/cart")
    public String cartAdd(@RequestParam("itemId") Integer itemId, @RequestParam("quantity") BigDecimal quantity, Model model) {
        purchaseProcess.AddItemToCart(itemId, quantity);
        model.addAttribute("cartItems", purchaseProcess.getCartItems());
        return "cart";
    }

}
