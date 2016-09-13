package com.konradvincent2software.proxibanquesi.service.test;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.konradvincent2software.proxibanquesi.domaine.Client;
import com.konradvincent2software.proxibanquesi.domaine.Conseiller;
import com.konradvincent2software.proxibanquesi.service.ClientService;

public class ClientServiceTest {
	
	private static Client clientTest, clientTest2;
	private static Conseiller conseillerTest;
	private static ClientService clientService;
	
	@BeforeClass
	public static void avantClasse(){
		
		conseillerTest = new Conseiller("responsable", "antoine", "monsieur", "login", "password");
		clientTest = new Client("dupond", "toto", "monsieur", "asez@fr.com", "120 rue factice", "Lyon", "0102030405", "69003", 150, conseillerTest, null, null);
		clientTest2 = new Client("dupond", "soso", "madame", "asez@fr.com", "120 rue factice", "Lyon", "0102030405", "69003", 151, conseillerTest, null, null);
		clientService = new ClientService();
		clientService.creerClient(clientTest2);
	}

	@Test
	public void testCreerClient() {
		
		boolean status;
		status = clientService.creerClient(clientTest);
		Assert.assertTrue(status);
	}
	
	@Test
	public void testLireClient() {
		
		Client testClient;
		testClient = clientService.lireClient(151);
		Assert.assertNotNull(testClient);
	}
	
	@Test
	public void testModificationClient() {
		
		boolean status; 
		status = clientService.modifierClient(150, clientTest);
		Assert.assertTrue(status);
	}

	@Test
	public void testSuppressionClient() {
		
		boolean status = clientService.suppressionClient(clientTest.getId());
		Assert.assertTrue(status);
		
	}

	@Test
	public void testLireTousLesCLients() {
		
		ArrayList<Client> listeClient;
		listeClient = clientService.lireTousLesCLients();
		Assert.assertNotNull(listeClient);
	}
	
	@AfterClass
	public static void apresClasse(){
		clientService.suppressionClient(clientTest2.getId());		
	}
}
