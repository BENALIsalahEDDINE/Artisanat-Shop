package com.itwins.artisanatshop.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.itwins.artisanatshop.models.Product;
import com.itwins.artisanatshop.services.ProductService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    // ! @route GET /product
    // ! @desc shows all products in mysql database
    // ! @access public
    @CrossOrigin()
    @GetMapping("/product")
    public List<Product> index() {
        return productService.findAll();
    }

    // ! @route GET /product/id
    // ! @desc finds and shows product with parameter id
    // ! @access public
    @CrossOrigin()
    @GetMapping("/product/{id}")
    public Optional<Product> show(@PathVariable String id) {
        int productId = Integer.parseInt(id);
        return productService.findById(productId);
    }

    // ! @route POST /product/search
    // ! @desc uses body parameter : "text" and finds a product with
    // name or description that contains the text input
    // ! @access public
    @CrossOrigin()
    @PostMapping("/product/search")
    public List<Product> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return productService.findByNomContainingOrDescriptionContaining(searchTerm, searchTerm);
    }

    // ! @route POST /product
    // ! @desc adds product in database. Body parameters needed :
    // id, nom, description, source, etat, prix, qte
    // exemple :
    // {
    // "id":"5",
    // "nom":"produit1",
    // "description":"description produit1",
    // "source":"source1",
    // "etat":"vente",
    // "prix":"100.00",
    // "qte":"34"
    // }
    // ! @access public (for now- it should be accessible by admins only)
    @CrossOrigin()
    @PostMapping("/product")
    public String create(@RequestBody Map<String, String> body) {
        // int id = Integer.parseInt(body.get("id"));
        int idCat = Integer.parseInt(body.get("idCat"));
        String nom = body.get("nom");
        String description = body.get("description");
        String unit = body.get("unit");
        String source = body.get("source");
        String etat = body.get("etat");
        double prix = Double.parseDouble(body.get("prix"));
        int qte = Integer.parseInt(body.get("qte"));
        String url = body.get("url");

        productService.saveProduct(new Product(idCat, nom, description, unit, source, etat, prix, qte, url));

        return ("Produit ajouté.");
    }

    // ! @route PUT /product/id
    // ! @desc modifies product in database. Body parameters needed :
    // id, nom,description, source, etat, prix, qte
    // ! @access public (for now- it should be accessible by admins only)

    @CrossOrigin()
    @PutMapping("/product/{id}")
    public Product update(@PathVariable String id, @RequestBody Map<String, String> body) {
        int productId = Integer.parseInt(id);
        Optional<Product> product = productService.findById(productId);
        if (product.isPresent()) {
            Product p = product.get();
            p.setUnit(body.get("unit"));
            p.setDescription(body.get("description"));
            p.setSource(body.get("source"));
            p.setEtat(body.get("etat"));
            p.setPrix(Double.parseDouble(body.get("prix")));
            if (body.get("nbVentes") != null) {
                p.setNbVentes(Integer.parseInt(body.get("nbVentes")));

            }
            p.setUrl(body.get("url"));

            return productService.saveProduct(p);
        }
        return null;
    }

    // ! @route DELETE /product/id
    // ! @desc deletes product with param id
    // ! @access public (for now- it should be private for admins)
    @CrossOrigin()
    @DeleteMapping("product/{id}")
    public boolean delete(@PathVariable String id) {
        int productId = Integer.parseInt(id);
        try {
            productService.deleteById(productId);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
