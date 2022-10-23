package com.ocmwdt.edu.simpleshop.persistence;

import com.ocmwdt.edu.simpleshop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {
}
