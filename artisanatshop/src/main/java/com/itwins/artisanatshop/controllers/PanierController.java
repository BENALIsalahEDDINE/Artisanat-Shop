package com.itwins.artisanatshop.controllers;

import com.itwins.artisanatshop.models.Panier;
import com.itwins.artisanatshop.repository.PanierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/*Vous connaissez sans doute l'annotation @Controller de Spring qui permet de désigner
une classe comme contrôleur, lui conférant la capacité de traiter les requêtes de type
 GET, POST, etc. Vous ajoutez ensuite
 @ResponseBody aux méthodes qui devront répondre directement sans passer par une vue.

@RestController est simplement la combinaison des deux annotations précédentes.
Une fois ajouté, il indique que cette classe va pouvoir traiter les requêtes que nous
allons définir. Il indique aussi que chaque méthode va renvoyer directement
la réponse JSON à l'utilisateur, donc pas de vue dans le circuit.*/

@RestController
public class PanierController {
    /*
     *Tout d'abord, nous avons créé une variable de type ProductDao,
     * que nous avons annotée avec @Autowired afin que Spring se charge
     * d'en fabriquer une instance. ProductDao a désormais accès à toutes
     * les méthodes que nous avons définies.
     */
    @Autowired
    private PanierRepository PanierRepository;

    //Recuperer la liste des produits
    @RequestMapping(value="/Panier",method=RequestMethod.GET)
    public  List<Panier> listeProduits(){
        return PanierRepository.findAll();
    }
    //Recuperer un produit par son Id
    //on peut aussi utiliser   @GetMapping(value = "/Produits/{id}")
    @RequestMapping(value="/Panier/{id}",method=RequestMethod.GET)
    //@GetMapping()
    public Panier afficherUnProduit(@PathVariable int id){
        return PanierRepository.findById(id);

    }
    @PostMapping(value="/Panier")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Panier panier)
    {
        Panier panierAdded =  PanierRepository.save(panier);
        if(panierAdded == null)  return  ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(panierAdded.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @GetMapping(value = "test/Panier/{prixLimit}")
    public List<Panier> testeDeRequetes(@PathVariable int prixLimit) {
        return PanierRepository.findByPrixGreaterThan(prixLimit);
    }
    @DeleteMapping (value = "/Panier/{id}")
    public void supprimerPrduit(@PathVariable int id) {

        PanierRepository.delete(PanierRepository.findById(id));
    }
    @PutMapping (value = "/Panier")
    public void updateProduit(@RequestBody Panier panier) {

        PanierRepository.save(panier);
    }
}