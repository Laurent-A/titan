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

import com.titan.modele.Contrat;
import com.titan.service.ContratService;

@RestController
@RequestMapping("/titan")
public class ContratController {
	
	@Autowired
	private ContratService contratService;
	
	@GetMapping(value="/contrat", produces= {"application/json"})
	public List<Contrat> listeContrat(){
		return this.contratService.listeContrat();
	}
	
	@GetMapping(value="/contrat/{id}")
	public Contrat afficherUnContrat(@PathVariable(value = "id") Integer id) {
		return contratService.afficherUnContrat(id);
	}
	
	@PostMapping("/contrat")
	public Contrat creerUnContrat(@RequestBody Contrat contrat) {
	    return contratService.creerUnContrat(contrat);
	}
	
	@PutMapping("/contrat/{id}")
	public Contrat modifierContrat(@PathVariable(value = "id") Integer id, @RequestBody Contrat contratDetails) {
	    return contratService.modifierUnContrat(id, contratDetails);
	}
	
	@DeleteMapping("/contrat/{id}")
	public ResponseEntity<?> suppressionContrat(@PathVariable(value = "id") Integer id) {
		contratService.suppressionContrat(id);
		return ResponseEntity.ok().build();
	}

}
