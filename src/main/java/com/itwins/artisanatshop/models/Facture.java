package com.itwins.artisanatshop.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;

@Entity
@Table(name="facture")
public class Facture {

    @Id
    private int id;
    private String date;

    //private String produit;
    //private int prix;
    //private int qte;
    private int total;

    public Facture() {
        super();
    }
    public Facture(Map<String,Object> FactureMap) {
        super();
        if (FactureMap.get("id") != null)

            this.id = (int )FactureMap.get("id");
        this.date = (String) FactureMap.get("date");
        //this.produit = (String) FactureMap.get("produit");
        //this.prix = (int) FactureMap.get("prix");
        //this.qte = (int)FactureMap.get("qte");
        this.total = (int) FactureMap.get("total");


    }
    public Facture(String date, String produit, int prix, int qte, int total) {
        super();
        this.date = date;
       /* this.produit = produit;
        this.prix=prix;
        this.qte = qte;*/
        this.total = total;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
   /* public String getProduit() {
        return produit;
    }
    public void setProduit(String produit) {
        this.produit = produit;
    }
    public int getPrix() {
        return prix;
    }
    public void setPrix(int prix) {
        this.prix = prix;
    }
    public int getQte() {
        return qte;
    }
    public void setQte(int qte) {
        this.qte = qte;
    }*/
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", date='" + date + '\'' +
                /*", produit='" + produit + '\'' +
                ", prix=" + prix +
                ", qte=" + qte +*/
                ", total=" + total +
                '}';
    }

}

