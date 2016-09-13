package com.konradvincent2software.proxibanquesi.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;

import com.konradvincent2software.proxibanquesi.domaine.Client;
import com.konradvincent2software.proxibanquesi.domaine.Compte;
import com.konradvincent2software.proxibanquesi.domaine.CompteCourant;
import com.konradvincent2software.proxibanquesi.domaine.CompteEpargne;
import com.konradvincent2software.proxibanquesi.domaine.Conseiller;
import com.konradvincent2software.proxibanquesi.domaine.Coordonnees;
import com.konradvincent2software.proxibanquesi.service.AuthService;

public class MainTestDao {

	public static void main(String[] args) {
		
		
		
		BasicConfigurator.configure();
		
		ClientDaoJpa clientDao = new ClientDaoJpa();
	
	Conseiller conseiller1 = new Conseiller("castro", "clement", "Monsieur", "ccastro", "gtm");
	Conseiller conseiller2 = new Conseiller("panouilleres", "vincent", "Monsieur", "vpanouilleres", "gtm");
	Client client1 = new Client("Marley", "Bob", "Monsieur", "bobby.marley@reggae.com", "72 rue de la concorde", "Lyon", "06.48.95.69.32", "69000", 1, conseiller1);
	Client client2 = new Client("Holidays", "Johny", "Monsieur", "johny.hollidays@vacances.fr", "45 rue du palace", "Lyon", "06.48.93.45.21", "69000", 2, conseiller1);
	Client client3 = new Client("Morose", "Marilyn", "Madame", "marilyn.morose@chanteuse.com", "48 rue pompidou", "Lyon", "06.56.98.64.16", "69000", 3, conseiller1);
	Client client4 = new Client("Detriomphe", "Jeane", "Madame", "jeanne@bucher.com", "785 avenue des trois rues", "Lyon", "06.98.30.04.87", "69000", 4, conseiller1);
	Client client5 = new Client("Jobs", "Steeve", "Monsieur", "steve.jobs@apple.com", "56 avenue des misères", "Lyon", "06.65.34.73.19", "69000", 5, conseiller1);
	Client client6 = new Client("Lagache", "Guy", "Monsieur", "guy.lagache@gmail.com", "49 rue des riches", "Lyon", "06.58.90.14.75", "69000", 6, conseiller2);
	Client client7 = new Client("Dublin", "Sophie", "Madame", "sophiedublin@gmail.com", "69 rue de la guillotière", "Lyon", "06.98.03.72.92", "69000", 7, conseiller2);
	ArrayList<Client> liste1 = new ArrayList<Client>();
	liste1.add(client1);
	liste1.add(client2);
	liste1.add(client3);
	liste1.add(client4);
	liste1.add(client5);
	ArrayList<Client> liste2 = new ArrayList<Client>();
	liste2.add(client6);
	liste2.add(client7);
	conseiller1.setClients(liste1);
	conseiller2.setClients(liste2);
	
	CompteEpargne compte1 = new CompteEpargne("08457965", (float)58835, "08/12/2015", client3);
	CompteEpargne compte2 = new CompteEpargne("46875231", (float) 4500, "05/05/2005", client4);
	CompteEpargne compte3 = new CompteEpargne("76321054", (float) 7010, "15/07/2009", client2);
	CompteEpargne compte4 = new CompteEpargne("8746953", (float) 10000, "06/04/2012", client1);
	client1.setCompteEpargne(compte4);
	client2.setCompteEpargne(compte3);
	client3.setCompteEpargne(compte1);
	client4.setCompteEpargne(compte2);
	
	CompteCourant compte5 = new CompteCourant("4578965", (float)105717, "08/12/2014", client3);
	CompteCourant compte6 = new CompteCourant("4689501", (float) 7500, "05/07/2016", client7);
	CompteCourant compte7 = new CompteCourant("5630210", (float) 2900, "27/11/2011", client5);
	CompteCourant compte8 = new CompteCourant("6359326", (float) 4850, "15/07/2009", client2);
	CompteCourant compte9 = new CompteCourant("7604501", (float) 3250, "12/10/2010", client6);
	CompteCourant compte10 = new CompteCourant("7645219", (float) 7500, "25/08/2012", client4);
	CompteCourant compte11 = new CompteCourant("7852164", (float) 5100, "23/06/2015", client1);
	client1.setCompteCourant(compte11);
	client2.setCompteCourant(compte8);
	client3.setCompteCourant(compte5);
	client4.setCompteCourant(compte10);
	client5.setCompteCourant(compte7);
	client6.setCompteCourant(compte9);
	client7.setCompteCourant(compte6);

	ConseillerDaoJpa conseillerJpa = new ConseillerDaoJpa();
	
	conseillerJpa.createConseiller(conseiller1);
	conseillerJpa.createConseiller(conseiller2);
	
	
	
	}

}
