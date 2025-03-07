package com.topicos.programacao.campeonato.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    private String name;
    @Getter
    private Double price;
    @Getter
    private String description;

    @ManyToMany
    @JoinTable(
            name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    public Product(Long id, String name, Double price, String description, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.categories = categories;
    }


    public Product() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
