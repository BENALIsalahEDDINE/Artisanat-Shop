package com.itwins.artisanatshop.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Entity

public class Category implements Serializable {

    @Id @GeneratedValue
    private int id;
    private String nom;
    @Column(length = 1000)
    private String url;

    @Column(length = 1000)
    private String description;

    public Category(){
    }

    public Category(int id, String nom, String url, String description) {
        this.id = id;
        this.nom = nom;
        this.url = url;
        this.description = description;
    }
    public Category(Map<String,Object> categoryMap) {
        super();
        if (categoryMap.get("id") != null)
            this.id = Integer.parseInt((String) categoryMap.get("id"));
        this.nom = (String) categoryMap.get("nom");
        this.url = (String) categoryMap.get("url");
        this.description = (String) categoryMap.get("description");

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", nom='" + nom +"'" +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
