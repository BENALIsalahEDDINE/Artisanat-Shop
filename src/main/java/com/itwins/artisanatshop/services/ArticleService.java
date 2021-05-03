package com.itwins.artisanatshop.services;

import com.itwins.artisanatshop.models.Article;
import com.itwins.artisanatshop.repository.ArticleRepository;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ArticleService {
    private final ArticleRepository ArticleRepository;
    public  ArticleService (ArticleRepository articleRepository){ this.ArticleRepository = articleRepository;}
    public List<Article> findAll() {
        return ArticleRepository.findAll();
    }
    public Optional<Article> findById(int ArticleId) { return ArticleRepository.findById(ArticleId);
    }
    public Article saveArticle(Article article) { return ArticleRepository.save(article);
    }
    public boolean deleteById(int ArticleId) {try {
        ArticleRepository.deleteById(ArticleId);
    } catch (Exception ex) {
        return false;
    }
        return true;
    }

    public List<Article> findByTitreContainingOrTextContaining(String titre, String texte) {
        return ArticleRepository.findByTitreContainingOrTextContaining(titre, texte);
    }
}
