package com.titan.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.titan.modele.Metier;

public interface MetierService {

	public List<Metier>listeMetiers();

	Metier afficherUnMetier(Integer id);

	Metier creerUnMetier(Metier metier);

	Metier modifierMetier(Integer id, Metier metierDetail);

	ResponseEntity<?> suppressionMetier(Integer id);
	
	
}
