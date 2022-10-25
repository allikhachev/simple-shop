package com.ocmwdt.edu.simpleshop.services;

import com.ocmwdt.edu.simpleshop.exceptions.NotFound;
import com.ocmwdt.edu.simpleshop.models.Customer;
import com.ocmwdt.edu.simpleshop.models.Order;
import com.ocmwdt.edu.simpleshop.models.OrderItem;
import com.ocmwdt.edu.simpleshop.persistence.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class OrderSvc {

    public static final String NO_ORDER = "Order %d is not found";

    private final OrderRepo repo;
    private final CustomerSvc customers;

    public List<Order> getAll(Long cusId) {
        return repo.findAll();
    }

    public Order get(Long orderId) {
        return repo.findById(orderId)
                .orElseThrow(() -> new NotFound(NO_ORDER.formatted(orderId)));
    }

    public void add(Order order) {
        repo.save(order);
    }

    public void update(Long orderId, Order order) {
        var target = repo.findById(orderId)
                .orElseThrow(() -> new NotFound(NO_ORDER.formatted(orderId)));
        var customer = customers.get(
                ofNullable(order.getCustomer()).map(Customer::getId).orElse(null));
        updateOrder(target, order.getItems(), customer);
        repo.save(target);
    }

    private void updateOrder(Order target, List<OrderItem> items, Customer customer) {
        target.setCustomer(customer);
        target.getItems().clear();
        target.getItems().addAll(ofNullable(items).orElse(emptyList()));
    }
}
