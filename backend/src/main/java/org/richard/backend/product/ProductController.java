package org.richard.backend.product;

import lombok.RequiredArgsConstructor;
import org.richard.backend.file.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final FileStorageService fileStorageService;
    private final ProductService productService;
    private final ProductCategoryService productCategoryService;

    @PostMapping
    public ResponseEntity<Product> createProduct(
            @RequestParam("name") String name,
            @RequestParam("categoryId") Long categoryId,
            @RequestParam("images") List<MultipartFile> images
    ) throws IOException {
        // Create a new product
        Product product = productService.createProduct(name, categoryId, images);




        // Save each image and create ProductImage entries
        for (MultipartFile image : images) {
            String imagePath = fileStorageService.saveImage(image);

            ProductImage productImage = new ProductImage();
            productImage.setImagePath(imagePath);
            productImage.setProduct(product);
            product.getImages().add(productImage);
        }

        productRepository.save(product);

        return ResponseEntity.ok(product);
    }
}