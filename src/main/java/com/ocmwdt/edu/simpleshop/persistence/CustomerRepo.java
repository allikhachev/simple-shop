package com.ocmwdt.edu.simpleshop.persistence;

import com.ocmwdt.edu.simpleshop.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
