package com.app.ApiRest.persistence;

import com.app.ApiRest.domain.Products;
import com.app.ApiRest.domain.repository.ProductRepository;
import com.app.ApiRest.persistence.crud.PoductCrudRepository;
import com.app.ApiRest.persistence.entity.Product;
import com.app.ApiRest.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class ProductoRepository implements ProductRepository {
    @Autowired
    private PoductCrudRepository productCrudRepository;
    @Autowired
    private ProductMapper mapper;


    @Override
    public List<Products> getAll() {
        return mapper.toProducts((List<Product>) productCrudRepository.findAll());
    }

    @Override
    public Optional<List<Products>> getByCategory(Long idCategory) {
        List<Product> products = productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
        return Optional.of(mapper.toProducts(products));
    }


    @Override
    public Optional<Products> getProduct(Long idProduct) {
        return productCrudRepository.findById(idProduct).map(product -> mapper.toProduct(product));
    }

    @Override
    public Products save(Products product) {
        Product product1 = mapper.toProduct(product);
        return mapper.toProduct(productCrudRepository.save(product1));
    }

    @Override
    public void delete(Long idProduct) {
        productCrudRepository.deleteById(idProduct);
    }
}
