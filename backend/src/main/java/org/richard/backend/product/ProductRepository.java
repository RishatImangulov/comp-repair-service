package org.richard.backend.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Find all products by a specific category
    List<Product> findByProductCategory(ProductCategory category);
}