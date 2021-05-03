package com.itwins.artisanatshop.controllers;

import com.itwins.artisanatshop.models.Article;
import com.itwins.artisanatshop.services.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@RestController
public class ArticleController {
    @Autowired
    private ArticleService ArticleService;

    @CrossOrigin()
    @GetMapping("/Article")
    public List<Article> index(){
        return ArticleService.findAll();
    }
    @CrossOrigin()
    @GetMapping("/Article/{id}")
    public Optional<Article> ArticleById(@PathVariable String id) {
        int ArticleId = Integer.parseInt(id);
        return ArticleService.findById(ArticleId);
    }
    @CrossOrigin()

    @PostMapping("/Article")
    public Article create(@RequestBody Map<String, Object> ArticleMap) {
        Article Article = new Article(ArticleMap);
        return ArticleService.saveArticle(Article);
    }
    @CrossOrigin()

    @PutMapping("/Article/{id}")
    public Article update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int ArticleId = Integer.parseInt(id);
        Optional<Article> Article = ArticleService.findById(ArticleId);
        if (Article.isPresent()) {
            Article f = Article.get();
            f.setEditeur(body.get("editeur"));
            f.setDateCreation(body.get("datecreation"));
            f.setCategorie(body.get("categorie"));
            f.setTitre(body.get("titre"));
            f.setText(body.get("text"));
            f.setImageurl(body.get("imageurl"));
            return ArticleService.saveArticle(f);
        }
        return null;
    }
    @CrossOrigin()
    @DeleteMapping("/Article/{id}")
    public boolean delete(@PathVariable String id) {
        int ArticleId = Integer.parseInt(id);
        return ArticleService.deleteById(ArticleId);
    }
    @CrossOrigin()
    @PostMapping("/Article/search")
    public List<Article> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return ArticleService.findByTitreContainingOrTextContaining(searchTerm, searchTerm);
    }

}
