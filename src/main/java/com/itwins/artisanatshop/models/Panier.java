package com.itwins.artisanatshop.models;


import javax.persistence.*;

@Entity
@Table(name="panier")
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; //clé unique auto-générée
    private String nom;
    private int prix;
    private int quantite;

    @Override
    public String toString() {
        return "Panier{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                '}';
    }



    public Panier() {

    }

    public Panier(int id, String nom, int prix, int quantite) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    public int getQuantite() { return quantite; }

    public void setQuantite(int quantite) { this.quantite = quantite; }


}
