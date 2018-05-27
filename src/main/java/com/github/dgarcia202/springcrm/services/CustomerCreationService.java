package com.github.dgarcia202.springcrm.services;

import com.github.dgarcia202.springcrm.dataaccess.entities.Customer;
import com.github.dgarcia202.springcrm.dataaccess.entities.CustomerStatus;
import com.github.dgarcia202.springcrm.dataaccess.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerCreationService {

    private final long INITIAL_CUSTOMER_STATUS = 2;

    private CustomerRepository customers;

    public CustomerCreationService(CustomerRepository customers) {
        this.customers = customers;
    }

    public void create(String name) {
        Customer customer =  new Customer(name, new CustomerStatus(INITIAL_CUSTOMER_STATUS), new Date());
        customers.saveAndFlush(customer);
    }
}
