package com.ricardomongza.cart.service;

import com.ricardomongza.cart.model.Customer;
import java.math.BigDecimal;
import java.util.List;

public interface PurchaseProcess {

    public void AddItemToCart(Integer itemId, BigDecimal quantity);

    public void RemoveItemFromCart(Integer itemId, BigDecimal quantity);

    public void Checkout();

    public Customer setCustomer(int customerId);

    public Customer getCustomer();

    public List<String> getCartItems();

}
