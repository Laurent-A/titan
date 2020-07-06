package com.titan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.titan.modele.Metier;
import com.titan.service.MetierService;

@RestController
@RequestMapping("/titan")
public class MetierController {
	
	@Autowired
	private MetierService metierService;

	//afficher la liste des differents domaines d'entreprises
	@GetMapping(value="/metiers", produces= {"application/json"})
	public List<Metier> listeMetier(){
		return this.metierService.listeMetiers();
	}

}
