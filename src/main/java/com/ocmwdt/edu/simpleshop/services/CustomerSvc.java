package com.ocmwdt.edu.simpleshop.services;

import com.ocmwdt.edu.simpleshop.models.Customer;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomerSvc {
    public List<Customer> getAll() {
        return Collections.emptyList();
    }

    public Customer get(Long cusId) {
        return null;
    }

    public void add(Customer customer) {

    }

    public void update(Long cusId, Customer customer) {

    }
}
