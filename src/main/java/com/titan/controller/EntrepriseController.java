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

import com.titan.modele.Entreprise;
import com.titan.modele.Metier;
import com.titan.service.EntrepriseService;

@RestController
@RequestMapping("/titan")
public class EntrepriseController {

	@Autowired
	private EntrepriseService entrepriseService;
	
	@GetMapping(value="/entreprise")
	public List<Entreprise> listeEntreprises(){
		return this.entrepriseService.listeEntreprises();
	}
	
	@GetMapping(value="/entreprise/{id}")
	public Entreprise afficherUneEntreprise(@PathVariable(value = "id") Integer id) {
		return entrepriseService.afficherUneEntreprise(id);
	}
	
	@PostMapping("/entreprise")
	public Entreprise creerUneEntreprise(@RequestBody Entreprise entreprise) {
	    return entrepriseService.creerUneEntreprise(entreprise);
	}
	
	@PutMapping("/entreprise/{id}")
	public Entreprise modifierEntreprise(@PathVariable(value = "id") Integer id, @RequestBody Entreprise entrepriseDetails) {
	    return entrepriseService.modifierUneEntreprise(id, entrepriseDetails);
	}
	
	@DeleteMapping("/entreprise/{id}")
	public ResponseEntity<?> suppressionEntreprise(@PathVariable(value = "id") Integer id) {
		entrepriseService.suppressionEntreprise(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value="/entreprise/metier/{id}")
	public List<Entreprise> entrepriseMetier(@PathVariable(value = "id") Integer id_metier){
		return this.entrepriseService.entrepriseParMetier(id_metier);
	}
}
