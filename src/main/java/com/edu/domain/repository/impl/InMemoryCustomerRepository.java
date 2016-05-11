package com.edu.domain.repository.impl;

import com.edu.domain.Customer;
import com.edu.domain.repository.CustomerRepository;
import com.edu.exception.CustomerNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ed on 10/26/15.
 */

@Repository
public class InMemoryCustomerRepository implements CustomerRepository{

    private List<Customer> listOfCustomers = new ArrayList<Customer>();

    public InMemoryCustomerRepository() {

        Customer customer1 = new Customer("C1234", "Homero Simpson");

        listOfCustomers.add(customer1);
    }

    public void saveCustomer(Customer customer) {
        listOfCustomers.add(customer);
    }

    public Boolean isCustomerExist(String customerId) {
        Boolean exist = true;

        try {
            this.getCustomer(customerId);
        } catch(CustomerNotFoundException e) {
            exist = false;
        }

        return exist;
    }

    public Customer getCustomer(String customerId) {
        Customer customerById = null;

        for (Customer customer: listOfCustomers) {
            if(customer != null && !StringUtils.isEmpty(customer.getCustomerId()) && customer.getCustomerId().equals(customerId)) {
                customerById = customer;
                break;
            }
        }

        if(customerById == null) {
            throw new CustomerNotFoundException("No Customer found with the id: " + customerId);
        }

        return customerById;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return listOfCustomers;
    }
}
