package com.itwins.artisanatshop.services;


import com.itwins.artisanatshop.models.LigneCommande;
import com.itwins.artisanatshop.repository.LigneCommandeRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LigneCommandeService {

    private final LigneCommandeRepository ligneCommandeRepository;

    public LigneCommandeService(LigneCommandeRepository ligneCommandeRepository) {
        this.ligneCommandeRepository = ligneCommandeRepository;
    }


    public List<LigneCommande> getAllCommandes() {
        return ligneCommandeRepository.findAll();
    }
    public LigneCommande addLigneCommande(LigneCommande ligneCommande){
        return ligneCommandeRepository.save(ligneCommande);
    }

    public List<LigneCommande> getLigneCommandesByCommandeId(int commandeId) {
        return ligneCommandeRepository.findByCommandeId(commandeId);
    }

}
