package org.richard.backend.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategory createCategory(String name, Long parentCategoryId) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(name);

        if (parentCategoryId != null) {
            ProductCategory parentCategory = productCategoryRepository.findById(parentCategoryId)
                    .orElseThrow(() -> new IllegalArgumentException("Parent productCategory not found"));
            productCategory.setParentProductCategory(parentCategory);
        }
        return productCategoryRepository.save(productCategory);
    }

    public List<ProductCategory> getAllCategories() {
        return productCategoryRepository.findAll();
    }

    public List<ProductCategory> getSubCategories(Long parentCategoryId) {
        ProductCategory parentCategory = productCategoryRepository.findById(parentCategoryId)
                .orElseThrow(() -> new IllegalArgumentException("Parent category not found"));
        return productCategoryRepository.findByParentCategory(parentCategory);
    }

    public Optional<ProductCategory> getCategoryById(Long id) {
        return productCategoryRepository.findById(id);
    }
}