package com.konradvincent2software.proxibanquesi.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.konradvincent2software.proxibanquesi.domaine.Client;
import com.konradvincent2software.proxibanquesi.domaine.Compte;
import com.konradvincent2software.proxibanquesi.domaine.CompteCourant;
import com.konradvincent2software.proxibanquesi.domaine.CompteEpargne;

/**
 * Classe de DAO dédié au domaine métier Compte
 * Cette classe permet de gerer en base l'ensemble des objets comptes
 * @author Konrad THOMAS et Vincent PANOUILLERES 
 *
 */
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
		return true;
		
	}

	@Override
	public boolean deleteCompteByNum(String numCompte) {
		Compte compte = readCompteByNum(numCompte);
		if (compte!= null){
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(compte);
		tx.commit();
		}
		return false;
	}

	@Override
	public boolean deleteCompteByIdClient(int idClient) {
		Query query = em.createQuery("DELETE FROM CompteCourant e WHERE e.titulaire.id = :idClient").setParameter("idClient", idClient);
		query.executeUpdate();
		query = em.createQuery("DELETE FROM CompteEpargne e WHERE e.titulaire.id = :idClient").setParameter("idClient", idClient);
		query.executeUpdate();
		return false;
	}
	public ArrayList<Compte> readAllCompte() {
		Query query = em.createQuery("SELECT e FROM Compte e");
	    return (ArrayList<Compte>) query.getResultList();
	}
	public CompteEpargne readCompteByClientAndByType(int idClient, String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
