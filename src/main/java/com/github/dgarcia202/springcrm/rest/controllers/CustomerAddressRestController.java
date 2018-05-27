package com.github.dgarcia202.springcrm.rest.controllers;

import com.github.dgarcia202.springcrm.dataaccess.entities.Address;
import com.github.dgarcia202.springcrm.exceptions.CrmItemNotFoundException;
import com.github.dgarcia202.springcrm.rest.rto.AddressRto;
import com.github.dgarcia202.springcrm.services.CustomerDataService;
import com.github.dgarcia202.springcrm.services.CustomerUpdateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers/{customerId}/addresses")
public class CustomerAddressRestController {

    private CustomerDataService customerDataService;

    private CustomerUpdateService customerUpdateService;

    public CustomerAddressRestController(CustomerDataService customerDataService, CustomerUpdateService customerUpdateService) {
        this.customerDataService = customerDataService;
        this.customerUpdateService = customerUpdateService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getCustomerAddresses(@PathVariable long customerId) throws CrmItemNotFoundException {
        return new ResponseEntity<>(customerDataService.getCustomerAddresses(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addCustomerAddress(@PathVariable long customerId, @RequestBody AddressRto address) throws CrmItemNotFoundException {
        customerUpdateService.addAddress(customerId, address);
        return ResponseEntity.ok().build();
    }
}
