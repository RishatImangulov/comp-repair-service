package org.richard.backend.product;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.richard.backend.file.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    private  final FileStorageService fileStorageService;

    private final  ProductCategoryRepository categoryRepository;

    @Transactional
    public Product createProduct(String name, Long categoryId, List<MultipartFile> images) throws IOException {
        // Find productCategory by ID
        ProductCategory productCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        // Create a new product
        Product product = new Product();
        product.setName(name);
        product.setProductCategory(productCategory);

        // Save each image and add to product
        for (MultipartFile image : images) {
            String imagePath = fileStorageService.saveImage(image);

            ProductImage productImage = new ProductImage();
            productImage.setImagePath(imagePath);
            productImage.setProduct(product);

            product.getImages().add(productImage);
        }

        // Save the product
        return productRepository.save(product);
    }

    public List<Product> getProductsByCategory(Long categoryId) {
        ProductCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));

        return productRepository.findByCategory(category);
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }
}
