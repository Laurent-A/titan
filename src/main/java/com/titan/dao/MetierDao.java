package com.titan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.titan.modele.Metier;

@Repository
public interface MetierDao extends JpaRepository<Metier, Integer> {

}
