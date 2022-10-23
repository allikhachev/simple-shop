package com.ocmwdt.edu.simpleshop.services;

import com.ocmwdt.edu.simpleshop.models.Product;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductSvc {
    public List<Product> getAll() {
        return Collections.emptyList();
    }

    public Product get(Long productId) {
        return null;
    }

    public void add(Product product) {

    }

    public void update(Long productId, Product product) {

    }
}
