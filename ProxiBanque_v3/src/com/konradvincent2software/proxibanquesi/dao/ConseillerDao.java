package com.konradvincent2software.proxibanquesi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.konradvincent2software.proxibanquesi.domaine.Conseiller;

/**
 * Classe ConseillerDao, permet la gestion des Conseillers en base
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class ConseillerDao implements IConseillerDao {
	
	/**
	 * Méthode permettant la création en base d'un nouveau conseiller en base
	 * @param conseiller
	 */
	public void createConseiller(Conseiller conseiller) {
		// INfomration d'accès à la base de données
		String url = "jdbc:mysql://localhost/ProxiBanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;

		try {
			// Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Creation d'un statement
			st = cn.createStatement();
			String sql = "INSERT INTO Conseiller(nom, prenom, civilite, login, password) VALUES ('" + conseiller.getNom() + "','" + conseiller.getPrenom() + "','" + conseiller.getCivilite() + "','" + conseiller.getLogin() + "','" + conseiller.getPassword() + "');";
			// Etape 4: Execution requête
			st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// Etape 5 : liberer une ressource de la memoire
				cn.close();
				st.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Méthode permettant de récupérer les informations en base d'un conseiller à partir de son login
	 * @param loginInit Login du conseiller
	 * @return conseiller
	 */
	public Conseiller readConseillerByLogin(String loginInit) {
		// INformation d'acces à la base de donnees
		String url = "jdbc:mysql://localhost/ProxiBanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Conseiller conseiller = null;
		String nomConseiller, prenomConseiller, civiliteConseiller, loginConseiller, passwordConseiller;
		
	
		try {
			// Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM conseiller WHERE login='"+loginInit+"';";
			// Etape 4: Execution requête
			rs = st.executeQuery(sql);
			// Etape 5 : Parcours de resultset
			while (rs.next()) {
				nomConseiller = rs.getString("nom");
				prenomConseiller = rs.getString("prenom");
				civiliteConseiller = rs.getString("civilite");
				loginConseiller = rs.getString("login");
				passwordConseiller = rs.getString("password");
				conseiller = new Conseiller(nomConseiller, prenomConseiller, civiliteConseiller, loginConseiller, passwordConseiller);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// Etape 6 : liberer ressources de la memoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conseiller;
	}

	/**
	 * Méthode permettant de mettre à jour en base un conseiller à partir de son login
	 * @param loginInit  Login du conseiller
	 * @param newConseiller Objet Conseiller contenant les nouvelles informations
	 */
	public void updateConseillerByLogin(String loginInit, Conseiller newConseiller){
		// INformation d'acces à la base de donnees
		String url = "jdbc:mysql://localhost/ProxiBanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;

		try {
			// Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Creation d'un statement
			st = cn.createStatement();
			String sql = "UPDATE Conseiller SET nom = '" + newConseiller.getNom() + "', prenom = '" + newConseiller.getPrenom() + "', civilite = '" + newConseiller.getCivilite() + "', login = '" + newConseiller.getLogin() + "', password = '" + newConseiller.getPassword() + "' WHERE login='"+loginInit+ "';";
			// Etape 4: Execution requête
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// Etape 6 : liberer ressources de la memoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * Méthode permettant de supprimer en base un conseiller à partir de son login
	 * @param loginInit Login du conseiller
	 */
	public void deleteConseillerByLogin(String loginInit){
		// INformation d'acces à la base de donnees
		String url = "jdbc:mysql://localhost/ProxiBanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;

		try {
			// Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Creation d'un statement
			st = cn.createStatement();
			String sql = "DELETE FROM Conseiller WHERE login ='"+loginInit+"';";
			// Etape 4: Execution requête
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				// Etape 5 : liberer ressources de la memoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}