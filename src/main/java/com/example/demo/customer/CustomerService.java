package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        LOGGER.info("getCustomers call");
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> {
                            LOGGER.error("error");
                            return new NotFoundException("Customer id " + id + " Not Found");
                        });
    }
}
