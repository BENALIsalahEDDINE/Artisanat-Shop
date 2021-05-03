package com.itwins.artisanatshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwins.artisanatshop.models.Facture;

import java.util.List;
import java.util.Optional;

public interface FactureRepository extends JpaRepository<Facture, Integer> {


    //Facture save(Facture facture);


    Optional<Facture> findById(int factureId);

    List<Facture> findAll();


 //List<Facture> findByProduitContaining(String produit);
}
