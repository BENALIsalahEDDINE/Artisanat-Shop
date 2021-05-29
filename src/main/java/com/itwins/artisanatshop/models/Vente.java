package com.itwins.artisanatshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
 
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ventes")
public class Vente {
	@Id @GeneratedValue 
	private int idVente;
	private int idProduct;
	private int idCat;
	private int qte;
	private int day;
	private int mois;
	private int annee;
	
	
	 public Vente() {
	        super();
	    }
	
	public Vente(int idVente, int idProduct, int idCat, int qte, int day,int mois, int annee) {
		super();
		this.idVente = idVente;
		this.idProduct = idProduct;
		this.idCat = idCat;
		this.qte = qte;
		this.day=day;
		this.mois = mois;
		this.annee = annee;
	}
	public int getIdVente() {
		return idVente;
	}
	public void setIdVente(int idVente) {
		this.idVente = idVente;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public int getIdCat() {
		return idCat;
	}
	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMois() {
		return mois;
	}
	public void setMois(int mois) {
		this.mois = mois;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	@Override
	public String toString() {
		return "Ventes [idVente=" + idVente + ", idProduct=" + idProduct + ", idCat=" + idCat + ", qte=" + qte
				+ ", mois=" + mois + ", annee=" + annee + "]";
	}
	

}
