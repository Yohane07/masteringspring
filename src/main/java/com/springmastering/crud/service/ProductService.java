package com.springmastering.crud.service;


import com.springmastering.crud.model.Product;
import org.springframework.stereotype.Service;
import com.springmastering.crud.repository.ProductRepository;

import java.util.List;
@Service
public interface ProductService {
    Product saveProduct(Product product);

    List<Product> fetchProductList();

    Product updateProduct(Product product, Long productId);

    void deleteProductById(Long productId);
}
