package com.satya.springecom.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.satya.springecom.Models.Product;
import com.satya.springecom.Repo.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product insertProduct(Product newProductEntity, MultipartFile imageFile) throws IOException {
        newProductEntity.setImageName(imageFile.getOriginalFilename());
        newProductEntity.setImageType(imageFile.getContentType());
        newProductEntity.setImageData(imageFile.getBytes());
        return productRepository.save(newProductEntity);
    }

    public String updateProductbyId(int id, Product updateProductEntity) {
        return productRepository.findById(id).map(product -> {
            product.setName(updateProductEntity.getName());
            product.setDescription(updateProductEntity.getDescription());
            product.setBrand(updateProductEntity.getBrand());
            product.setPrice(updateProductEntity.getPrice());
            product.setCategory(updateProductEntity.getCategory());
            product.setReleaseDate(updateProductEntity.getReleaseDate());
            product.setInStock(updateProductEntity.getInStock());
            product.setStockQuantity(updateProductEntity.getStockQuantity());
            productRepository.save(product);
            return "Product with id " + id + " updated successfully";
        }).orElse("Product with id " + id + " not found");
    }
}