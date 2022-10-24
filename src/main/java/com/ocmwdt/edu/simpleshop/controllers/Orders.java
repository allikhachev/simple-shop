package com.ocmwdt.edu.simpleshop.controllers;

import com.ocmwdt.edu.simpleshop.models.Order;
import com.ocmwdt.edu.simpleshop.services.OrderSvc;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class Orders {

    private final OrderSvc orderSvc;

    @GetMapping
    public List<Order> getAll(@RequestParam("cus") Long cusId) {
        return orderSvc.getAll(cusId);
    }

    @GetMapping
    public List<Order> getAll() {
        return orderSvc.getAll();
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable("id") Long orderId) {
        return orderSvc.get(orderId);
    }

    @PostMapping
    public void add(@RequestBody Order order) {
        orderSvc.add(order);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long orderId, @RequestBody Order order) {
        orderSvc.update(orderId, order);
    }
}
