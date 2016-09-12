package com.clementvincent2software.proxibanquesi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GestionEntityManager {
	
	public EntityManager creerEntityManager(){
		// Ouverture unité de travail JPA
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demojpa-pu");
		EntityManager em = emf.createEntityManager();
		// Ouverture transaction
		EntityTransaction tx =  em.getTransaction();
		tx.begin();
		
		return em;
	}
	
	public void fermerEntityManager( EntityManager em){
		// Fermeture tran,saction
		EntityTransaction tx =  em.getTransaction();
		tx.commit();
		
		// Fermeture unité de travail JPA
		EntityManagerFactory emf = em.getEntityManagerFactory();
		em.close();
		emf.close();	 
	}

}
