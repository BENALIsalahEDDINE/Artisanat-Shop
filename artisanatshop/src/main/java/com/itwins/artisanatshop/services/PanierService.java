package com.itwins.artisanatshop.services;

import com.itwins.artisanatshop.models.Panier;
import com.itwins.artisanatshop.repository.PanierRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PanierService {

    private final PanierRepository panierRepository;

    public PanierService(PanierRepository panierRepository) {
        this.panierRepository = panierRepository;
    }

    public void delete(Panier panier) { panierRepository.delete(panier);};
    public Panier findById(int id) {return  panierRepository.findById(id);};
    public List<Panier> findByPrixGreaterThan(int prixLimit) {return panierRepository.findByPrixGreaterThan(prixLimit);};
}
