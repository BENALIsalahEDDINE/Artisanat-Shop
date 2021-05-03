package com.itwins.artisanatshop.models;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "commandes")

public class Commande {

    @Id
    @GeneratedValue
    @JsonView(View.Commandes.class)
    private int id;
    @JsonView(View.Commandes.class)
    private String date;
    @JsonView(View.Commandes.class)
    private double total;
    @JsonView(View.Commandes.class)
    private String paymentMethod;
    @JsonView(View.Commandes.class)

    private String state;
    @JsonView(View.Commandes.class)

    private int idLivreur;
    @JsonView(View.Commandes.class)

    @ManyToOne
    private User user;
    @JsonView(View.Commandes.class)
    @OneToMany
    private List<LigneCommande> listLigneCommande;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<LigneCommande> getListLigneCommande() {
        return listLigneCommande;
    }

    public void setListLigneCommande(List<LigneCommande> listLigneCommande) {
        this.listLigneCommande = listLigneCommande;
    }

    public Commande() {
    }

    public Commande(Map<String, Object> map) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime today = LocalDateTime.now();
        this.date = formatter.format(today);
        this.paymentMethod = (String) map.get("paymentMethod");
        this.state = "En attente";
    }

    public Commande(int id) {
        this.id = id;
    }

    public Commande(int id, String date, int userId, int idLivreur) {
        this.id = id;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.state = state;
        this.idLivreur = idLivreur;
        this.user = new User(userId, "", "", "", "", "", "", "", "");
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

    public int getIdLivreur() {
        return idLivreur;
    }

    public void setIdLivreur(int idLivreur) {
        this.idLivreur = idLivreur;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal() {
        listLigneCommande.forEach((ligneCommande -> {
            this.total += ligneCommande.getTotal();
        }));
    }
}
