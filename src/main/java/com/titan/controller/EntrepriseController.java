package com.titan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.titan.modele.Entreprise;
import com.titan.service.EntrepriseService;

@RestController
@RequestMapping("/titan")
public class EntrepriseController {

	@Autowired
	private EntrepriseService entrepriseService;
	
	@GetMapping(value="/entreprises")
	public List<Entreprise> listeEntreprises(){
		return this.entrepriseService.listeEntreprises();
	}
}
