package com.app.ApiRest.persistence.mapper;

import com.app.ApiRest.domain.Products;
import com.app.ApiRest.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "salePrice", target = "price"),
            @Mapping(source = "quantityStock", target = "stock"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "category", target = "category")
    })
    Products toProduct(Product product);
    List<Products> toProducts(List<Product> products);
    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    Product toProduct(Products products);
}
