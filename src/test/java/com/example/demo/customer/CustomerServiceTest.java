package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService(customerRepository);

    }

    @Test
    void getCustomers() {
        // given
        Customer john = new Customer(
                    1L,
                    "John",
                    "Hello",
                    "john@gmail.com"
                );

        Customer kim = new Customer(
                2L,
                "kim",
                "123432",
                "kim@gmail.com"
        );

        // when
        customerRepository.save(john);
        customerRepository.save(kim);

        // then
        List<Customer> actual = customerRepository.findAll();
        assertEquals(2, actual.size());
    }

    @Test
    void getCustomerById() {
        // given
        Customer john = new Customer(
                1L,
                "John",
                "Hello",
                "john@gmail.com"
        );

        // when
        customerRepository.save(john);

        // then
        Customer actual = customerRepository.getById(1L);
        assertEquals(1L, actual.getId());
        assertEquals("John", actual.getName());
        assertEquals("Hello", actual.getPassword());
        assertEquals("john@gmail.com", actual.getEmail());
    }

    @AfterEach
    void after() {
        customerRepository.deleteAll();
    }
}