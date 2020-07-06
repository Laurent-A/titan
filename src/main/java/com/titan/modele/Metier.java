package com.titan.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "metier")
public class Metier {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String libelle;
	
	
	public Metier() {
		super();
	}


	public Metier(Long id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	@Override
	public String toString() {
		return "Metier [id=" + id + ", libelle=" + libelle + "]";
	}
	
	
	
	
}
