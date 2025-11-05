package com.ingcode.stock_management_spring.services;

import com.ingcode.stock_management_spring.entities.Article;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArticleService {
    public Article saveArticle(Article article,Long providerId );
    public List<Article> getAllArticles();
    public Article getArticleById(Long id);
    public Article updateArticle(Long id, Article article);
    public ResponseEntity<?> deleteArticle(Long id);
}
