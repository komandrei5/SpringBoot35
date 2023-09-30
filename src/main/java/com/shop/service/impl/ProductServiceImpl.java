package com.shop.service.impl;

import com.shop.dto.ProductDto;
import com.shop.entity.Product;
import com.shop.exceptions.ProductNotFoundException;
import com.shop.repository.ProductRepository;
import com.shop.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("COULD NOT FOUND PRODUCT"));
    }

    @Override
    public Page<Product> getProductsPage(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Long addProduct(ProductDto product) {
        Product productEntity = new Product().setName(product.getName()).setPrice(product.getPrice());
        return repository.save(productEntity).getId();
    }
}
