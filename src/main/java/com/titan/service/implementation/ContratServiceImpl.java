package com.titan.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.titan.dao.ContratDao;
import com.titan.exception.ApiNotFoundException;
import com.titan.modele.Contrat;
import com.titan.service.ContratService;

@Service
public class ContratServiceImpl implements ContratService{

	@Autowired
	public ContratDao contratDao;
	
	@Override
	public List<Contrat> listeContrat(){
		return this.contratDao.findAll();
	}
	
	@Override
	public Contrat afficherUnContrat(Integer id) {
		return contratDao.findById(id)
	            .orElseThrow(() -> new ApiNotFoundException("contrat", "id", id));
	}
	
	@Override
	public Contrat creerUnContrat(Contrat contrat){
		return contratDao.save(contrat);
	}
	
	@Override 
	public Contrat modifierUnContrat(Integer id, Contrat contratDetails) {
		Contrat contrat = contratDao.findById(id)
	            .orElseThrow(() -> new ApiNotFoundException("contrat", "id", id));

		contrat.setCommentaire(contratDetails.getCommentaire());
		contrat.setDateDebutContrat(contratDetails.getDateDebutContrat());
		contrat.setDuree(contratDetails.getDuree());
		contrat.setEntreprise(contratDetails.getEntreprise());
		contrat.setMensualite(contratDetails.getMensualite());
		contrat.setMetier(contratDetails.getMetier());
		contrat.setPreavis(contratDetails.getPreavis());
		contrat.setTel_entreprise(contratDetails.getTel_entreprise());
		contrat.setUtilisateur(contratDetails.getUtilisateur());
		contrat.setNom(contratDetails.getNom());

		Contrat modifContrat = contratDao.save(contrat);
	    return modifContrat;
	}
	
	@Override
	public void suppressionContrat( Integer id){
		Contrat contrat = contratDao.findById(id)
	            .orElseThrow(() -> new ApiNotFoundException("contrat", "id", id));
		contratDao.delete(contrat);
	}
}
