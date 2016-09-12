package com.konradvincent2software.proxibanquesi.service.test;

import org.junit.Assert;
import org.junit.Test;

import com.konradvincent2software.proxibanquesi.service.AuthService;;

public class AuthServiceTest {

	@Test
	public void testAuthConseiller() {
		String login = "ccastro";
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
		String login = "ccastro";
		String pwd = "1234";
		boolean status;

		AuthService servicePourTest = new AuthService();
		status = servicePourTest.authConseiller(login, pwd);

		Assert.assertFalse(status);
	}
}
