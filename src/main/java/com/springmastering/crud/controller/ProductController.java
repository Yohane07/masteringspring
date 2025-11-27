package com.springmastering.crud.controller;

import com.springmastering.crud.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import com.springmastering.crud.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private final ProductService service;

    public ProductController(@Qualifier("productService") ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAll() {
        return service.fetchProductList();
    }
    /*
    @GetMapping("/{id}")
    public Product getOne(@PathVariable Long id) {
        return service.getById(id);
    }
    */


    @PostMapping
    public Product create(
           @RequestBody Product p) {

        return service.saveProduct(p);
    }

  @PutMapping("/{id}")
    public Product update(@RequestBody Product p, @PathVariable("id") Long id) {
        return service.updateProduct(p, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteProductById(id);
    }
}
