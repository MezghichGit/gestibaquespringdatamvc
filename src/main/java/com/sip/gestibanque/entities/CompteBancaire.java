package com.sip.gestibanque.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CompteBancaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String proprietaire;
	private LocalDate dateCreation;
	private double solde;
	private String typeCompte;
	private int idBanque;
	
	public CompteBancaire() {
	
	}

	public CompteBancaire(String proprietaire, LocalDate dateCreation, double solde, String typeCompte, int idBanque) {
		this.proprietaire = proprietaire;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.typeCompte = typeCompte;
		this.idBanque = idBanque;
	}

	@Override
	public String toString() {
		return "CompteBancaire [id=" + id + ", proprietaire=" + proprietaire + ", dateCreation=" + dateCreation
				+ ", solde=" + solde + ", typeCompte=" + typeCompte + ", idBanque=" + idBanque + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}

	public int getIdBanque() {
		return idBanque;
	}

	public void setIdBanque(int idBanque) {
		this.idBanque = idBanque;
	}
	
}
