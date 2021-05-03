package com.itwins.artisanatshop.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.itwins.artisanatshop.models.Category;
import com.itwins.artisanatshop.services.CategoryService;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @CrossOrigin()
    @PostMapping("category")
    public String add(@RequestBody Map<String, Object> categoryMap) {
        Category category = new Category(categoryMap);
        categoryService.saveCategory(category);

        return "{" + "category saved successfully." + "}";
    }

    @CrossOrigin()
    @GetMapping("category")
    public List<Category> index(@RequestParam(value = "search" , required = false	) String searchText) {
        if (searchText == null){
            return categoryService.findAllCategories();
        }
        return categoryService.findBySearch(searchText);


    }

    @CrossOrigin()
    @DeleteMapping("category/{id}")
    public String delete(@PathVariable int id) {
        if (categoryService.deleteCategory(id)) {
            return "{" + "The Category has been deleted sucessfully" + "}";
        }

        return " An error has occured. ";
    }

    @CrossOrigin()
    @GetMapping("category/{id}")
    public Optional<Category> getCategory(@PathVariable int id) {
        return categoryService.findCategory(id);

    }

    @CrossOrigin()
    @PutMapping("category/{id}")
    public Category update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int categoryId = Integer.parseInt(id);
        Optional<Category> category = categoryService.findCategory(categoryId);

        if (category.isPresent()) {
            Category c = category.get();
            c.setNom(body.get("nom"));
            c.setUrl(body.get("url"));
            c.setDescription(body.get("description"));
            return categoryService.saveCategory(c);
        }
        return null;
    }


}
