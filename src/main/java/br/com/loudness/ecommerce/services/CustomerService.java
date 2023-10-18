package br.com.loudness.ecommerce.services;

import br.com.loudness.ecommerce.core.domain.dtos.customer.CustomerDto;
import br.com.loudness.ecommerce.core.domain.entities.Customer;
import br.com.loudness.ecommerce.core.domain.repositories.CustomerRepository;
import br.com.loudness.ecommerce.infra.exceptions.ControllerExceptionHandlle;
import br.com.loudness.ecommerce.infra.exceptions.CustomerAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public ResponseEntity<Object> createCustomer(CustomerDto customerDto) throws Exception {
        // validações
        if (customerRepository.findCustomerByEmail(customerDto.email()).isPresent()) {
           throw new CustomerAlreadyExistsException("Cliente já cadastrado");
        }

        Customer newCustomer = new Customer(customerDto);

        UUID id = UUID.randomUUID();

        // Setando um customerId
        newCustomer.setCustomerId(id);

        // CREATE ADDRESS

        // CREATE CART

        // CREATE LIKED

        // CREATE ASSESSMENTS

        customerRepository.save(newCustomer);

        return ResponseEntity.status(201).body(new MessageDto("Cadastro realizado com sucesso."));
    }

}
