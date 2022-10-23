package com.ocmwdt.edu.simpleshop.services;

import com.ocmwdt.edu.simpleshop.exceptions.NotFound;
import com.ocmwdt.edu.simpleshop.models.Product;
import com.ocmwdt.edu.simpleshop.persistence.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductSvc {

    public static final String NO_PRODUCT = "Product %d is not found";

    private final ProductRepo repo;

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product get(Long productId) {
        return repo.findById(productId)
                .orElseThrow(() -> new NotFound(NO_PRODUCT.formatted(productId)));
    }

    public void add(Product product) {
        repo.save(product);

    }

    public void update(Long productId, Product product) {
        var target = repo.findById(productId)
                .orElseThrow(() -> new NotFound(NO_PRODUCT.formatted(productId)));
        updateProduct(target, product);
        repo.save(target);
    }

    private void updateProduct(Product target, Product source) {
        target.setName(source.getName());
    }
}
