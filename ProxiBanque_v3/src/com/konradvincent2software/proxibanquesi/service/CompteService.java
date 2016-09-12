package com.konradvincent2software.proxibanquesi.service;

import java.util.ArrayList;

import com.clementvincent2software.proxibanquesi.dao.ClientDao;
import com.clementvincent2software.proxibanquesi.dao.CompteDao;
import com.clementvincent2software.proxibanquesi.domaine.Client;
import com.clementvincent2software.proxibanquesi.domaine.Compte;
import com.clementvincent2software.proxibanquesi.domaine.CompteCourant;
import com.clementvincent2software.proxibanquesi.domaine.CompteEpargne;

/**
 * Classe de la couche service dédié à tout ce qui concerne les comptes. 
 * Cette classe permet de traiter les comptes clients: ajouter des comptes (créer),
 * modifier des comptes, supprimer des comptes, consulter des comptes. Ce
 * service permet egalement de réaliser des virements comptes à comptes entre
 * les clients de l'etablissment.
 * 
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class CompteService {

	/**
	 * Cette methode permet d'ajouter un compte à un client existant
	 * 
	 * @param client
	 *            Objet client auquel le compte va etre ajoute (Objet de type Client)
	 * @param typeCompte
	 *            Type de compte: "Courant", "Epargne" (String)
	 * @param numero
	 *            Le Numero de compte (String)
	 * @param solde
	 *            Le Solde du compte (float)
	 * @param dateOuverture
	 *            La Date d'ouverture du compte (String)
	 * @return Retourne un booleen: true si le compte est cree et ajoute, false
	 *         sinon (booléen)
	 */
	public boolean ajouterCompte(Client client, String typeCompte, String numero, float solde, String dateOuverture) {
		if(typeCompte.equals("Epargne") && client.getCompteEpargne() == null) {
			CompteEpargne compteClient = new CompteEpargne(numero, solde, dateOuverture, client);
			client.setCompteEpargne(compteClient);
			CompteDao.createCompte(compteClient, typeCompte, client.getId());
			ClientDao.updateClientById(client.getId(), client);
			return true;
		}
		else if (typeCompte.equals("Courant") && client.getCompteEpargne() == null) {
			CompteCourant compteClient = new CompteCourant(numero, solde, dateOuverture, client);
			client.setCompteCourant(compteClient);
			CompteDao.createCompte(compteClient, typeCompte, client.getId());
			ClientDao.updateClientById(client.getId(), client);
			return true;
		}
		else 
			return false;
	}

	/**
	 * Cette methode permet de realiser un virement compte à compte au sein de
	 * la banque
	 * 
	 * @param compteADebiter
	 *            Le compte à debiter (String)
	 * @param compteACrediter
	 *            Le compte à crediter (String)
	 * @param montant
	 *            Le montant du virement. (float)
	 * @return Retourne un booléen: true si tout se déroule sans problemes sinon false. (booléen)
	 */
	public boolean virementCompteACompte(String numCompteADebiter, String numCompteACrediter, float montant) {

		boolean statusCompteADebiter, statusCompteACrediter;
		float soldeCompteADebiter = CompteDao.readCompteByNum(numCompteADebiter).getSolde() - montant;
		float soldeCompteACrediter = CompteDao.readCompteByNum(numCompteACrediter).getSolde() + montant;

		statusCompteADebiter = CompteDao.updateCompteByNum(numCompteADebiter, soldeCompteADebiter);
		statusCompteACrediter = CompteDao.updateCompteByNum(numCompteACrediter, soldeCompteACrediter);

		return (statusCompteADebiter && statusCompteACrediter);
	}

	/**
	 * Cette méthode permet de supprimer un compte de la base de donnée à partir
	 * du numero de compte
	 * 
	 * @param numeroCompte
	 *            Le numero du compte à supprimer. (String)
	 * @return Retourne un booléen: true si tout se déroule sans problemes sinon false. (booléen)
	 */
	public boolean supprimerCompte(String numeroCompte) {
		boolean status;
		status = CompteDao.deleteCompteByNum(numeroCompte);
		return status;
	}

	public boolean supprimerCompteParClient(int idClient) {
		boolean status;
		status = CompteDao.deleteCompteByIdClient(idClient);
		return status;
	}

	/**
	 * Cette méthode permet de consulter les informations relatives à un compte
	 * et de les retourner sous forme d'objet Compte
	 * 
	 * @param numeroCompte
	 *            Le numero de compte dont on souhaite visualiser les infos (String)
	 * @return Retourne l'objet compte demande. (Objet de type COmpte)
	 */
	public Compte consulterCompte(String numeroCompte) {
		Compte compteDemande = CompteDao.readCompteByNum(numeroCompte);
		return compteDemande;
	}
	
	/**
	 * Cette méthode permet de retourner l'ensemble des comptes clients sous forme de liste
	 * @return Retourne une ArrayList contenant l'ensemble des comptes clients.(ArrayList<Client>)
	 */
	public ArrayList<Compte> consulterTousLesCompte() {
		ArrayList<Compte> listeCompteDemande = CompteDao.readAllCompte();
		return listeCompteDemande;
	}	

	/**
	 * Cette methode permet de mettre à jour les donnes du compte en banque à
	 * partir de son numero.
	 * 
	 * @param numeroCompte
	 *            Le numéro du compte dont on souhaite faire une modification. (String)
	 * @param montant
	 *            Le montant de la transaction effectuée sur le compte. (float)
	 */
	public void modifierCompte(String numeroCompte, float montant) {
		CompteDao.updateCompteByNum(numeroCompte, montant);
	}
}
