package com.itwins.artisanatshop.repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itwins.artisanatshop.models.Panier;

import java.util.List;


public interface PanierRepository extends JpaRepository<Panier,Integer> {
   /* public List<Panier> findAll();
    public Panier findById(int id);
    public Panier save(Panier panier);*/

    void delete(Panier panier);
    public Panier findById(int id);
    List<Panier> findByPrixGreaterThan(int prixLimit);
    @Query("SELECT id, nom, prix , quantite FROM Panier  WHERE quantite > :quantiteLimit")
    List<Panier>  chercherUnProduitCher(@Param("quantiteLimit") int prix);


}
