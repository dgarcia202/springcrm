package com.github.dgarcia202.springcrm.services;

import com.github.dgarcia202.springcrm.dataaccess.entities.Address;
import com.github.dgarcia202.springcrm.dataaccess.entities.Customer;
import com.github.dgarcia202.springcrm.dataaccess.repositories.AddressRepository;
import com.github.dgarcia202.springcrm.dataaccess.repositories.CustomerRepository;
import com.github.dgarcia202.springcrm.exceptions.CrmItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerDataService {

    private CustomerRepository customerRepository;

    private AddressRepository addressRepository;

    public CustomerDataService(CustomerRepository customers, AddressRepository addressRepository) {
        this.customerRepository = customers;
        this.addressRepository = addressRepository;
    }

    public List<Address> getCustomerAddresses(long customerId) throws CrmItemNotFoundException {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (!customer.isPresent()) {
            throw new CrmItemNotFoundException();
        }

        return addressRepository.findByCustomerId(customerId);
    }
}
