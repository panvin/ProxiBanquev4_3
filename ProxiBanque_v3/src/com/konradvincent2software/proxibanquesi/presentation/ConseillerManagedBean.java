package com.konradvincent2software.proxibanquesi.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.konradvincent2software.proxibanquesi.domaine.Client;
import com.konradvincent2software.proxibanquesi.domaine.Compte;
import com.konradvincent2software.proxibanquesi.domaine.Conseiller;
import com.konradvincent2software.proxibanquesi.service.AuthService;
import com.konradvincent2software.proxibanquesi.service.ClientService;
import com.konradvincent2software.proxibanquesi.service.CompteService;
import com.konradvincent2software.proxibanquesi.service.ConseillerService;

//@ManagedBean(name="conseillerManagedBean")
//@SessionScoped
/**
 * Classe associée a la couche présentation ConseillerMangaedBean
 * @author Konrad THOMAS et Vincent PANOUILLERES
 *
 */
public class ConseillerManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	AuthService as = new AuthService();
	ConseillerService cs = new ConseillerService();
	ClientService cls = new ClientService();
	CompteService cms = new CompteService();
	
	// Propriétés
	private String nom;
	private String prenom;
	private String civilite;
	private String login;
	private String password;
	private List<Client> clients;
	private Client clientChoisi;
	private List<Compte> comptes;
	private String numeroCompteADebiter;
	private String numeroCompteACrediter;
	private String montantVirement;
	
	// Constructeurs
	public ConseillerManagedBean() {
		super();
	}
	
	// Getters et Setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCivilite() {
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Client> getClients() {
		return this.clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public Client getClientChoisi() {
		return clientChoisi;
	}
	public void setClientChoisi(Client clientChoisi) {
		this.clientChoisi = clientChoisi;
	}	
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
		public String getNumeroCompteADebiter() {
		return numeroCompteADebiter;
	}
	public void setNumeroCompteADebiter(String numeroCompteADebiter) {
		this.numeroCompteADebiter = numeroCompteADebiter;
	}
	public String getNumeroCompteACrediter() {
		return numeroCompteACrediter;
	}
	public void setNumeroCompteACrediter(String numeroCompteACrediter) {
		this.numeroCompteACrediter = numeroCompteACrediter;
	}
	public String getMontantVirement() {
		return montantVirement;
	}
	public void setMontantVirement(String montantVirement) {
		this.montantVirement = montantVirement;
	}

	// Autres méthodes
	
	
	/**
	 * Méthode pour authentifier un conseiller à partir de son identiant et son mot de passe. 
	 * Si l'authentification réussit, la page acceuil.xhtml avec la liste de clients est affichée, 
	 * sinon la page login.xhtml est renvoyée avec un messaged d'erreur. 
	 */
	public String authentifiaction() {
        if(as.authConseiller(login, password))
        {
        	Conseiller conseiller = cs.lireConseiller(login);
        	setNom(conseiller.getNom());
        	setPrenom(conseiller.getPrenom());
        	setClients(cls.lireClientsParConseiller(login));
            return "acceuil";
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("username", new FacesMessage("Authetifiaction non réussi."));
            return "login";
        }
    }
	
	/**
	 * Méthode qui permet de selectionner un client dans la liste des clients 
	 * et qui renvoye dans la page modifier.xhtml qui permet des changer les données du client.
	 * @param client
	 */
	public String selectionnerClient(Client client) {
		setClientChoisi(client);
		return "modifier";
	}
	
	/**
	 * Méthode qui éffectue la modification des données d'un client dans la base de données renvoyant sur la page acceuil.xhtml.
	 */
	public String modifierClient() {
		cls.modifierClient(clientChoisi.getId(), clientChoisi);
		return "acceuil";
	}
	
	/**
	 * Cette méthode crée la liste des comptes pour un client choisi et renvoye vers la pages comptes.xhtml.
	 */
	public String voirComptes(Client client) {
		setClientChoisi(client);
		Compte compteCourant = client.getCompteCourant();
		Compte compteEpargne = client.getCompteEpargne();
		comptes = new ArrayList<Compte>();
		if(compteCourant != null)
			comptes.add(compteCourant);
		if(compteCourant != null)
			comptes.add(compteEpargne);
		System.out.println(comptes);
		return "comptes";
	}
	
	
	/**
	 * Cette méthode sert à effectuer un virement avec les données qui ont étées entrées dans la page virement.xhtml.
	 * Elle n'est actuellement pas fonctionelle à cause de problèmes d'intégration qui n'ont pas pu être résolus avant la fin du projet.
	 */
	public String effectuerVirement() {
		//System.out.println(numeroCompteACrediter);
		//cms.virementCompteACompte(numeroCompteADebiter, numeroCompteACrediter, Float.parseFloat(montantVirement));
		return "acceuil";
	}
}
