package com.titan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.titan.modele.Contrat;

@Repository
public interface ContratService {

	@Transactional
	List<Contrat> listeContrat();

	@Transactional
	Contrat afficherUnContrat(Integer id);

	@Transactional
	Contrat creerUnContrat(Contrat contrat);

	@Transactional
	Contrat modifierUnContrat(Integer id, Contrat contratDetails);

	@Transactional
	void suppressionContrat(Integer id);

}
