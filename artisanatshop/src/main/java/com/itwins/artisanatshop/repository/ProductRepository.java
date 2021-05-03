package com.itwins.artisanatshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwins.artisanatshop.models.Product;

//import ma.ac.emi.ginfo.entities.ProductEntity;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByNomContainingOrDescriptionContaining(String nom, String description);
	
	
	List<Product> findByIdCat(int idCat);
}
