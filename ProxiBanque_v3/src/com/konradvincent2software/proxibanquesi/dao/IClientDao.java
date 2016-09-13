package com.konradvincent2software.proxibanquesi.dao;

import java.util.Collection;

import com.konradvincent2software.proxibanquesi.domaine.Client;

/**
 * Interface pour la Classe de gestion des clients en base de données
 * @author Konrad THOMAS et VIncent PANOUILLERES
 *
 */
public interface IClientDao {
	
	/**
	 * Methode permettant de créer un client
	 * @param client Le client a créer en base de données (Objet de type Client)
	 * @return Retourne un booléen (true si réussi sinon false)
	 */
	public boolean createClient(Client client);
	
	/**
	 * Methode permettant de lire l'ensemble des clients en base de données
	 * @return Retourne une collection de client (Objet de type Collection)
	 */
	public Collection<Client> readAllClient();
	
	/**
	 * Méthode permettant de récupérer en base la liste des clients d'un conseiller à partir de son login
	 * @param logInit login du conseiller (String)
	 * @return Collection de Clients (Collection de Client)
	 */
	public Collection<Client> readClientByConseiller(String logInit);
	
	/**
	 * Méthode permettant de récupérer en base les informations d'un Client à partir de son identifiant
	 * @param idInit L'identifiant unique du client (int)
	 * @return Client Retourne l'objet client correspondant à l'identifiant spécifié (Objet Client)
	 */
	public Client readClientById(int idInit);
	
	/**
	 * Méthode permettant de mettre à jour en base un client à partir de son identifiant
	 * @param idInit L'identifiant du Client à mettre à jour (int)
	 * @param newClient Objet Client contenant les nouvelles informations (Client)
	 * @return Retourne true si la méthode se déroule bien sinon retourne false (booléen)
	 */
	public boolean updateClientById(int idInit, Client newClient);
	
	/**
	 * Méthode permettant de supprimer en base un client à partir de son identifiant
	 * @param idInit L'identifiant du client à supprimer (int)
	 * @return Retourne true si la méthode se déroule bien sinon retourne false (booléen)
	 */
	public boolean deleteClientById(int idInit);
}