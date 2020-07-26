package com.titan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.titan.modele.Utilisateur;

@Repository
public interface UtilisateurService {

	@Transactional
	List<Utilisateur> listeUtilisateur();

	@Transactional
	Utilisateur afficherUnUtilisateur(Integer id);

	@Transactional
	Utilisateur creerUnUtilisateur(Utilisateur utilisateur);

	@Transactional
	Utilisateur modifierUnUtilisateur(Integer id, Utilisateur utilisateurDetails);

	@Transactional
	void suppressionUtilisateur(Integer id);

}
