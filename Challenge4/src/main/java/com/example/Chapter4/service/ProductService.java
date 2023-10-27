package com.example.Chapter4.service;

import com.example.Chapter4.model.Product;
import com.example.Chapter4.repository.ProductRepository;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    public List<Product> getAll(){
        return productRepository.findAll();
    }
//    public Product getById(UUID id){
//        Optional<Product> productOptional = productRepository.findById(id);
//        if(productOptional.isPresent()){
//            return productOptional.get();
//        }throw new RuntimeException();
//    }
//    public Product create(Product product){
//        product.setCreatedDate(LocalDateTime.now());
//        return productRepository.save(product);
//    }
}
