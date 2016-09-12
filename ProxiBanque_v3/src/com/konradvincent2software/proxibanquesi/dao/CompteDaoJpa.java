package com.konradvincent2software.proxibanquesi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.konradvincent2software.proxibanquesi.domaine.Compte;
import com.konradvincent2software.proxibanquesi.domaine.Conseiller;

public class CompteDaoJpa extends GestionEntityManager implements ICompteDao {

	private EntityManager em;
	
	public CompteDaoJpa(){
		this.em = this.creerEntityManager();
	}
	@Override
	public boolean createCompte(Compte compte, String typeCompte, int idClient) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(compte);
		tx.commit();
		return false;
	}

	@Override
	public Compte readCompteByNum(String numCompte) {
		Compte compte = em.find(Compte.class, numCompte);
		return compte;
	}

	@Override
	public boolean updateCompteByNum(String numCompte, float newSolde) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCompteByNum(String numCompte) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCompteByIdClient(int idClient) {
		// TODO Auto-generated method stub
		return false;
	}

}
