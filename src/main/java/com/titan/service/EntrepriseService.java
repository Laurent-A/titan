package com.titan.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.titan.modele.Entreprise;

@Repository
public interface EntrepriseService {

	List<Entreprise> listeEntreprises();

	Entreprise afficherUneEntreprise(Integer id);

	Entreprise creerUneEntreprise(Entreprise entreprise);

	Entreprise modifierUneEntreprise(Integer id, Entreprise entrepriseDetails);

	ResponseEntity<?> suppressionEntreprise(Integer id);

	List<Entreprise> entrepriseParMetier(Integer id_metier);

}
