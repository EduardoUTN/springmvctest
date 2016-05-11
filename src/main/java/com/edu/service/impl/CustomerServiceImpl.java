package com.edu.service.impl;

import com.edu.domain.Customer;
import com.edu.domain.repository.CustomerRepository;
import com.edu.exception.CustomerNotFoundException;
import com.edu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ed on 10/26/15.
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomer(String customerId) {
        return customerRepository.getCustomer(customerId);
    }

    public Boolean isCustomerExist(String customerId) {
        return customerRepository.isCustomerExist(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }
}
