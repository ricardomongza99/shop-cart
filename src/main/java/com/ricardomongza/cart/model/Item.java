package com.ricardomongza.cart.model;

import java.math.BigDecimal;

public record Item(Integer itemId, String name, String description, BigDecimal price) {
}
