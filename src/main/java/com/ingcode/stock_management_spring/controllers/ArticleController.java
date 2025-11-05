package com.ingcode.stock_management_spring.controllers;

import com.ingcode.stock_management_spring.entities.Article;
import com.ingcode.stock_management_spring.services.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }
    @PostMapping("/add/{providerId}")
    public Article addArticle(@PathVariable  Long providerId , @RequestBody Article article){
        return articleService.saveArticle(article, providerId);
    }
    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable Long id, @RequestBody Article article){
        return articleService.updateArticle(id, article);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long id){
        return articleService.deleteArticle(id);
    }
    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id){
        return articleService.getArticleById(id);
    }
}
