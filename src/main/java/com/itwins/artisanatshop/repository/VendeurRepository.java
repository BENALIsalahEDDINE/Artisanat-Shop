package com.itwins.artisanatshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwins.artisanatshop.models.Panier;
import com.itwins.artisanatshop.models.Vendeur;

import java.util.List;

public interface VendeurRepository extends JpaRepository<Vendeur,Integer> {
    void delete(Vendeur vendeur);
    public Vendeur findById(int id);
    
}
