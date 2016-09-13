package com.konradvincent2software.proxibanquesi.service.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.konradvincent2software.proxibanquesi.domaine.Conseiller;
import com.konradvincent2software.proxibanquesi.service.AuthService;
import com.konradvincent2software.proxibanquesi.service.ConseillerService;;

public class AuthServiceTest {

	@BeforeClass
	public static void avantTest(){
		Conseiller conseiller = new Conseiller("Robert", "Dupond", "Monsieur", "rdupond", "gtm", null);
		ConseillerService service = new ConseillerService();
		service.creerConseiller(conseiller);
	}
	
	@Test
	public void testAuthConseiller() {
		String login = "rdupond";
		String pwd = "gtm";
		boolean status;

		AuthService servicePourTest = new AuthService();
		status = servicePourTest.authConseiller(login, pwd);

		Assert.assertTrue(status);
	}

	@Test
	public void testAuthConseiller2() {
		String login = "azerty";
		String pwd = "1234";
		boolean status;

		AuthService servicePourTest = new AuthService();
		status = servicePourTest.authConseiller(login, pwd);

		Assert.assertFalse(status);
	}

	@Test
	public void testAuthConseiller3() {
		String login = "rdupond";
		String pwd = "1234";
		boolean status;

		AuthService servicePourTest = new AuthService();
		status = servicePourTest.authConseiller(login, pwd);

		Assert.assertFalse(status);
	}
	
	@AfterClass
	public static void apresClasse(){
		ConseillerService service = new ConseillerService();
		service.supprimerConseiller("rdupond");
	}
}
