package com.konradvincent2software.proxibanquesi.dao;

import com.konradvincent2software.proxibanquesi.domaine.Coordonnees;

public interface ICoordonneesDao {
	public boolean createCoordonnees(Coordonnees coordonnees, int clientId);
	public Coordonnees readCoordonneesByIdClient(int idClient);
	public boolean updateCoordonneesByClientId(int idClient, Coordonnees newCoordonnees);
	public boolean deleteCoordonneesByClientId(int idClient);
	

}