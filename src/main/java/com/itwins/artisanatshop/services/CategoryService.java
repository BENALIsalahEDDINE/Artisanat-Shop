package com.itwins.artisanatshop.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.itwins.artisanatshop.models.Category;
import com.itwins.artisanatshop.repository.CategoryRepository;

@Service
@Transactional

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public List<Category> findAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    public boolean deleteCategory(int id) {
        try {
            categoryRepository.deleteById(id);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public Optional<Category> findCategory(int id) {

        return categoryRepository.findById(id);

    }

    public Category saveCategory(Category product) {
        return categoryRepository.save(product);
    }


    public List<Category> findBySearch(String searchText) {
        return categoryRepository.findByNomContaining(searchText);
    }
}

