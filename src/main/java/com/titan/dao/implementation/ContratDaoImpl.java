package com.titan.dao.implementation;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import com.titan.modele.Entreprise;
import com.titan.modele.Metier;
import com.titan.modele.Utilisateur;

import lombok.Data;

@Entity
@Table(name = "contrat")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
	allowGetters = true)
public class ContratDaoImpl implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nom;
	@NotNull
	private Float mensualite;
	@NotNull
	private Date dateDebutContrat;
	@NotNull
	private Long duree;
	private String preavis;
	private String commentaire;
	private Long tel_entreprise;
	
    @ManyToOne  
    @JoinColumn( name="id_entreprise" )
	private Entreprise entreprise;
	
    @OneToOne  
    @JoinColumn( name="id_utilisateur" )
	private Utilisateur utilisateur;
	
    @ManyToOne  
    @JoinColumn( name="id_metier" )
	private Metier metier;

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

	public Float getMensualite() {
		return mensualite;
	}

	public void setMensualite(Float mensualite) {
		this.mensualite = mensualite;
	}

	public Date getDateDebutContrat() {
		return dateDebutContrat;
	}

	public void setDateDebutContrat(Date dateDebutContrat) {
		this.dateDebutContrat = dateDebutContrat;
	}

	public Long getDuree() {
		return duree;
	}

	public void setDuree(Long duree) {
		this.duree = duree;
	}

	public String getPreavis() {
		return preavis;
	}

	public void setPreavis(String preavis) {
		this.preavis = preavis;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Long getTel_entreprise() {
		return tel_entreprise;
	}

	public void setTel_entreprise(Long tel_entreprise) {
		this.tel_entreprise = tel_entreprise;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Metier getMetier() {
		return metier;
	}

	public void setMetier(Metier metier) {
		this.metier = metier;
	}
    
    

}
