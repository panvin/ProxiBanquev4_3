package com.konradvincent2software.proxibanquesi.domaine;

import java.util.List;

/**
 * Classe Conseiller, représente les Conseillers de ProxiBanque
 * 
 * @author Clement CASTRO et Vincent PANOUILLERES
 */
public class Conseiller extends Personne {

	private String login;
	private String password;
	private List<Client> clients;

	/**
	 * Constructeur de la classe Conseiller
	 * 
	 * @param nom
	 *            Le nom du conseiller (String)
	 * @param prenom
	 *            Le prenom du conseiller (String)
	 * @param civilite
	 *            La civilite du conseiller (String)
	 * @param login
	 *            Le login unique du conseiller (String)
	 * @param password
	 *            Le mot de passe du conseiller (String)
	 * @param clients
	 *            La liste des clients du conseiller (List<Client>)
	 */
	public Conseiller(String nom, String prenom, String civilite, String login, String password, List<Client> clients) {
		super(nom, prenom, civilite);
		this.login = login;
		this.password = password;
		this.clients = clients;
	}

	/**
	 * Constructeur de la classe Conseiller
	 * 
	 * @param nom
	 *            Le nom du conseiller (String)
	 * @param prenom
	 *            Le prenom du conseiller (String)
	 * @param civilite
	 *            La civilite du conseiller (String)
	 */
	public Conseiller(String nom, String prenom, String civilite, String login, String password) {
		super(nom, prenom, civilite);
		this.login = login;
		this.password = password;
	}

	/**
	 * Méthode permettant d'obtenir le Login du Conseiller
	 * 
	 * @return Le login unique du conseiller (String)
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Méthode permettant de modifier le Login du Conseiller
	 * 
	 * @param login
	 *            Le login unique du conseiller (String)
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Méthode permettant d'obtenir le mot de passe du Conseiller
	 * 
	 * @return Le mot de passe du conseiller (String)
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Méthode permettant de modifier le mot de passe du Conseiller
	 * 
	 * @param password
	 *            Le mot de passe du conseiller (String)
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Méthode permettant d'obtenir la Liste des Clients du Conseiller
	 * 
	 * @return a liste des clients du conseiller (List<Client>)
	 */
	public List<Client> getClients() {
		return clients;
	}

	/**
	 * Méthode permettant de modifier la liste des Clients du Conseiller
	 * 
	 * @param clients
	 *            a liste des clients du conseiller (List<Client>)
	 */
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

}
