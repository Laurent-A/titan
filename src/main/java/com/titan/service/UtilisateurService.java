package com.titan.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.titan.modele.Utilisateur;

@Repository
public interface UtilisateurService {

	List<Utilisateur> listeUtilisateur();

	Utilisateur afficherUnUtilisateur(Integer id);

	Utilisateur creerUnUtilisateur(Utilisateur utilisateur);

	Utilisateur modifierUnUtilisateur(Integer id, Utilisateur utilisateurDetails);

	ResponseEntity<?> suppressionUtilisateur(Integer id);

}
