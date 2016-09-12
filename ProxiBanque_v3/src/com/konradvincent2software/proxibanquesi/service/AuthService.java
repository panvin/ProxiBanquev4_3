package com.konradvincent2software.proxibanquesi.service;

import com.konradvincent2software.proxibanquesi.dao.ConseillerDao;
import com.konradvincent2software.proxibanquesi.domaine.Conseiller;

/**
 * Classe du domaine service permettant l'authentification des utilisateurs.
 * Cette classe va permettre de valider l'authentification d'un conseiller si
 * ses informations (login et password) sont correctes. Dans le cas contraire il
 * ne pourra pas s'authentifier.
 * 
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class AuthService {

	/**
	 * Cette méthode permet à l'utilisateur de s'identifier. Elle retourne un
	 * booléen true si l'authentification a reussi et sinon elle retourne un
	 * false
	 * 
	 * @param login
	 *            Le login de l'utilisateur (String)
	 * @param pwd
	 *            Le mot de passe de l'utilisateur (String)
	 * @return Retourne un booléen true si l'authentification réussie, retourne
	 *         false sinon. (booléen)
	 */
	public boolean authConseiller(String login, String pwd) {
		ConseillerDao conseillerDao = new ConseillerDao();

		Conseiller conseiller = conseillerDao.readConseillerByLogin(login);

		if (conseiller == null || conseiller.getLogin() == null) {
			return false;
		}

		if ((conseiller.getLogin().equalsIgnoreCase(login)) && (conseiller.getPassword().equalsIgnoreCase(pwd))) {
			return true;
		} else {
			return false;
		}
	}
}
