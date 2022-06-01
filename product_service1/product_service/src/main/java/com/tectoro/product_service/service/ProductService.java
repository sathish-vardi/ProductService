package com.tectoro.product_service.service;

import com.tectoro.product_service.dto.ProductRequest;
import com.tectoro.product_service.dto.ProductResponse;
import com.tectoro.product_service.entity.Product;
import com.tectoro.product_service.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    System.out.println("Testing");

@Autowired
    private   ProductRepository productRepository;
    public void createProduct(Product product) {
      System.out.println("Ready to save!!");
        productRepository.save(product);
        System.out.println(" save!!");
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
