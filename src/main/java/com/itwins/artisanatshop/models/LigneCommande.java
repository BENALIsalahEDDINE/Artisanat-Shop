package com.itwins.artisanatshop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.util.Map;


@Entity
public class LigneCommande {
    @Id@GeneratedValue
    @JsonIgnore
    private int id;
    @JsonView(View.Commandes.class)
    @OneToOne
    private Product product;
    @JsonView(View.Commandes.class)
    private int qte;
    @JsonIgnore
    @ManyToOne
    private Commande commande;
    @JsonView(View.Commandes.class)
    private double total;

    public LigneCommande() {

    }

    public LigneCommande(Map<String, Object> map) {

        this.qte = (int) map.get("qte");
    }

    public LigneCommande(int id, int qte) {
        this.id = id;
        this.qte = qte;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal() {

        this.total = product.getPrix() * qte;
    }
}
