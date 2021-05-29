 package com.itwins.artisanatshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

 
import com.itwins.artisanatshop.models.Vente;

public interface VenteRepository extends JpaRepository<Vente, Integer> {
	 List<Vente> findAll();

}

