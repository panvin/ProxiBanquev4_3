package com.konradvincent2software.proxibanquesi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.konradvincent2software.proxibanquesi.domaine.Conseiller;

public class ConseillerDaoJpa extends GestionEntityManager implements IConseillerDao {

	private EntityManager em;
	
	public ConseillerDaoJpa(){
		this.em = this.creerEntityManager();
	}
	
	@Override
	public void createConseiller(Conseiller conseiller) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(conseiller);
		tx.commit();
	}

	@Override
	public Conseiller readConseillerByLogin(String loginInit) {
		
		Conseiller conseiller = em.find(Conseiller.class, loginInit);
		return conseiller;
	}

	@Override
	public void updateConseillerByLogin(String loginInit, Conseiller newConseiller) {
		Conseiller conseiller = readConseillerByLogin(loginInit);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		conseiller.setCivilite(newConseiller.getCivilite());
		conseiller.setNom(newConseiller.getNom());
		conseiller.setPrenom(newConseiller.getPrenom());
		conseiller.setPassword(newConseiller.getPassword());
		conseiller.setClients(newConseiller.getClients());
		tx.commit();


	}

	@Override
	public void deleteConseillerByLogin(String loginInit) {
		
		Conseiller conseiller = this.readConseillerByLogin(loginInit);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(conseiller);
		tx.commit();
	}
}
