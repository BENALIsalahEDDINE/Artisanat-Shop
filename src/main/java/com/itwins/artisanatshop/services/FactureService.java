package com.itwins.artisanatshop.services;

import com.itwins.artisanatshop.models.Facture;
import com.itwins.artisanatshop.repository.FactureRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class FactureService {

    private final FactureRepository factureRepository;


    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }
/*
    public List<Facture> findByproduitContaining(String produit) {
        return factureRepository.findByProduitContaining(produit);
    }*/

    public List<Facture> findAll() {return  factureRepository.findAll();
    }

    public Optional<Facture> findById(int factureId) {
        return factureRepository.findById(factureId);
    }

    public boolean deleteById(int factureId) {try {
        factureRepository.deleteById(factureId);
    } catch (Exception ex) {
        return false;
    }
        return true;}


    public Facture saveFacture(Facture Facture) {return factureRepository.save(Facture);
    }
}
