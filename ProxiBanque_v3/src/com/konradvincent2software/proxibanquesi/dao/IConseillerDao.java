package com.konradvincent2software.proxibanquesi.dao;

import com.konradvincent2software.proxibanquesi.domaine.Conseiller;

public interface IConseillerDao {
	
	public void createConseiller(Conseiller conseiller);
	public Conseiller readConseillerByLogin(String loginInit);
	public void updateConseillerByLogin(String loginInit, Conseiller newConseiller);
	public void deleteConseillerByLogin(String loginInit);
}