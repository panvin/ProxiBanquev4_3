package com.konradvincent2software.proxibanquesi.dao;

import java.util.Collection;

import com.konradvincent2software.proxibanquesi.domaine.Client;

public class ClientDaoJpa extends GestionEntityManager implements IClientDao {

	@Override
	public boolean createClient(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Client> readAllClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Client> readClientByConseiller(String logInit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client readClientById(int idInit) {
		// TODO Auto-generated method stub
		return null;
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
