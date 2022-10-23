package com.ocmwdt.edu.simpleshop.controllers;

import com.ocmwdt.edu.simpleshop.models.Customer;
import com.ocmwdt.edu.simpleshop.services.CustomerSvc;
import com.ocmwdt.edu.simpleshop.services.OrderSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class Customers {

    private final CustomerSvc customerSvc;
    private final OrderSvc orderSvc;

    @GetMapping
    public List<Customer> getAll() {
        return customerSvc.getAll();
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable("id") Long cusId) {
        return customerSvc.get(cusId);
    }

    @PostMapping
    public void add(@RequestBody Customer customer) {
        customerSvc.add(customer);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long cusId, @RequestBody Customer customer) {
        customerSvc.update(cusId, customer);
    }
}
