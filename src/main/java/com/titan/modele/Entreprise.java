package com.titan.modele;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "entreprise")
public class Entreprise {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nom;
	
    @ManyToOne  
    @JoinColumn( name="id_metier" )
	private Metier metier;
    
    

	public Entreprise() {
		super();
	}

	public Entreprise(Long id, String nom, Metier metier) {
		super();
		this.id = id;
		this.nom = nom;
		this.metier = metier;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Metier getMetier() {
		return metier;
	}

	public void setMetier(Metier metier) {
		this.metier = metier;
	}

	@Override
	public String toString() {
		return "Entreprise [id=" + id + ", nom=" + nom + ", metier=" + metier + "]";
	}
    
    
}
