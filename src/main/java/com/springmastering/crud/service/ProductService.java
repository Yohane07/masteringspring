package com.springmastering.crud.service;


import com.springmastering.crud.model.Product;
import org.springframework.stereotype.Service;
import com.springmastering.crud.repository.ProductRepository;

import java.util.List;
@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Product save(Product p) {
        return repo.save(p);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
