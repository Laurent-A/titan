package com.titan.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.titan.dao.UtilisateurDao;
import com.titan.exception.ApiNotFoundException;
import com.titan.modele.Utilisateur;
import com.titan.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	public UtilisateurDao utilisateurDao;
	
	@Override
	public List<Utilisateur> listeUtilisateur(){
		return this.utilisateurDao.findAll();
	}
	
	@Override
	public Utilisateur afficherUnUtilisateur(Integer id) {
		return utilisateurDao.findById(id)
	            .orElseThrow(() -> new ApiNotFoundException("utilisateur", "id", id));
	}
	
	@Override
	public Utilisateur creerUnUtilisateur(Utilisateur utilisateur){
		return utilisateurDao.save(utilisateur);
	}
	
	@Override 
	public Utilisateur modifierUnUtilisateur(Integer id, Utilisateur utilisateurDetails) {
		Utilisateur utilisateur = utilisateurDao.findById(id)
	            .orElseThrow(() -> new ApiNotFoundException("utilisateur", "id", id));

		utilisateur.setPrenom(utilisateurDetails.getPrenom());
		utilisateur.setPseudo(utilisateurDetails.getPseudo());
		utilisateur.setMail(utilisateurDetails.getMail());
		utilisateur.setTel(utilisateurDetails.getTel());

		Utilisateur modifUtilisateur = utilisateurDao.save(utilisateur);
	    return modifUtilisateur;
	}
	
	@Override
	public ResponseEntity<?> suppressionUtilisateur( Integer id){
		Utilisateur utilisateur = utilisateurDao.findById(id)
	            .orElseThrow(() -> new ApiNotFoundException("utilisateur", "id", id));
		utilisateurDao.delete(utilisateur);

	    return ResponseEntity.ok().build();
	}
	
}
