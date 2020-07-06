package com.titan.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titan.dao.EntrepriseDao;
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

}
