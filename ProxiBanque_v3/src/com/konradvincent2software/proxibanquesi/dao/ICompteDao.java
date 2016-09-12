package com.clementvincent2software.proxibanquesi.dao;

import com.clementvincent2software.proxibanquesi.domaine.Compte;

public interface ICompteDao {
	public boolean createCompte(Compte compte, String typeCompte, int idClient);
	public Compte readCompteByNum(String numCompte);
	public boolean updateCompteByNum(String numCompte, float newSolde);
	public boolean deleteCompteByNum(String numCompte);
	public boolean deleteCompteByIdClient(int idClient);

}