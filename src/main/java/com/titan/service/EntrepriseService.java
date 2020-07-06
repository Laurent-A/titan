package com.titan.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.titan.modele.Entreprise;

@Repository
public interface EntrepriseService {

	List<Entreprise> listeEntreprises();

}
