package com.itwins.artisanatshop.services;


import javax.transaction.Transactional;

//import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.itwins.artisanatshop.models.Product;
import com.itwins.artisanatshop.repository.ProductRepository;

//import ma.ac.emi.ginfo.entities.ProductEntity;
//import ma.ac.emi.ginfo.shared.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
	
	private final ProductRepository productRepository;
	
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Optional<Product> findById(int id) {
		return productRepository.findById(id);
	}
	
	public void deleteById(int id) {
		productRepository.deleteById(id);
	}
	
	public List<Product> findByNomContainingOrDescriptionContaining(String nom, String description) {
		return productRepository.findByNomContainingOrDescriptionContaining(nom, description);
	}
	
    public List<Product> getProducts(int idCat) {
		
		
		List<Product> products=new ArrayList<>();
		
		List<Product> productModel=productRepository.findByIdCat(idCat);

        for(Product productM: productModel) {

			products.add(productM);
		}
		
		return products;
	}
	
}
