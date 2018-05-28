package com.github.dgarcia202.springcrm.services;

import com.github.dgarcia202.springcrm.dataaccess.entities.Address;
import com.github.dgarcia202.springcrm.dataaccess.entities.Customer;
import com.github.dgarcia202.springcrm.dataaccess.entities.CustomerStatus;
import com.github.dgarcia202.springcrm.dataaccess.repositories.CustomerRepository;
import com.github.dgarcia202.springcrm.rest.rto.AddressRto;
import com.github.dgarcia202.springcrm.rest.rto.CustomerCreationRto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerCreationService {

    private final long INITIAL_CUSTOMER_STATUS = 2;

    private CustomerRepository customers;

    public CustomerCreationService(CustomerRepository customers) {
        this.customers = customers;
    }

    public Customer create(CustomerCreationRto customerCreation) {

        CustomerStatus status = new CustomerStatus();
        status.setId(INITIAL_CUSTOMER_STATUS);

        Customer customer = new Customer();
        customer.setName(customerCreation.getName());
        customer.setStatus(status);

        return customers.saveAndFlush(customer);
    }
}
