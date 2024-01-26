package com.sip.gestibanque.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id;
	private String nom;
	private String prenom;
	private int age;
	private String email;
	private String adresse;
	private String telephone;
	
	public User() {
		super();
	}


	public User(int id, String nom, String prenom, int age, String email, String adresse, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = email;
		this.adresse = adresse;
		this.telephone = telephone;
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", email=" + email
				+ ", adress=" + adresse + ", telephone=" + telephone + "]";
	}
	
	
	
	

}
