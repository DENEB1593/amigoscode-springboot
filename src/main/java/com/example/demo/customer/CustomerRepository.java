package com.example.demo.customer;

import com.example.demo.exception.NotFoundException;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {
    public List<Customer> getCustomers() {
        return Lists.newArrayList(
                new Customer(1L, "John", "1234", "email@email.com"),
                new Customer(2L, "Park", "1234", "email@email.com")
            );
    }

    public Customer getCustomerById(Long id) {
        return getCustomers().stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Customer id "+ id +" Not Found"));
    }
}
