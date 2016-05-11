package com.edu.service;

import com.edu.domain.Customer;

import java.util.List;

/**
 * Created by ed on 10/26/15.
 */

public interface CustomerService {

    void saveCustomer(Customer customer);

    Customer getCustomer(String customerId);

    Boolean isCustomerExist(String customerId);

    List<Customer> getAllCustomers();
}
