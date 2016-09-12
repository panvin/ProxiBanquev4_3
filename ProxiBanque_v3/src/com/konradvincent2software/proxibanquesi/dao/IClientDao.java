package com.konradvincent2software.proxibanquesi.dao;

import java.util.Collection;

import com.konradvincent2software.proxibanquesi.domaine.Client;

public interface IClientDao {
	
	public boolean createClient(Client client);
	public Collection<Client> readAllClient();
	public Collection<Client> readClientByConseiller(String logInit);
	public Client readClientById(int idInit);
	public boolean updateClientById(int idInit, Client newClient);
	public boolean deleteClientById(int idInit);
}