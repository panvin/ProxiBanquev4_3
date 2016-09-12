package com.konradvincent2software.proxibanquesi.dao;

import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;

import com.konradvincent2software.proxibanquesi.domaine.Client;
import com.konradvincent2software.proxibanquesi.domaine.Compte;
import com.konradvincent2software.proxibanquesi.domaine.CompteCourant;
import com.konradvincent2software.proxibanquesi.domaine.CompteEpargne;
import com.konradvincent2software.proxibanquesi.domaine.Coordonnees;

public class MainTestDao {

	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		
		Client clt1 = new Client("test", "test", "Mr", "azerty@erty", 4); 
		CompteCourant cptetest1 = new CompteCourant("0125478",(float) 150, "22/01/2016", clt1);
		CompteEpargne cptetest2 = new CompteEpargne("0125788",(float) 150, "22/01/2016", clt1);
		CompteDaoJpa cpteJpa = new CompteDaoJpa();
		ClientDaoJpa cltDaoJpa = new ClientDaoJpa();
		
		cltDaoJpa.createClient(clt1); 
		cpteJpa.createCompte(cptetest1, "Courant", 4);
		cpteJpa.deleteCompteByIdClient(4);
		cpteJpa.createCompte(cptetest2, "Epargne", 4);
		Compte cpteTest = cpteJpa.readCompteByNum("0125788");
		cpteJpa.updateCompteByNum("0125788", (float) 245888);
		cpteJpa.deleteCompteByNum("0125788");
		
		System.out.println("ok");
		

	}

}
