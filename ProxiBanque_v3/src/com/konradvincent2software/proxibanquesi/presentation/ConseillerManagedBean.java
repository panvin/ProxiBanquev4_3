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
//	private CompteCourant compteCourant;
//	private CompteEpargne compteEpargne;
	private List<Compte> comptes;

	
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
//	public CompteCourant getCompteCourant() {
//		return compteCourant;
//	}
//	public void setCompteCourant(CompteCourant compteCourant) {
//		this.compteCourant = compteCourant;
//	}
//	public CompteEpargne getCompteEpargne() {
//		return compteEpargne;
//	}
//	public void setCompteEpargne(CompteEpargne compteEpargne) {
//		this.compteEpargne = compteEpargne;
//	}
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	// Autres méthodes
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
	
	public String selectionnerClient(Client client) {
		setClientChoisi(client);
		return "modifier";
	}
	
	public String modifierClient() {
		cls.modifierClient(clientChoisi.getId(), clientChoisi);
		return "acceuil";
	}
	
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
	
	public String deconnexion() {
		return "login";
	}
	
}
