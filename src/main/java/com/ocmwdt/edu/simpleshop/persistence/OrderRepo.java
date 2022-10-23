package com.ocmwdt.edu.simpleshop.persistence;

import com.ocmwdt.edu.simpleshop.models.Customer;
import com.ocmwdt.edu.simpleshop.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
