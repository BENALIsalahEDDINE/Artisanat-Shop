package com.itwins.artisanatshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwins.artisanatshop.models.Commande;

import java.util.List;


public interface CommandeRepository  extends  JpaRepository<Commande, Integer>{
    List<Commande> findByUserId(int userId);
}
