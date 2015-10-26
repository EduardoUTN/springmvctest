package com.edu.repository;

import com.edu.domain.Customer;

import java.util.List;

/**
 * Created by ed on 10/26/15.
 */

public interface CustomerRepository {

    List<Customer> getAllCustomers();
}
