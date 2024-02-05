package com.app.ApiRest.persistence.crud;

import com.app.ApiRest.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PoductCrudRepository extends JpaRepository<Product, Long> {

    List<Product> findByIdCategoryOrderByNameAsc(Long idCategory);
    Optional<List<Product>> findByQuantityStockLessThanAndStatus(Integer quantityStock, Boolean status);

}
