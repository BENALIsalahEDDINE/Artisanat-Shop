package com.itwins.artisanatshop.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name="commentaire")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int idProd;
    private String comm;
    private int rating;
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @Column(name = "date")
    private Date date;
    @ManyToOne
    private User user;



    public Comment(){
    }

    public Comment(int id, int idProd, String comm, int rating, Date date, User user) {
        this.id = id;
        this.idProd = idProd;
        this.comm = comm;
        this.rating = rating;
        this.date = date;
        this.user=user;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public void setUser(User user) {
        this.user=user;
    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return id;
    }


    public int getIdProd() {
        return idProd;
    }

    public String getComm() {
        return comm;
    }

    public int getRating() {
        return rating;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", idProd=" + idProd +
                ", comm='" + comm + '\'' +
                ", rating=" + rating +
                ", date=" + date +
                '}';
    }


    public Comment(Map<String,Object> commentMap) {
        super();
        if (commentMap.get("id") != null)

            this.id = Integer.parseInt((String )commentMap.get("id"));
        this.idProd = Integer.parseInt((String )commentMap.get("idProd"));
        this.comm = (String) commentMap.get("comm");
        this.rating = Integer.parseInt((String )commentMap.get("rating"));
        this.date = (Date) commentMap.get("date");
        this.user = (User) commentMap.get("user");

    }


}
