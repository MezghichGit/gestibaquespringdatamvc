package com.sip.gestibanque.entities;

import java.time.LocalDate;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CompteBancaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String proprietaire;
	private LocalDate dateCreation;
	private double solde;
	private TypeCompte typeCompte;
	
	/**** Many To One ****/
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "banque_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private Banque banque;
	
	public Banque getBanque() {
		return banque;
	}


	public void setBanque(Banque banque) {
		this.banque = banque;
	}


	public CompteBancaire(int id, String proprietaire, LocalDate dateCreation, double solde, TypeCompte typeCompte,
			Banque banque) {
		super();
		this.id = id;
		this.proprietaire = proprietaire;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.typeCompte = typeCompte;
		this.banque = banque;
	}


	public CompteBancaire() {
	
	}



	@Override
	public String toString() {
		return "CompteBancaire [id=" + id + ", proprietaire=" + proprietaire + ", dateCreation=" + dateCreation
				+ ", solde=" + solde + ", typeCompte=" + typeCompte + ", banque=" + banque + "]";
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

	public TypeCompte getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(TypeCompte typeCompte) {
		this.typeCompte = typeCompte;
	}

	
}
