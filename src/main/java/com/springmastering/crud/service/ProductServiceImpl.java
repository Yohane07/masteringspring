package com.springmastering.crud.service;

import com.springmastering.crud.model.Product;
import com.springmastering.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImpl
        implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    //save Product
    @Override
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    //Recupérer tous les produits
    @Override
    public List<Product> fetchProductList() {
        return (List<Product>) productRepository.findAll();
    }

    // Mettre à jour le produit
    @Override
    public Product updateProduct(Product product, Long productId) {

        Product productDB
                = productRepository.findById(productId)
                .get();

        if (Objects.nonNull(product.getProductName())
                && !"".equalsIgnoreCase(
                product.getProductName())) {
            productDB.setProductName(
                    product.getProductName());
        }

        if (Objects.nonNull(
                product.getProductPrice())
                && !"".equalsIgnoreCase(
                String.valueOf(product.getProductPrice()))) {
            productDB.setProductPrice(
                    product.getProductPrice());
        }

        return productRepository.save(productDB);
    }

    // Supprimer un produit
    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }
}
