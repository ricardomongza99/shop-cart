package com.ricardomongza.cart.repository;

import com.ricardomongza.cart.model.Customer;

public interface CustomerRepository {

    public Customer findCustomer(int customerId);

    public Customer addCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public Customer deleteCustomer(int customerId);
}
