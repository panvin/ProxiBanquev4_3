package com.konradvincent2software.proxibanquesi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.konradvincent2software.proxibanquesi.domaine.Client;
import com.konradvincent2software.proxibanquesi.domaine.Compte;
import com.konradvincent2software.proxibanquesi.domaine.CompteCourant;
import com.konradvincent2software.proxibanquesi.domaine.CompteEpargne;

public class CompteDaoJpa extends GestionEntityManager implements ICompteDao {

	private EntityManager em;
	
	public CompteDaoJpa(){
		this.em = this.creerEntityManager();
	}
	@Override
	public boolean createCompte(Compte compte, String typeCompte, int idClient) {
		ClientDaoJpa clientDao = new ClientDaoJpa();
		Client client = clientDao.readClientById(idClient);
		if (typeCompte.equals("Epargne")) {
			client.setCompteEpargne((CompteEpargne) compte);
			clientDao.updateClientById(idClient, client);
			return true;
		}else if(typeCompte.equals("Courant")){
			client.setCompteCourant((CompteCourant) compte);
			clientDao.updateClientById(idClient, client);
			return true;
		}
		return false;
	}

	@Override
	public Compte readCompteByNum(String numCompte) {
		Compte compte = em.find(Compte.class, numCompte);
		return compte;
	}

	@Override
	public boolean updateCompteByNum(String numCompte, float newSolde) {
		Compte compte = readCompteByNum(numCompte);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		compte.setSolde(newSolde);
		tx.commit();
		return false;
		
	}

	@Override
	public boolean deleteCompteByNum(String numCompte) {
		Compte compte = readCompteByNum(numCompte);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(compte);
		tx.commit();
		return false;
	}

	@Override
	public boolean deleteCompteByIdClient(int idClient) {
		// TODO Auto-generated method stub
		return false;
	}

}
