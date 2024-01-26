package com.sip.gestibanque.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // on veut que hibernate nous crée une table
public class Banque {
	
	@Id  // clé primaire
	@GeneratedValue(strategy = GenerationType.AUTO)  // la clé primaire est auto-increment
	private int id;
	
	private String nom;
	
	private String adresse;
	
	private double capital;
	
	public Banque(int id, String nom, String adresse, double capital) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.capital = capital;
	}
	
	public Banque(String nom, String adresse, double capital) {
		this.nom = nom;
		this.adresse = adresse;
		this.capital = capital;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	@Override
	public String toString() {
		return "Banque [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", capital=" + capital + "]";
	}

	public Banque()
	{}

}
