package com.konradvincent2software.proxibanquesi.service.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Classe permettant de lancer l'ensemble des test unitaire du projet
 * @author Konrad THOMAS et Vincent PANOUILLERES
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ AuthServiceTest.class, ConseillerServiceTest.class })
public class AllTests {

}
