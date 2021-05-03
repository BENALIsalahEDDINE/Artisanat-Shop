package com.itwins.artisanatshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;

@Entity
@Table(name="article")
public class Article {
    @Id @GeneratedValue
    private int id;
    private String editeur;
    private String datecreation;
    private String categorie;
    private String  titre;
    private String text;
    private String imageurl;


    public Article() {
        super();
    }


    public Article(Map<String,Object> ArticleMap) {
        super();
        if (ArticleMap.get("id") != null)

            this.id = (int) ArticleMap.get("id");
        this.editeur = (String) ArticleMap.get("editeur");
        this.datecreation = (String) ArticleMap.get("datecreation");
        this.categorie = (String) ArticleMap.get("categorie");
        this.titre = (String) ArticleMap.get("titre");
        this.text= (String) ArticleMap.get("text");
        this.imageurl=(String) ArticleMap.get("imageurl");
    }
    public Article(String editeur, String dateCreation, String categorie, String titre, String text, String imageurl) {
        super();
        this.editeur=editeur;
        this.datecreation=datecreation;
        this.categorie=categorie;
        this.titre=titre;
        this.text= text;
        this.imageurl= imageurl;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id=id;
    }
    public String getEditeur() {
        return editeur;
    }
    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }
    public String getDateCreation() {
        return datecreation;
    }
    public void setDateCreation( String datecreation) {
        this.datecreation = datecreation;
    }
    public void setCategorie(String categorie) {
        this.categorie=categorie;
    }
    public String getCategorie() {
        return categorie;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre=titre;
    }
    public String getText(){
        return text;
    }
    public void setText( String text){
        this.text=text;
    }
    public String getImageurl(){
        return imageurl;
    }
    public void setImageurl( String imageurl){
        this.imageurl=imageurl;
    }
}
