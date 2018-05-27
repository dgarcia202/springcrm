package com.github.dgarcia202.springcrm.services;

import com.github.dgarcia202.springcrm.dataaccess.entities.Address;
import com.github.dgarcia202.springcrm.dataaccess.entities.Customer;
import com.github.dgarcia202.springcrm.dataaccess.repositories.AddressRepository;
import com.github.dgarcia202.springcrm.dataaccess.repositories.CustomerRepository;
import com.github.dgarcia202.springcrm.exceptions.CrmItemNotFoundException;
import com.github.dgarcia202.springcrm.rest.rto.AddressRto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerUpdateService {

    private CustomerRepository customers;

    private AddressRepository addresses;

    public CustomerUpdateService(CustomerRepository customers, AddressRepository addresses) {
        this.customers = customers;
        this.addresses = addresses;
    }

    public void addAddress(long customerId, AddressRto addressData) throws CrmItemNotFoundException {

        Optional<Customer> customer = customers.findById(customerId);
        if (!customer.isPresent()) {
            throw new CrmItemNotFoundException();
        }

        Address address = new Address();
        address.setCustomer(customer.get());
        address.setState(addressData.getState());
        address.setPostalCode(addressData.getPostalCode());
        address.setCountry(addressData.getCountry());
        address.setCity(addressData.getCity());
        address.setAddressLine1(addressData.getAddressLine1());
        address.setAddressLine2(addressData.getAddressLine2());
        addresses.saveAndFlush(address);
    }
}
