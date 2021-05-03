package com.itwins.artisanatshop.services;

import com.itwins.artisanatshop.models.Commande;
import com.itwins.artisanatshop.repository.CommandeRepository;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommandeService {

    private final CommandeRepository commandeRepository;


    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    public List<Commande> getCommandesByUserId(int userId) {
        return commandeRepository.findByUserId(userId);
    }

    public Optional<Commande> findById(int id) {
        return commandeRepository.findById(id);
    }

    public void deleteById(int id) {
        commandeRepository.deleteById(id);
    }

    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

}
