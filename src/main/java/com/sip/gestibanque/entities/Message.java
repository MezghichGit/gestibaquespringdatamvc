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
public class Message {
	@Id // clé primaire et unique
	@GeneratedValue(strategy = GenerationType.AUTO) // Hibernate qui va générer l'id automatiquement avant l'insertion
	private int id;
	
	
	private String sujet;
	private String description;
	private LocalDate dateCreation; 
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/*
	public Message(int id, String sujet, String description, LocalDate dateCreation, String email) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.description = description;
		this.dateCreation = dateCreation;
		this.email = email;
	}*/
	
	public Message(String sujet, String description, LocalDate dateCreation, String email) {
	
		this.sujet = sujet;
		this.description = description;
		this.dateCreation = dateCreation;
		this.email = email;
	}
	
	public Message() {
	
	}


	/**** Many To One ****/
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", sujet=" + sujet + ", description=" + description + ", dateCreation="
				+ dateCreation + ", email=" + email + ", user=" + user + "]";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}
