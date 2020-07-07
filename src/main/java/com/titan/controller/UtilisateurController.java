package com.titan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.titan.modele.Utilisateur;
import com.titan.service.UtilisateurService;

@RestController
@RequestMapping("/titan")
public class UtilisateurController {

	
	@Autowired
	private UtilisateurService utilisateurService;

	@GetMapping(value="/utilisateur", produces= {"application/json"})
	public List<Utilisateur> listeUtilisateur(){
		return this.utilisateurService.listeUtilisateur();
	}
	
	@GetMapping(value="/utilisateur/{id}")
	public Utilisateur afficherUnUtilisateur(@PathVariable(value = "id") Integer id) {
		return utilisateurService.afficherUnUtilisateur(id);
	}
	
	@PostMapping("/utilisateur/ajouter")
	public Utilisateur creerUnUtilisateur(@RequestBody Utilisateur utilisateur) {
	    return utilisateurService.creerUnUtilisateur(utilisateur);
	}
	
	@PutMapping("/utilisateur/modifier/{id}")
	public Utilisateur modifierUtilisateur(@PathVariable(value = "id") Integer id, @RequestBody Utilisateur utilisateurDetails) {
	    return utilisateurService.modifierUnUtilisateur(id, utilisateurDetails);
	}
	
	@DeleteMapping("/utilisateur/supprimer/{id}")
	public ResponseEntity<?> suppressionUtilisateur(@PathVariable(value = "id") Integer id) {
		return utilisateurService.suppressionUtilisateur(id);
	}
}
