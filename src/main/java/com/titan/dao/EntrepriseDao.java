package com.titan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.titan.modele.Entreprise;

@Repository
public interface EntrepriseDao extends JpaRepository<Entreprise, Integer> {

	@Query(value="select * from Entreprise e where e.id_metier=?1", nativeQuery= true)
	public List<Entreprise> entrepriseParMetier(Integer id_metier);
}
