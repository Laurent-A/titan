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

@Data
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

}
