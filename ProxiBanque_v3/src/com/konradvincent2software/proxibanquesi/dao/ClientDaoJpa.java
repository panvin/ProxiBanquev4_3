package com.konradvincent2software.proxibanquesi.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.konradvincent2software.proxibanquesi.domaine.Client;

/**
 * Classe de DAO dédié au domaine métier CLient
 * Cette classe permet de gerer en base l'ensemble des objets clients
 * @author Konrad THOMAS et Vincent PANOUILLERES 
 *
 */
public class ClientDaoJpa extends GestionEntityManager implements IClientDao {

	private EntityManager em;
	
	/**
	 * Constructeur de la classe, permet d'initier l'EntityManager
	 */
	public ClientDaoJpa(){
		this.em = this.creerEntityManager();
	}
	/* (non-Javadoc)
	 * @see com.konradvincent2software.proxibanquesi.dao.IClientDao#createClient(com.konradvincent2software.proxibanquesi.domaine.Client)
	 */
	@Override
	public boolean createClient(Client client) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(client);
		tx.commit();
		return true;
	}

	/* (non-Javadoc)
	 * @see com.konradvincent2software.proxibanquesi.dao.IClientDao#readAllClient()
	 */
	@Override
	public Collection<Client> readAllClient() {
		Query query = em.createQuery("select E from Client E where 1 = 1");
        return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.konradvincent2software.proxibanquesi.dao.IClientDao#readClientByConseiller(java.lang.String)
	 */
	@Override
	public Collection<Client> readClientByConseiller(String logInit) {
		Query query = em.createQuery("select E from Client E where E.monConseiller.login = :logInit").setParameter("logInit", logInit);
        return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.konradvincent2software.proxibanquesi.dao.IClientDao#readClientById(int)
	 */
	@Override
	public Client readClientById(int idInit) {
		Client client = em.find(Client.class, idInit);
		return client;
	}

	/* (non-Javadoc)
	 * @see com.konradvincent2software.proxibanquesi.dao.IClientDao#updateClientById(int, com.konradvincent2software.proxibanquesi.domaine.Client)
	 */
	@Override
	public boolean updateClientById(int idInit, Client newClient) {
		Client client = readClientById(idInit);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		client.setNom(newClient.getNom());
		client.setPrenom(newClient.getPrenom());
		client.setCivilite(newClient.getCivilite());
		client.setCompteCourant(newClient.getCompteCourant());
		client.setCompteEpargne(newClient.getCompteEpargne());
		client.setMonConseiller(newClient.getMonConseiller());
		client.setEmail(newClient.getEmail());
		client.setCoordonnees(newClient.getCoordonnees());
		tx.commit();
		return false;
	}

	/* (non-Javadoc)
	 * @see com.konradvincent2software.proxibanquesi.dao.IClientDao#deleteClientById(int)
	 */
	@Override
	public boolean deleteClientById(int idInit) {
		Client client = readClientById(idInit);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(client);
		tx.commit();
		return false;
	}

}
