package com.ricardomongza.cart.repository;

import com.ricardomongza.cart.model.Item;

import java.math.BigDecimal;

public interface ItemRepository {

    public Item findItem(int itemId);

    public BigDecimal findItemInventory(int itemId);

    public Item addItem(Item item);

    public Item updateItem(Item item);

    public Item deleteItem(int itemId);
    
}
