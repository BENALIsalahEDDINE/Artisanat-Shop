package com.itwins.artisanatshop.controllers;


import com.itwins.artisanatshop.models.Vendeur;
import com.itwins.artisanatshop.repository.VendeurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class VendeurController {
    @Autowired
    private VendeurRepository vendeurRepository;

    //Recuperer la liste des vendeurs
    @CrossOrigin
    @RequestMapping(value="/Vendeur",method= RequestMethod.GET)
    public List<Vendeur> listeProduits(){
        return vendeurRepository.findAll();
    }
    //Recuperer un vendeur par son Id
    //on peut aussi utiliser   @GetMapping(value = "/Produits/{id}")
    @CrossOrigin
    @RequestMapping(value="/Vendeur/{id}",method=RequestMethod.GET)
    //@GetMapping()
    public Vendeur afficherUnProduit(@PathVariable int id){
        return vendeurRepository.findById(id);

    }
    @CrossOrigin
    @PostMapping(value="/Vendeur")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Vendeur vendeur)
    {
        Vendeur panierAdded =  vendeurRepository.save(vendeur);
        if(panierAdded == null)  return  ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(panierAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @CrossOrigin
    @DeleteMapping (value = "/Vendeur/{id}")
    public void supprimerPrduit(@PathVariable int id) {
        vendeurRepository.delete(vendeurRepository.findById(id));
    }
    @CrossOrigin
    @PutMapping (value = "/Vendeur")
    public void updateProduit(@RequestBody Vendeur vendeur) {
        vendeurRepository.save(vendeur);
    }
}
