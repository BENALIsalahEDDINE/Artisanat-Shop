package com.itwins.artisanatshop.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.itwins.artisanatshop.models.*;
import com.itwins.artisanatshop.services.CommandeService;
import com.itwins.artisanatshop.services.LigneCommandeService;
import com.itwins.artisanatshop.services.ProductService;
import com.itwins.artisanatshop.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @Autowired
    private LigneCommandeService ligneCommandeService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @JsonView(View.Commandes.class)
    @PostMapping("/users/{userId}/commandes")
    @CrossOrigin()

    public Commande addCommande(@RequestBody Map<String, Object> map, @PathVariable int userId) {
        Commande commande = new Commande(map);
        User user = userService.findById(userId).get();
        commande.setUser(user);
        commandeService.addCommande(commande);

        List list = (ArrayList) map.get("listLigneCommande");
        List<LigneCommande> listLigneCommande = new ArrayList();
        if (list != null) {
            list.forEach((m) -> {
                LigneCommande ligneCommande = new LigneCommande((Map<String, Object>) m);
                Product product = productService.findById((int) ((Map<String, Object>) m).get("idProduit")).get();
                ligneCommande.setProduct(product);
                ligneCommande.setCommande(commande);
                ligneCommande.setTotal();
                ligneCommandeService.addLigneCommande(ligneCommande);
                listLigneCommande.add(ligneCommande);
            });
        }

        commande.setListLigneCommande(listLigneCommande);
        commande.setTotal();
        commandeService.addCommande(commande);
        return commande;

    }

    @JsonView(View.Commandes.class)
    @GetMapping("commandes")
    @CrossOrigin()

    public List<Commande> getAllCommandes() {

        List<Commande> commandes = commandeService.getAllCommandes();

        commandes.forEach((commande -> {
            List<LigneCommande> listLigneCommande = ligneCommandeService
                    .getLigneCommandesByCommandeId(commande.getId());
            commande.setListLigneCommande(listLigneCommande);
        }));

        return commandes;
    }

    @JsonView(View.Commandes.class)
    @GetMapping("/users/{userId}/commandes")

    @CrossOrigin()

    public List<Commande> getCommandeByUser(@PathVariable int userId) {
        List<Commande> listCommande = commandeService.getCommandesByUserId(userId);
        listCommande.forEach((commande) -> {
            List<LigneCommande> listLigneCommande = ligneCommandeService
                    .getLigneCommandesByCommandeId(commande.getId());
            commande.setListLigneCommande(listLigneCommande);

        });
        return listCommande;
    }

    @JsonView(View.Commandes.class)
    @PutMapping("commandes/{commandeId}")

    @CrossOrigin()
    public Commande updateCommande(@PathVariable int commandeId,
            @RequestParam(value = "state", required = false) String state,
            @RequestParam(value = "idLivreur", required = false) int idLivreur) {
        Commande commande = commandeService.findById(commandeId).get();
        commande.setState(state);
        commande.setIdLivreur(idLivreur);
        commandeService.addCommande(commande);
        List<LigneCommande> listLigneCommande = ligneCommandeService.getLigneCommandesByCommandeId(commande.getId());
        commande.setListLigneCommande(listLigneCommande);
        return commande;
    }

    @DeleteMapping("commandes/{commandeId}")

    @CrossOrigin()

    public void deleteCommande(@PathVariable int commandeId) {
        commandeService.deleteById(commandeId);
    }
}
