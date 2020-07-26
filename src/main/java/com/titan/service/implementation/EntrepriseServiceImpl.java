package com.titan.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.titan.dao.EntrepriseDao;
import com.titan.exception.ApiNotFoundException;
import com.titan.modele.Entreprise;
import com.titan.service.EntrepriseService;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {
	
	
	@Autowired
	public EntrepriseDao entrepriseDao;
	
	@Override
	public List<Entreprise> listeEntreprises(){
		return this.entrepriseDao.findAll();
	}
	
	@Override
	public Entreprise afficherUneEntreprise(Integer id) {
		return entrepriseDao.findById(id)
	            .orElseThrow(() -> new ApiNotFoundException("enterprise", "id", id));
	}
	
	@Override
	public Entreprise creerUneEntreprise(Entreprise entreprise){
		return entrepriseDao.save(entreprise);
	}
	
	@Override 
	public Entreprise modifierUneEntreprise(Integer id, Entreprise entrepriseDetails) {
		Entreprise entreprise = entrepriseDao.findById(id)
	            .orElseThrow(() -> new ApiNotFoundException("enterprise", "id", id));

		entreprise.setNom(entrepriseDetails.getNom());

		Entreprise modifEntreprise = entrepriseDao.save(entreprise);
	    return modifEntreprise;
	}
	
	@Override
	public void suppressionEntreprise( Integer id){
		Entreprise entreprise = entrepriseDao.findById(id)
	            .orElseThrow(() -> new ApiNotFoundException("enterprise", "id", id));
		entrepriseDao.delete(entreprise);

	}
	
	// entreprise par domaine de metier
	@Override
	public List<Entreprise> entrepriseParMetier(Integer id_metier) {
		return this.entrepriseDao.entrepriseParMetier(id_metier);
	}

}
