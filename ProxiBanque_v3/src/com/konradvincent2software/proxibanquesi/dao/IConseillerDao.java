package com.konradvincent2software.proxibanquesi.dao;

import com.konradvincent2software.proxibanquesi.domaine.Conseiller;

/**
 * Interface pour la Classe de gestion des conseillerds en base de données
 * @author Konrad THOMAS et VIncent PANOUILLERES
 */
public interface IConseillerDao {
	
	/**
	 * Méthode permettant la création en base d'un nouveau conseiller en base
	 * @param conseiller L'objet conseiller qu'on souhaite entrer dans la base de données. (Objet de type Conseiller)
	 * @return Retourne true si la methode se deroule correctement, retourne false sinon (booléen)
	 */
	public void createConseiller(Conseiller conseiller);
	
	/**
	 * Méthode permettant de récupérer les informations en base d'un conseiller à partir de son login
	 * @param loginInit Login du conseiller (String)
	 * @return conseiller Le conseiller obtenu à partir du Login (Objet de type Conseiller).
	 */
	public Conseiller readConseillerByLogin(String loginInit);
	
	/**
	 * Méthode permettant de mettre à jour en base un conseiller à partir de son login
	 * @param loginInit Login du conseiller (String)
	 * @param newConseiller Objet Conseiller contenant les nouvelles informations (Objet de type Conseiller)
	 * @return Retourne true si la methode se deroule correctement, retourne false sinon (booléen)
	 */
	public void updateConseillerByLogin(String loginInit, Conseiller newConseiller);
	
	/**
	 * Méthode permettant de supprimer en base un conseiller à partir de son login.
	 * @param loginInit Login du conseiller (String).
	 * @return Retourne true si la methode se deroule correctement, retourne false sinon (booléen).
	 */
	public void deleteConseillerByLogin(String loginInit);
}