package com.itwins.artisanatshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwins.artisanatshop.models.LigneCommande;

import java.util.List;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer> {

    List<LigneCommande> findByCommandeId(int commandeId);
}
