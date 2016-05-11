package com.edu.domain.repository;

import com.edu.domain.Customer;

import java.util.List;

/**
 * Created by ed on 10/26/15.
 */

public interface CustomerRepository {

    void saveCustomer(Customer customer);

    Boolean isCustomerExist(String customerId);

    Customer getCustomer(String customerId);

    List<Customer> getAllCustomers();
}
