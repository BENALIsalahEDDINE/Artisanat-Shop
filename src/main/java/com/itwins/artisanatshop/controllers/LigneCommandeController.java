package com.itwins.artisanatshop.controllers;


import com.itwins.artisanatshop.models.Commande;
import com.itwins.artisanatshop.models.LigneCommande;
import com.itwins.artisanatshop.models.Product;
import com.itwins.artisanatshop.services.LigneCommandeService;
import com.itwins.artisanatshop.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LigneCommandeController {
    @Autowired
    private LigneCommandeService ligneCommandeService;
    @Autowired
    private ProductService productService;

    @CrossOrigin
    @PostMapping("/commandes/{commandeId}/ligneCommande/{productId}")
    public LigneCommande addLigneCommande(@RequestBody LigneCommande ligneCommande, @PathVariable int commandeId, @PathVariable int productId){
        ligneCommande.setCommande(new Commande(commandeId));
        Optional<Product> product = productService.findById(productId);
        if (product.isPresent()){
            ligneCommande.setProduct(product.get());
            return ligneCommandeService.addLigneCommande(ligneCommande);
        }
        return null;



    }


}
