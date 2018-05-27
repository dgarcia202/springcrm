package com.github.dgarcia202.springcrm.rest.controllers;

import com.github.dgarcia202.springcrm.exceptions.CrmItemNotFoundException;
import com.github.dgarcia202.springcrm.rest.rto.AddressRto;
import com.github.dgarcia202.springcrm.services.CustomerUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customers/{customerId}/addresses")
public class CustomerAddressRestController {

    private CustomerUpdateService customerUpdateService;

    public CustomerAddressRestController(CustomerUpdateService customerUpdateService) {
        this.customerUpdateService = customerUpdateService;
    }

    @PostMapping
    public ResponseEntity addCustomerAddress(@PathVariable long customerId, @RequestBody AddressRto address) throws CrmItemNotFoundException {
        customerUpdateService.addAddress(customerId, address);
        return ResponseEntity.ok().build();
    }
}
