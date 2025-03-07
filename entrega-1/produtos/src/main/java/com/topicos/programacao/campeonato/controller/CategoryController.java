package com.topicos.programacao.campeonato.controller;

import com.topicos.programacao.campeonato.domain.Category;
import com.topicos.programacao.campeonato.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping
    public ResponseEntity createCategory(@RequestBody Category category) {
        return ResponseEntity.status(201).body(service.createCategory(category));
    }

    @GetMapping
    public ResponseEntity findAllCategory() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findAllCategory(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity createCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        return ResponseEntity.ok(service.updateCategory(id, category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity createCategory(@PathVariable("id") Long id) {
        service.deleteCategory(id);
        return ResponseEntity.status(204).build();
    }

}
