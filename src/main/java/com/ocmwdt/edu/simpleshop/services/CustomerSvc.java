package com.ocmwdt.edu.simpleshop.services;

import com.ocmwdt.edu.simpleshop.exceptions.NotFound;
import com.ocmwdt.edu.simpleshop.models.Customer;
import com.ocmwdt.edu.simpleshop.persistence.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerSvc {

    public static final String NO_CUSTOMER = "Customer %d is not found";
    private final CustomerRepo repo;

    public List<Customer> getAll() {
        return repo.findAll();
    }

    public Customer get(Long cusId) {
        return repo.findById(cusId)
                .orElseThrow(() -> new NotFound(NO_CUSTOMER.formatted(cusId)));
    }

    public void add(Customer customer) {
        repo.save(customer);
    }

    public void update(Long cusId, Customer customer) {
        var target = repo.findById(cusId)
                .orElseThrow(() -> new NotFound(NO_CUSTOMER.formatted(cusId)));
        updateCustomer(target, customer);
        repo.save(target);
    }

    private void updateCustomer(Customer target, Customer source) {
        target.setName(source.getName());
    }
}
