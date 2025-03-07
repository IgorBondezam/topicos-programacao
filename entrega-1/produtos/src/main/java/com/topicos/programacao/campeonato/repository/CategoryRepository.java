package com.topicos.programacao.campeonato.repository;

import com.topicos.programacao.campeonato.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
