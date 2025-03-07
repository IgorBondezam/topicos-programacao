package com.topicos.programacao.campeonato.controller;

import com.topicos.programacao.campeonato.domain.Product;
import com.topicos.programacao.campeonato.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity findAll() {
        try {
            return ResponseEntity.ok(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(service.findById(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product) {
        return ResponseEntity.status(201).body(service.createProduct(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        try {
            return ResponseEntity.ok(service.updateProduct(id, product));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") Long id) {
        try {
            service.deleteProduct(id);
            return ResponseEntity.status(204).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
