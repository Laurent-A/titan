package com.titan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.titan.modele.Entreprise;

@Repository
public interface EntrepriseService {

	@Transactional
	List<Entreprise> listeEntreprises();

	@Transactional
	Entreprise afficherUneEntreprise(Integer id);

	@Transactional
	Entreprise creerUneEntreprise(Entreprise entreprise);

	@Transactional
	Entreprise modifierUneEntreprise(Integer id, Entreprise entrepriseDetails);

	@Transactional
	void suppressionEntreprise(Integer id);

	@Transactional
	List<Entreprise> entrepriseParMetier(Integer id_metier);

}
