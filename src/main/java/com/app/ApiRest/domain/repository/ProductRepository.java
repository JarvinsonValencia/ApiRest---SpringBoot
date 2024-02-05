package com.app.ApiRest.domain.repository;

import com.app.ApiRest.domain.Products;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Products> getAll();
    Optional<List<Products>> getByCategory(Long idCategory);
    Optional<Products> getProduct(Long idProduct);
    Products save(Products product);
    void delete(Long idProduct);
}
