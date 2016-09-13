package com.konradvincent2software.proxibanquesi.domaine;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

/**
 * Classe CompteCourant, représente le compte courant d'un client proxibanque
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPTE")
@DiscriminatorValue("COURANT")
public class CompteCourant extends Compte {

	@OneToOne(cascade=CascadeType.MERGE)
	private Client titulaire;

	/**
	 * Constructeur de la classe CompteCourant
	 * 
	 * @param numero
	 *            Le numero du compte (String)
	 * @param solde
	 *            Le solde du compte (String)
	 * @param dateOuverture
	 *            La date d'ouverture du compte (String)
	 * @param titulaire
	 *            Le Client titulaire du compte (Objet de type CLient)
	 */
	public CompteCourant(String numero, Float solde, String dateOuverture, Client titulaire) {
		super(numero, solde, dateOuverture);
		this.titulaire = titulaire;
	}

	/**
	 * Constructeur de la classe CompteCourant
	 * @param numero Le numero du compte (String)
	 * @param solde Le solde du compte (String)
	 * @param dateOuverture La date d'ouverture du compte (String)
	 */
	public CompteCourant(String numero, Float solde, String dateOuverture) {
		super(numero, solde, dateOuverture);
		// TODO Auto-generated constructor stub
	}
	
	public CompteCourant(){
		super();
	}

	/**
	 * Méthode permettant d'obtenir le titulaire du CompteCourant
	 * @return Le Client titulaire du compte (Objet de type CLient)
	 */
	public Client getTitulaire() {
		return titulaire;
	}

	/**
	 * Méthode permettant de modifier le titulaire du CompteCourant
	 * @param titulaire Le Client titulaire du compte (Objet de type CLient)
	 */ 
	public void setTitulaire(Client titulaire) {
		this.titulaire = titulaire;
	}
	
	
}
