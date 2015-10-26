package com.edu.repository.impl;

import com.edu.domain.Customer;
import com.edu.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ed on 10/26/15.
 */

@Repository
public class InMemoryCustomerRepository implements CustomerRepository{

    private List<Customer> listOfCustomers = new ArrayList<Customer>();

    public InMemoryCustomerRepository() {

        Customer customer1 = new Customer("C1234", "Homero Simpson", "Calle Siempre Viva 1234");

        listOfCustomers.add(customer1);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return listOfCustomers;
    }
}
