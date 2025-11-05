package com.ingcode.stock_management_spring.repositories;

import com.ingcode.stock_management_spring.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
