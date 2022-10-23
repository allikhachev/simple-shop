package com.ocmwdt.edu.simpleshop.controllers;

import com.ocmwdt.edu.simpleshop.models.Product;
import com.ocmwdt.edu.simpleshop.services.ProductSvc;
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
@RequestMapping("/products")
public class Products {

    private final ProductSvc productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable("id") Long productId) {
        return productService.get(productId);
    }

    @PostMapping
    public void add(@RequestBody Product product) {
        productService.add(product);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long productId, @RequestBody Product product) {
        productService.update(productId, product);
    }
}
