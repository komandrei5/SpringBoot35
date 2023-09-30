package com.shop.service;

import com.shop.dto.ProductDto;
import com.shop.entity.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    List<Product> getProducts();

    Page<Product> getProductsPage(Pageable page);

    Long addProduct(ProductDto product);

    Product getProductById(Long id);

}
