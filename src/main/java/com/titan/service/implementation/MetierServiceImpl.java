package com.titan.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.titan.dao.MetierDao;
import com.titan.modele.Metier;
import com.titan.service.MetierService;

@Service
public class MetierServiceImpl implements MetierService {
	
	@Autowired
	private MetierDao metierDao;
	
	@Override
	public List<Metier> listeMetiers(){
		return metierDao.findAll();
	}
}
