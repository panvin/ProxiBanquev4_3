package com.clementvincent2software.proxibanquesi.dao;

import com.clementvincent2software.proxibanquesi.domaine.Coordonnees;

public class CoordonneesDaoJpa extends GestionEntityManager implements ICoordonneesDao {

	@Override
	public boolean createCoordonnees(Coordonnees coordonnees, int clientId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Coordonnees readCoordonneesByIdClient(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCoordonneesByClientId(int idClient, Coordonnees newCoordonnees) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCoordonneesByClientId(int idClient) {
		// TODO Auto-generated method stub
		return false;
	}

}
