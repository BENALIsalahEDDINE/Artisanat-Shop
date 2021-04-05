package com.itwins.artisanatshop.repository;
import org.springframework.data.repository.CrudRepository;

import com.itwins.artisanatshop.models.Category;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {


    List<Category> findByNomContaining(String nom);
}
