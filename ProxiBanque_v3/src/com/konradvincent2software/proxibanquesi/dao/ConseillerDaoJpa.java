package com.konradvincent2software.proxibanquesi.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.konradvincent2software.proxibanquesi.domaine.Conseiller;

public class ConseillerDaoJpa extends GestionEntityManager implements IConseillerDao {

	@Override
	public void createConseiller(Conseiller conseiller) {
		EntityManager em = this.creerEntityManager();
		
		em.persist(conseiller);
		
		this.fermerEntityManager(em);

	}

	@Override
	public Conseiller readConseillerByLogin(String loginInit) {
		EntityManager em = this.creerEntityManager();
		
		Conseiller conseiller = em.createQuery("SELECT c FROM Conseiller c WHERE c.login LIKE: loginInit", Conseiller.class).setParameter("loginInit",loginInit).getSingleResult();
		this.fermerEntityManager(em);
		return conseiller;
	}

	@Override
	public void updateConseillerByLogin(String loginInit, Conseiller newConseiller) {
		EntityManager em = this.creerEntityManager();
		Conseiller conseiller = em.createQuery("SELECT c FROM Conseiller c WHERE c.login LIKE: loginInit", Conseiller.class).setParameter("loginInit",loginInit).getSingleResult();
		Query query = em.createQuery("UPDATE Conseiller SET ");
		this.fermerEntityManager(em);

	}

	@Override
	public void deleteConseillerByLogin(String loginInit) {
		// TODO Auto-generated method stub
		EntityManager em = this.creerEntityManager();
		
		Conseiller conseiller = em.createQuery("SELECT c FROM Conseiller c WHERE c.login LIKE: loginInit", Conseiller.class).setParameter("loginInit",loginInit).getSingleResult();
		em.remove(conseiller);
		this.fermerEntityManager(em);

	}

}
