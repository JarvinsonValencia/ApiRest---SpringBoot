package com.app.ApiRest.domain.service;

import com.app.ApiRest.domain.Products;
import com.app.ApiRest.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Products> getAll() {
        return productRepository.getAll();
    }

    public Optional<Products> getProduct(Long idProduct) {
        return productRepository.getProduct(idProduct);
    }

    public Optional<List<Products>> getByCategory(Long idCategory) {
        return productRepository.getByCategory(idCategory);
    }

    public Products save(Products product) {
        return productRepository.save(product);
    }

    public boolean delete(Long idProduct) {
        return getProduct(idProduct).map(product -> {
            productRepository.delete(idProduct);
            return true;
        }).orElse(false);
    }
}
