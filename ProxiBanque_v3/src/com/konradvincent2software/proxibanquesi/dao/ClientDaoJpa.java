package com.konradvincent2software.proxibanquesi.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.konradvincent2software.proxibanquesi.domaine.Client;
import com.konradvincent2software.proxibanquesi.domaine.Conseiller;

public class ClientDaoJpa extends GestionEntityManager implements IClientDao {

	private EntityManager em;
	
	public ClientDaoJpa(){
		this.em = this.creerEntityManager();
	}
	@Override
	public boolean createClient(Client client) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(client);
		tx.commit();
		return true;
	}

	@Override
	public Collection<Client> readAllClient() {
		Query query = em.createQuery("select E from Client E where 1 = 1");
        return query.getResultList();
	}

	@Override
	public Collection<Client> readClientByConseiller(String logInit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client readClientById(int idInit) {
		Client client = em.find(Client.class, idInit);
		return client;
	}

	@Override
	public boolean updateClientById(int idInit, Client newClient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteClientById(int idInit) {
		// TODO Auto-generated method stub
		return false;
	}

}
