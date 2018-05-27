package com.github.dgarcia202.springcrm.rest.controllers;

import com.github.dgarcia202.springcrm.dataaccess.entities.Customer;
import com.github.dgarcia202.springcrm.dataaccess.repositories.CustomerRepository;
import com.github.dgarcia202.springcrm.rest.rto.CustomerCreationRto;
import com.github.dgarcia202.springcrm.services.CustomerCreationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("customers")
public class CustomerRestController {

    private CustomerRepository customers;

    private CustomerCreationService customerCreationService;

    public CustomerRestController(CustomerRepository customers, CustomerCreationService customerCreationService) {
        this.customers = customers;
        this.customerCreationService = customerCreationService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<>(customers.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerCreationRto requestBody) {

        customerCreationService.create(requestBody.getName());

        return ResponseEntity
                .ok()
                .build();
    }
}
