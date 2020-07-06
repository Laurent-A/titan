package com.titan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.titan.modele.Utilisateur;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur, Integer>{

}
