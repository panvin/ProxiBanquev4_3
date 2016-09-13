package com.konradvincent2software.proxibanquesi.dao;

import java.util.ArrayList;

import com.konradvincent2software.proxibanquesi.domaine.Compte;

/**
 * Interface pour la Classe de gestion des comptes en base de données
 * @author Konrad THOMAS et VIncent PANOUILLERES
 */
public interface ICompteDao {
	
	/**
	 * Méthode permettant de créer en base un compte.
	 * @param compte Objet compte lié au compte qu'on souhaite créer. (Objet de type COmpte)
	 * @param typeCompte Le type de compte qui va être crée: "Courant" ou "Epargne". (String)
	 * @param idClient Identifiant du client titulaire du futur compte. (int)
	 * @return Renvoie true si la méthode se déroule sans probleme, renvoie false sinon. (booléen)
	 */
	public boolean createCompte(Compte compte, String typeCompte, int idClient);
	
	/**
	 * Méthode permettant d'obtenir les informations d'un compte à partir de son numéro.
	 * @param numCompte Le numéro du compte dont on souhaite obtenir des informations. (String)
	 * @return Retourne l'objet compte à partir du numero de compte specifié en parametre de la méthode. (Objet de type Compte)
	 */
	public Compte readCompteByNum(String numCompte);
	
	/**
	 * Méthode permettant de modifier en base le solde d'un compte à partir du numéro de compte.
	 * @param numCompte Le numéro de compte qu'on souhaite mettre à jour. (String)
	 * @param newSolde Le nouveau solde du compte à mettre à jour. (float)
	 * @return Renvoie true si la méthode se déroule sans probleme, renvoie false sinon. (booléen)
	 */
	public boolean updateCompteByNum(String numCompte, float newSolde);
	
	/**
	 * Méthode permettant de supprimer en base un compte à partir de son numéro.
	 * @param numCompte Le numéro du compte à supprimer dans la base de données. (String)
	 * @return Renvoie true si la méthode se déroule sans probleme, renvoie false sinon. (booléen)
	 */
	public boolean deleteCompteByNum(String numCompte);
	
	/**
	 * Méthode permettant de supprimer en base un compte à partir de l'identifiant client.
	 * @param idClient L'identifiant du client dont on souhaite supprimer le ou les comptes. (int)
	 * @return Renvoie true si la méthode se déroule sans probleme, renvoie false sinon. (booléen)
	 */
	public boolean deleteCompteByIdClient(int idClient);
	
	/**
	 * Méthode permettant de lire en base l'ensemble des comptes clients.
	 * @return Renvoie une liste de compte (Objet de type ArrayList).
	 */
	public ArrayList<Compte> readAllCompte();

}