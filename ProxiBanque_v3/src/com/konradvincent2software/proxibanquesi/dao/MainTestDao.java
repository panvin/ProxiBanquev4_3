package com.konradvincent2software.proxibanquesi.dao;

import com.konradvincent2software.proxibanquesi.domaine.Conseiller;

public class MainTestDao {

	public static void main(String[] args) {
		
		ConseillerDaoJpa cDao = new ConseillerDaoJpa();
		Conseiller cslr = new Conseiller("Vincent", "Panouilleres", "Monsieur", "longin", "password");
		
		cDao.createConseiller(cslr);
		
		Conseiller conseiller;
		conseiller= cDao.readConseillerByLogin("longin");
		//cDao.deleteConseillerByLogin("longin");
		System.out.println("ok");
		

	}

}
