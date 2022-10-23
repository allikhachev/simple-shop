package com.ocmwdt.edu.simpleshop.services;

import com.ocmwdt.edu.simpleshop.models.Customer;
import com.ocmwdt.edu.simpleshop.models.Order;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderSvc {
    public List<Order> getAll(Long cusId) {
        return Collections.emptyList();
    }

    public Customer get(Long cusId) {
        return null;
    }

    public void add(Order customer) {

    }

    public void update(Long cusId, Order customer) {

    }
}
