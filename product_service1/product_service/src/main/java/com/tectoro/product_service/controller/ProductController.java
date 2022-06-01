package com.tectoro.product_service.controller;

import com.tectoro.product_service.dto.ProductRequest;
import com.tectoro.product_service.dto.ProductResponse;
import com.tectoro.product_service.entity.Product;
import com.tectoro.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product) {
        if(product != null){
            productService.createProduct(product);

        }else {
            System.out.println("Data not found!!");
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

}