package com.konradvincent2software.proxibanquesi.presentation;

import java.io.Serializable;

import com.konradvincent2software.proxibanquesi.domaine.Client;

public class ClientManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String modifierClient(Client client) {
		setId(client.getId());
		return "modifier";
	}
}
