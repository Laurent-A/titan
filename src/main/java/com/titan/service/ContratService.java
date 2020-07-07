package com.titan.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.titan.modele.Contrat;

@Repository
public interface ContratService {

	List<Contrat> listeContrat();

	Contrat afficherUnContrat(Integer id);

	Contrat creerUnContrat(Contrat contrat);

	Contrat modifierUnContrat(Integer id, Contrat contratDetails);

	ResponseEntity<?> suppressionContrat(Integer id);

}
