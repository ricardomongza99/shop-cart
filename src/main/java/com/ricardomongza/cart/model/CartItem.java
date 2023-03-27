package com.ricardomongza.cart.model;

import java.math.BigDecimal;

public record CartItem(Item item, BigDecimal quantity) {

    public BigDecimal getTotalPrice() {
        return item.price().multiply(quantity);
    }
}