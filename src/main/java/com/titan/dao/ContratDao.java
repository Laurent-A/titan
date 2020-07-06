package com.titan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.titan.modele.Contrat;

@Repository
public interface ContratDao extends JpaRepository<Contrat, Integer> {

}
