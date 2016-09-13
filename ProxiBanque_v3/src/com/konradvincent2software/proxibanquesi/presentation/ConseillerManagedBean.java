package com.konradvincent2software.proxibanquesi.presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.konradvincent2software.proxibanquesi.domaine.Client;
import com.konradvincent2software.proxibanquesi.domaine.Conseiller;
import com.konradvincent2software.proxibanquesi.service.AuthService;
import com.konradvincent2software.proxibanquesi.service.ClientService;
import com.konradvincent2software.proxibanquesi.service.ConseillerService;

//@ManagedBean(name="conseillerManagedBean")
//@SessionScoped
public class ConseillerManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	AuthService as = new AuthService();
	ConseillerService cs = new ConseillerService();
	ClientService cls = new ClientService();
	
	// Propriétés
	private String nom;
	private String prenom;
	private String civilite;
	private String login;
	private String password;
	private List<Client> clients;
	private Client clientChoisi;
	
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
	
//	public void onUserSelect(SelectEvent event){ 
//    	this.clientChoisi =  (Client)event.getObject();
//    	System.out.println("Client choisi : " + clientChoisi.toString());
//    }
	
	public String selectionnerClient(Client client) {
		setClientChoisi(client);
		return "modifier";
	}
	
	public String modifierClient() {
//		System.out.println(clientChoisi.toString());
		cls.modifierClient(clientChoisi.getId(), clientChoisi);
//		setClients(cls.lireClientsParConseiller(login));
		return "acceuil";
	}
	
}
