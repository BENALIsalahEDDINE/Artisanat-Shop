package com.itwins.artisanatshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwins.artisanatshop.models.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer>{

    List<Article> findAll();

    Optional<Article> findById(int ArticleId);

    List<Article> findByTitreContainingOrTextContaining(String titre, String texte);
}
