package com.topicos.programacao.campeonato.service;

import com.topicos.programacao.campeonato.domain.Category;
import com.topicos.programacao.campeonato.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }
    public Category findById(Long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Category createCategory(Category category) {
        return repository.save(category);
    }

    public Category updateCategory(Long id,Category category) {
        Category categoryUpdate = findById(id);

        categoryUpdate.setName(category.getName());
        return repository.save(categoryUpdate);
    }

    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
