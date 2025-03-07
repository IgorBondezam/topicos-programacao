package com.topicos.programacao.campeonato.repository;

import com.topicos.programacao.campeonato.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
