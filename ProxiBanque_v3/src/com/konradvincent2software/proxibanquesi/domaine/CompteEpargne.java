package com.konradvincent2software.proxibanquesi.domaine;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 * Classe CompteEpargne, représente le compte epargne d'un client proxibanque
 * 
 * @author Konrad THOMAS et Vincent PANOUILLERES
 *
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPTE")
@DiscriminatorValue("EPARGNE")
public class CompteEpargne extends Compte {

	@OneToOne
	private Client titulaire;

	/**
	 * Constructeur de la classe CompteEpargne
	 * 
	 * @param numero
	 *            Le numero du compte (String)
	 * @param solde
	 *            Le solde du compte (float)
	 * @param dateOuverture
	 *            La date d'ouverture du compte (String)
	 * @param titulaire
	 *            Le Client titulaire du compte (Objet de type CLient)
	 */
	public CompteEpargne(String numero, Float solde, String dateOuverture, Client titulaire) {
		super(numero, solde, dateOuverture);
		this.titulaire = titulaire;
	}

	/**
	 * Constructeur de la classe CompteEpargne
	 * 
	 * @param numero
	 *            Le numero du compte (String)
	 * @param solde
	 *            Le solde du compte (float)
	 * @param dateOuverture
	 *            La date d'ouverture du compte (String)
	 */
	public CompteEpargne(String numero, Float solde, String dateOuverture) {
		super(numero, solde, dateOuverture);
	}

	/**
	 * Méthode permettant d'obtenir le titulaire du CompteEpargne
	 * 
	 * @return Le Client titulaire du compte (Objet de type CLient)
	 */
	public Client getTitulaire() {
		return titulaire;
	}

	/**
	 * Méthode permettant de modifier le titulaire du CompteEpargne
	 * 
	 * @param titulaire
	 *            Le Client titulaire du compte (Objet de type CLient)
	 */
	public void setTitulaire(Client titulaire) {
		this.titulaire = titulaire;
	}
}
