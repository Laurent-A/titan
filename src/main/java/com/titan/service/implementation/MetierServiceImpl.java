package com.titan.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.titan.dao.MetierDao;
import com.titan.exception.ApiNotFoundException;
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
	
	@Override
	public Metier afficherUnMetier(Integer id) {
		return metierDao.findById(id).orElseThrow(() -> new ApiNotFoundException("metier", "id", id));
	}
	
	@Override
	public Metier creerUnMetier(Metier metier){
		return metierDao.save(metier);
	}
	
	@Override 
	public Metier modifierMetier(Integer id, Metier metierDetail) {
		Metier metier = metierDao.findById(id)
	            .orElseThrow(() -> new ApiNotFoundException("metier", "id", id));
		metier.setLibelle(metierDetail.getLibelle());

		Metier modifMetier = metierDao.save(metier);
	    return modifMetier;
	}
	
	@Override
	public ResponseEntity<?> suppressionMetier(Integer id){
		Metier metier = metierDao.findById(id)
	            .orElseThrow(() -> new ApiNotFoundException("metier", "id", id));
		metierDao.delete(metier);

	    return ResponseEntity.ok().build();
	}
}
