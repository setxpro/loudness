package br.com.loudness.ecommerce.controllers;

import br.com.loudness.ecommerce.core.domain.dtos.customer.CustomerDto;
import br.com.loudness.ecommerce.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void createCustomer(@RequestBody @Valid CustomerDto customerDto) throws Exception {
        customerService.createCustomer(customerDto);
    }
}
