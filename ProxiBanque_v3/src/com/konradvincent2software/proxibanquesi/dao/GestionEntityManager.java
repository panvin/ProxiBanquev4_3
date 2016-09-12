package com.konradvincent2software.proxibanquesi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GestionEntityManager {
	
	public EntityManager creerEntityManager(){
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		
		return em;
	}
	
	public void fermerEntityManager( EntityManager em){
		// Fermeture unité de travail JPA
		EntityManagerFactory emf = em.getEntityManagerFactory();
		em.close();
		emf.close();	 
	}

}
