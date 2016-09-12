package com.konradvincent2software.proxibanquesi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Conseiller conseiller = em.createQuery("SELECT c FROM Conseiller c WHERE c.login = :loginInit", Conseiller.class).setParameter("loginInit",loginInit).getSingleResult();
		Query query = em.createQuery("UPDATE Conseiller SET ");
		query.executeUpdate();
		tx.commit();


	}

	@Override
	public void deleteConseillerByLogin(String loginInit) {
		
		Conseiller conseiller = this.readConseillerByLogin(loginInit);
		em.remove(conseiller);

	}

}
