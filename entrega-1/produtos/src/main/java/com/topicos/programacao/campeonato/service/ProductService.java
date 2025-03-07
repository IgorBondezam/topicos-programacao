package com.topicos.programacao.campeonato.service;

import com.topicos.programacao.campeonato.domain.Product;
import com.topicos.programacao.campeonato.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }
    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product productUpdate = findById(id);
        productUpdate.setCategories(productUpdate.getCategories());
        productUpdate.setDescription(productUpdate.getDescription());
        productUpdate.setName(productUpdate.getName());
        productUpdate.setPrice(productUpdate.getPrice());
        return repository.save(product);
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}
