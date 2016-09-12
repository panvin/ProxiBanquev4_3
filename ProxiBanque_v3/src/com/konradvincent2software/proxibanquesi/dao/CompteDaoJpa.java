package com.clementvincent2software.proxibanquesi.dao;

import com.clementvincent2software.proxibanquesi.domaine.Compte;

public class CompteDaoJpa extends GestionEntityManager implements ICompteDao {

	@Override
	public boolean createCompte(Compte compte, String typeCompte, int idClient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Compte readCompteByNum(String numCompte) {
		// TODO Auto-generated method stub
		return null;
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
