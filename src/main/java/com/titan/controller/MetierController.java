package com.titan.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

import com.titan.modele.Metier;
import com.titan.service.MetierService;

@RestController
@RequestMapping("/titan")
public class MetierController {
	
	@Autowired
	private MetierService metierService;

	@GetMapping(value="/metier", produces= {"application/json"})
	public List<Metier> listeMetier(){
		return this.metierService.listeMetiers();
	}
	
	@GetMapping(value="/metier/{id}")
	public Metier afficherUnMetier(@PathVariable(value = "id") Integer id) {
		return metierService.afficherUnMetier(id);
	}
	
	@PostMapping("/metier")
	public Metier creerUnMetier(@RequestBody Metier metier) {
	    return metierService.creerUnMetier(metier);
	}
	
	@PutMapping("/metier/{id}")
	public Metier modifierMetier(@PathVariable(value = "id") Integer id, @RequestBody Metier metierDetails) {
	    return metierService.modifierMetier(id, metierDetails);
	}
	
	@DeleteMapping("/metier/{id}")
	public ResponseEntity<?> suppressionMetier(@PathVariable(value = "id") Integer id) {
		metierService.suppressionMetier(id);
		return ResponseEntity.ok().build();
	}

}
