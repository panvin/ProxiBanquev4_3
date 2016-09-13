package com.konradvincent2software.proxibanquesi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.konradvincent2software.proxibanquesi.domaine.Conseiller;

/**
 * Classe de DAO dédié au domaine métier Conseiller
 * Cette classe permet de gerer en base l'ensemble des informations conseiller
 * @author Konrad THOMAS et Vincent PANOUILLERES 
 *
 */
public class ConseillerDaoJpa extends GestionEntityManager implements IConseillerDao {

	private EntityManager em;

	/**
	 * Constructeur de la classe, permet d'initier l'EntityManager
	 */
	public ConseillerDaoJpa() {
		this.em = this.creerEntityManager();
	}

	/* (non-Javadoc)
	 * @see com.konradvincent2software.proxibanquesi.dao.IConseillerDao#createConseiller(com.konradvincent2software.proxibanquesi.domaine.Conseiller)
	 */
	@Override
	public void createConseiller(Conseiller conseiller) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(conseiller);
		tx.commit();
	}

	/* (non-Javadoc)
	 * @see com.konradvincent2software.proxibanquesi.dao.IConseillerDao#readConseillerByLogin(java.lang.String)
	 */
	@Override
	public Conseiller readConseillerByLogin(String loginInit) {

		Conseiller conseiller = em.find(Conseiller.class, loginInit);
		return conseiller;
	}

	/* (non-Javadoc)
	 * @see com.konradvincent2software.proxibanquesi.dao.IConseillerDao#updateConseillerByLogin(java.lang.String, com.konradvincent2software.proxibanquesi.domaine.Conseiller)
	 */
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

	/* (non-Javadoc)
	 * @see com.konradvincent2software.proxibanquesi.dao.IConseillerDao#deleteConseillerByLogin(java.lang.String)
	 */
	@Override
	public void deleteConseillerByLogin(String loginInit) {
		Conseiller conseiller = this.readConseillerByLogin(loginInit);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(conseiller);
		tx.commit();
	}
}
