package com.itwins.artisanatshop.controllers;

import com.itwins.artisanatshop.models.Facture;
import com.itwins.artisanatshop.services.FactureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class FactureController {

    @Autowired
    private FactureService FactureService;


    @GetMapping("/Facture")
    public List<Facture> index() {

        return FactureService.findAll();

    }
    @GetMapping("/Facture/{id}")
    public Optional<Facture> FactureById(@PathVariable String id) {
        int FactureId = Integer.parseInt(id);
        return FactureService.findById(FactureId);
    }
    @PostMapping("/Facture")
    public Facture create(@RequestBody Map<String, Object> FactureMap) {
        Facture Facture = new Facture(FactureMap);
        return FactureService.saveFacture(Facture);

    }
    @PutMapping("/Facture/{id}")
    public Facture update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int FactureId = Integer.parseInt(id);
        Optional<Facture> Facture = FactureService.findById(FactureId);
        if (Facture.isPresent()) {
            com.itwins.artisanatshop.models.Facture f = Facture.get();
            f.setDate(body.get("date"));

            /*f.setProduit(body.get("produit"));
            f.setPrix(Integer.parseInt(body.get("prix")));
            f.setQte(Integer.parseInt(body.get("qte")));*/
            f.setTotal(Integer.parseInt(body.get("total")));

            return FactureService.saveFacture(f);
        }
        return null;

    }
    @DeleteMapping("/Facture/{id}")
    public boolean delete(@PathVariable String id) {
        int FactureId = Integer.parseInt(id);
        return FactureService.deleteById(FactureId);
    }
}
