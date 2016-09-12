package com.konradvincent2software.proxibanquesi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.konradvincent2software.proxibanquesi.domaine.Conseiller;
import com.konradvincent2software.proxibanquesi.domaine.Coordonnees;

public class CoordonneesDaoJpa extends GestionEntityManager implements ICoordonneesDao {

	private EntityManager em;
	
	public CoordonneesDaoJpa(){
		this.em = this.creerEntityManager();
	}
	
	@Override
	public boolean createCoordonnees(Coordonnees coordonnees, int clientId) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(coordonnees);
		tx.commit();
		return true;
	}

	@Override
	public Coordonnees readCoordonneesByIdClient(int idClient) {
		Coordonnees coordonnees = em.find(Coordonnees.class, idClient);
		return coordonnees;
	}

	@Override
	public boolean updateCoordonneesByClientId(int idClient, Coordonnees newCoordonnees) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCoordonneesByClientId(int idClient) {
		
		Coordonnees coordonnees = readCoordonneesByIdClient(idClient);
		em.remove(coordonnees);
		
		return false;
	}

}
