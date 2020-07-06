package com.titan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.titan.modele.Entreprise;

@Repository
public interface EntrepriseDao extends JpaRepository<Entreprise, Integer> {

}
