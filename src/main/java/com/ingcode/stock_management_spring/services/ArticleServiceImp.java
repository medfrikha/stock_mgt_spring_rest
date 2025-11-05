package com.ingcode.stock_management_spring.services;

import com.ingcode.stock_management_spring.entities.Article;
import com.ingcode.stock_management_spring.entities.Provider;
import com.ingcode.stock_management_spring.exceptions.ResourceNotFoundException;
import com.ingcode.stock_management_spring.repositories.ArticleRepository;
import com.ingcode.stock_management_spring.repositories.ProviderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImp implements  ArticleService {
        private final ArticleRepository articleRepository;
        private  final ProviderRepository providerRepository;

    public ArticleServiceImp(ArticleRepository articleRepository, ProviderRepository providerRepository) {
        this.articleRepository = articleRepository;
        this.providerRepository = providerRepository;
    }


    @Override
    public Article saveArticle(Article article, Long providerId ) {
        Provider provider = providerRepository.findById(providerId).orElseThrow(()->new ResourceNotFoundException("provider id : "+providerId+" not found"));
        article.setProvider(provider);
        return articleRepository.save(article);
    }

    @Override
    public List<Article> getAllArticles() {
        return (List<Article>)articleRepository.findAll();
    }

    @Override
    public Article getArticleById(Long id) {
        return articleRepository.findById(id).orElse(null) ;
    }

    @Override
    public Article updateArticle(Long id, Article article) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteArticle(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article not found with id: " + id));
 articleRepository.delete(article);
 return ResponseEntity.ok().build();
    }
}
