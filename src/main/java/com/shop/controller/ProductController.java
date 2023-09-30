package com.shop.controller;

import com.shop.dto.ProductDto;
import com.shop.entity.Product;
import com.shop.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<Product> getProducts() {
        log.info("Run method get all products");
        return service.getProducts();
    }

    @GetMapping("/page")
    public Page<Product> getProductsPage(@RequestParam int page, @RequestParam int size) {
        log.info("Run method get all products");
        return service.getProductsPage(PageRequest.of(page, size));
    }

    @PostMapping
    public Long addNewProduct(@RequestBody ProductDto product){
        log.info("Run method add new product");
        return service.addProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        log.info("Run method get product by id");
        return service.getProductById(id);
    }
}
