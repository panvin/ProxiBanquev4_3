package com.konradvincent2software.proxibanquesi.service;

import com.konradvincent2software.proxibanquesi.dao.ClientDao;
import com.konradvincent2software.proxibanquesi.dao.ConseillerDao;
import com.konradvincent2software.proxibanquesi.domaine.Conseiller;

/**
 * Classe de la couche service concernant l'ensemble des opération pour le
 * conseiller Cette classe permet de créer, modifier, supprimer, lire ou effacer
 * un conseiller
 * 
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class ConseillerService {

	/**
	 * Cette méthode permet de créer un conseiller dans la base de données.
	 * 
	 * @param conseiller
	 *            L'objet conseiller qu'on va vouloir stocker dans la database
	 *            (Objet de type Conseiller)
	 * @return Retourne un booléen: true si tout se déroule sans problemes sinon
	 *         false. (booléen)
	 */
	public boolean creerConseiller(Conseiller conseiller) {
		boolean status;
		ConseillerDao conseillerDao = new ConseillerDao();
		status = conseillerDao.createConseiller(conseiller);
		return status;

	}

	/**
	 * Cette méthode permet de modifier un conseiller dans la base de données
	 * 
	 * @param login
	 *            Le login unique du conseiller (String)
	 * @param conseiller
	 *            L'objet conseiller modifié (Objet de type conseiller)
	 * @return Retourne un booléen: true si tout se déroule sans problemes sinon
	 *         false. (booléen)
	 */
	public boolean modifierConseiller(String login, Conseiller conseiller) {
		ConseillerDao conseillerDao = new ConseillerDao();
		boolean status = conseillerDao.updateConseillerByLogin(login, conseiller);
		return status;
	}

	/**
	 * Cette méthode permet de supprimer un conseiller de la base de données à
	 * partir de son Login
	 * 
	 * @param login
	 *            Le login unique du conseiller (String)
	 * @return Retourne un booléen: true si tout se déroule sans problemes sinon
	 *         false. (booléen)
	 */
	public boolean supprimerConseiller(String login) {
		boolean status;
		ConseillerDao conseillerDao = new ConseillerDao();
		status = conseillerDao.deleteConseillerByLogin(login);
		return status;
	}

	/**
	 * Cette métrhode permet de recuperer les informations
	 * 
	 * @param login
	 *            Le login unique du conseiller (String)
	 * @return Le conseiller correspondant à l'identifiant spécifié en paramètre
	 *         (Objet de type Conseiller)
	 */
	public Conseiller lireConseiller(String login) {
		ConseillerDao conseillerDao = new ConseillerDao();
		Conseiller conseiller = conseillerDao.readConseillerByLogin(login);
		return conseiller;
	}
}
