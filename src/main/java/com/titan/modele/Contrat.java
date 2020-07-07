package com.titan.modele;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "contrat")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
	allowGetters = true)
public class Contrat implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
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

    
	public Contrat() {
		super();
	}

	public Contrat(Integer id, String nom, Float mensualite, Date dateDebutContrat, Long duree, String preavis,
			String commentaire, Long tel_entreprise, Entreprise entreprise, Utilisateur utilisateur, Metier metier) {
		super();
		this.id = id;
		this.nom = nom;
		this.mensualite = mensualite;
		this.dateDebutContrat = dateDebutContrat;
		this.duree = duree;
		this.preavis = preavis;
		this.commentaire = commentaire;
		this.tel_entreprise = tel_entreprise;
		this.entreprise = entreprise;
		this.utilisateur = utilisateur;
		this.metier = metier;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	@Override
	public String toString() {
		return "Contrat [id=" + id + ", nom=" + nom + ", mensualite=" + mensualite + ", dateDebutContrat="
				+ dateDebutContrat + ", duree=" + duree + ", preavis=" + preavis + ", commentaire=" + commentaire
				+ ", tel_entreprise=" + tel_entreprise + ", entreprise=" + entreprise + ", utilisateur=" + utilisateur
				+ ", metier=" + metier + "]";
	}
    
	
    
	
}
