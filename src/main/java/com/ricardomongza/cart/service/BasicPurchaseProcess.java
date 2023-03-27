package com.ricardomongza.cart.service;

import com.ricardomongza.cart.model.CartItem;
import com.ricardomongza.cart.model.Customer;
import com.ricardomongza.cart.model.ShoppingCart;
import com.ricardomongza.cart.repository.CustomerDatabase;
import com.ricardomongza.cart.repository.CustomerRepository;
import com.ricardomongza.cart.repository.ItemDatabase;
import com.ricardomongza.cart.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BasicPurchaseProcess implements PurchaseProcess {

    // Repositories
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;

    private Customer customer;
    private ShoppingCart shoppingCart;

    public BasicPurchaseProcess() {
        this.customerRepository = new CustomerDatabase();
        this.itemRepository = new ItemDatabase();
        this.shoppingCart = new ShoppingCart();
    }


    @Override
    public void AddItemToCart(Integer itemId, BigDecimal quantity) {
        var item = itemRepository.findItem(itemId);
        this.shoppingCart.AddItemToCart(item, quantity);
    }

    @Override
    public void RemoveItemFromCart(Integer itemId, BigDecimal quantity) {
        if (quantity.compareTo(BigDecimal.ZERO) == 0) {
            return;
        }

        var currentQuantity = this.shoppingCart.GetItemQuantity(itemRepository.findItem(itemId));

        if (currentQuantity.compareTo(quantity) <= 0) {
            this.shoppingCart.RemoveItemFromCart(itemRepository.findItem(itemId));
        } else  if (currentQuantity.compareTo(quantity) > 0) {
            this.shoppingCart.UpdateItemInCart(itemRepository.findItem(itemId), currentQuantity.subtract(quantity));
        }

    }

    @Override
    public void Checkout() {
        System.out.println("Checking out...");
        System.out.println("Customer: " + this.customer.email());
        System.out.println("Total: " + this.shoppingCart.getTotal());
    }

    @Override
    public Customer setCustomer(int customerId) {
        this.customer = customerRepository.findCustomer(customerId);
        return this.customer;
    }

    @Override
    public Customer getCustomer() {
        return this.customer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: " + this.customer.email()+"\n");
        var cartItems = this.shoppingCart.getCartItems();

        for (CartItem cartItem : cartItems) {
            sb.append("Item: " + cartItem.item().toString() + "Quantity: " + cartItem.quantity() + "\n");
        }

        return sb.toString();
    }

    public List<CartItem> getCartItems() {
        return shoppingCart.getCartItems();
    }

}
