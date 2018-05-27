package com.github.dgarcia202.springcrm.rest.controllers;

import com.github.dgarcia202.springcrm.dataaccess.entities.CustomerStatus;
import com.github.dgarcia202.springcrm.dataaccess.repositories.CustomerStatusRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer-statuses")
public class CustomerStatusRestController {

    private CustomerStatusRepository customerStatuses;

    public CustomerStatusRestController(CustomerStatusRepository customerStatuses) {
        this.customerStatuses = customerStatuses;
    }

    @GetMapping()
    public ResponseEntity<List<CustomerStatus>> getCustomerStatuses() {
        return new ResponseEntity<>(customerStatuses.findAll(), HttpStatus.OK);
    }
}
