package com.sip.gestibanque.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String libelle;

	@Override
	public String toString() {
		return "Role [id=" + id + ", libelle=" + libelle + "]";
	}

	public Role(String libelle) {
		super();
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Role(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
	public Role() {
	
	}
	

}
