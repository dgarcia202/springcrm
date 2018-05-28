package com.github.dgarcia202.springcrm.rest.controllers;

import com.github.dgarcia202.springcrm.dataaccess.entities.Customer;
import com.github.dgarcia202.springcrm.dataaccess.repositories.CustomerRepository;
import com.github.dgarcia202.springcrm.rest.rto.CustomerCreationRto;
import com.github.dgarcia202.springcrm.services.CustomerCreationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.xml.ws.Response;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable(required = true) long customerId) {
        Optional<Customer> customer = customers.findById(customerId);
        if (!customer.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(customer.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody CustomerCreationRto customerCreation) {

        Customer customer = customerCreationService.create(customerCreation);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{customerId}")
                .buildAndExpand(customer.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .build();
    }
}
