package com.titan.service.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.titan.dao.EntrepriseDao;
import com.titan.exception.EntrepriseException;
import com.titan.modele.Entreprise;
import com.titan.service.EntrepriseService;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	public EntrepriseDao entrepriseDao;
	
	@Override
	public List<Entreprise> listeEntreprises(){
		return this.entrepriseDao.findAll();
	}
	
	@Override
	public Entreprise afficherUneEntreprise(Integer id) {
		return entrepriseDao.findById(id)
	            .orElseThrow(() -> new EntrepriseException("enterprise", "id", id));
	}
	
	@Override
	public Entreprise creerUneEntreprise(Entreprise entreprise){
		return entrepriseDao.save(entreprise);
	}
	
	@Override 
	public Entreprise modifierUneEntreprise(Integer id, Entreprise entrepriseDetails) {
		Entreprise entreprise = entrepriseDao.findById(id)
	            .orElseThrow(() -> new EntrepriseException("enterprise", "id", id));

		entreprise.setNom(entrepriseDetails.getNom());
		entreprise.setMetier(entrepriseDetails.getMetier());

		Entreprise modifEntreprise = entrepriseDao.save(entreprise);
	    return modifEntreprise;
	}
	
	@Override
	public ResponseEntity<?> suppressionEntreprise( Integer id){
		Entreprise entreprise = entrepriseDao.findById(id)
	            .orElseThrow(() -> new EntrepriseException("Note", "id", id));
		entrepriseDao.delete(entreprise);

	    return ResponseEntity.ok().build();
	}
	
	// entreprise par domaine de metier
	@Override
	public List<Entreprise> entrepriseParMetier(Integer id_metier) {
		return em.createQuery("select e from Entreprise e where e.metier.id=:e_id",Entreprise.class)
				.setParameter("e_id",id_metier).getResultList();
	}

}
