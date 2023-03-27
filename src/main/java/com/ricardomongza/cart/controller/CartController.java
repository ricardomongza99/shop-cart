package com.ricardomongza.cart.controller;

import com.ricardomongza.cart.service.PurchaseProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;

@Controller
public class CartController {

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
    public String cartAdd(Model model, @RequestParam("itemId") Integer itemId, @RequestParam("quantity") BigDecimal quantity) {
        purchaseProcess.AddItemToCart(itemId, quantity);
        return "redirect:/cart";
    }

    @DeleteMapping("/cart/{itemId}")
    public String removeFromCart(@PathVariable("itemId") Integer itemId) {
        purchaseProcess.RemoveItemFromCart(itemId, BigDecimal.ONE);
        return "redirect:/cart";
    }
}
