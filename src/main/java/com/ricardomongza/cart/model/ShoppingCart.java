package com.ricardomongza.cart.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

public class ShoppingCart {
    UUID cartId;
    private List<CartItem> cartItems;

    public ShoppingCart() {
        this.cartId = UUID.randomUUID();
        this.cartItems = new ArrayList<>();
    }

    public void AddItemToCart(Item item, BigDecimal quantity) {
        CartItem cartItem = findCartItem(item);

        if (cartItem != null) {
            CartItem updatedCartItem = new CartItem(item, cartItem.quantity().add(quantity));
            cartItems.set(cartItems.indexOf(cartItem), updatedCartItem);
        } else {
            cartItem = new CartItem(item, quantity);
            cartItems.add(cartItem);
        }
    }

    public void RemoveItemFromCart(Item item) {
        this.cartItems.removeIf(cartItem -> cartItem.item().equals(item));
    }

    public void UpdateItemInCart(Item item, BigDecimal newQuantity) {
        CartItem cartItem = findCartItem(item);

        if (cartItem != null) {
            CartItem updatedCartItem = new CartItem(item, newQuantity);
            cartItems.set(cartItems.indexOf(cartItem), updatedCartItem);
        }
    }

    public BigDecimal GetItemQuantity(Item item) {
        CartItem cartItem = findCartItem(item);

        if (cartItem != null) {
            return cartItem.quantity();
        }
        return null;
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal(0);
        for (CartItem cartItem : cartItems) {
            total = cartItem.getTotalPrice();
        }
        return total;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void Checkout() {
    }

    private CartItem findCartItem(Item item) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.item().equals(item)) {
                return cartItem;
            }
        }
        return null;
    }
}
