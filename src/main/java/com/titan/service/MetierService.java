package com.titan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;

import com.titan.modele.Metier;

public interface MetierService {

	@Transactional
	public List<Metier>listeMetiers();

	@Transactional
	Metier afficherUnMetier(Integer id);

	@Transactional
	Metier creerUnMetier(Metier metier);

	@Transactional
	Metier modifierMetier(Integer id, Metier metierDetail);

	@Transactional
	void suppressionMetier(Integer id);
	
	
}
