package com.konradvincent2software.proxibanquesi.presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.konradvincent2software.proxibanquesi.domaine.Client;

//@ManagedBean(name="conseillerManagedBean")
//@SessionScoped
public class ConseillerManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
//	@Inject
//	ConseillerService service;
	
	// Propriétés
	private String nom;
	private String prenom;
	private String civilite;
	private String login;
	private String password;
	private List<Client> clients;
	
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
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	// Autres méthodes
	public String login()
    {
        if("test".equalsIgnoreCase(getLogin()) && "test".equals(getPassword()))
        {
            return "acceuil";
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("username", new FacesMessage("Invalid UserName and Password"));
            return "login";
        }
    }
	
}
