package com.app.ApiRest.web.controller;

import com.app.ApiRest.domain.Products;
import com.app.ApiRest.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    /*
    @GetMapping("/all")
    public List<Products> getAll() {
        return productService.getAll();
    }*/

    @GetMapping("/all")
    public ResponseEntity<List<Products>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Products> save(@RequestBody Products product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }
}
