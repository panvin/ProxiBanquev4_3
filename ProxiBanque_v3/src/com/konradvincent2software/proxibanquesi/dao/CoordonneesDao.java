package com.clementvincent2software.proxibanquesi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.clementvincent2software.proxibanquesi.domaine.Coordonnees;

public class CoordonneesDao implements ICoordonneesDao {

	/**
	 * Méthode permettant la création en base de coordoonnees pour un client.
	 * @param coordonnees Passe en parametres l'objet coordonnees.
	 * @return Retourne true si la méthode arrive a se dérouler sans erreurs, retourne false sinon
	 */
	public static boolean createCoordonnees(Coordonnees coordonnees, int clientId) {
		// INfomration d'accès à la base de données
		String url = "jdbc:mysql://localhost/ProxiBanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		boolean status = true;

		try {
			// Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Creation d'un statement
			st = cn.createStatement();
			String sql = "INSERT INTO Coordonnees(adresse, ville, telephone, cp, idClient) VALUES ('"
					+ coordonnees.getAdresse() + "','" + coordonnees.getVille() + "','" + coordonnees.getTelephone()
					+ "','" + coordonnees.getCp() + "','" + clientId + "');";
			// Etape 4: Execution requête
			st.executeUpdate(sql);

		} catch (SQLException e) {
			status =false;
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			status = false;
			e.printStackTrace();
		} finally {
			try {
				// Etape 5 : liberer une ressource de la memoire
				cn.close();
				st.close();

			} catch (SQLException e) {
				status = false;
				e.printStackTrace();
			}
		}
		return status;
	}

	
	/**
	 * Méthode permettant de récupérer les coordonnees d'un client en base à partir de l'identifiant client.
	 * 
	 * @param idClient L'identifiant unique du client.
	 * @return Retourne l'objet coordonnees correspondant à l'id client.
	 */
	public static Coordonnees readCoordonneesByIdClient(int idClient) {
		// INformation d'acces à la base de donnees
		String url = "jdbc:mysql://localhost/ProxiBanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Coordonnees coordonnees = null;
		String adresseClient, villeClient, telephoneClient, cpClient;

		try {
			// Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM coordonnees WHERE idClient='" + idClient + "';";
			// Etape 4: Execution requête
			rs = st.executeQuery(sql);
			// Etape 5 : Parcours de resultset
			while (rs.next()) {
				adresseClient = rs.getString("adresse");
				villeClient = rs.getString("ville");
				telephoneClient = rs.getString("telephone");
				cpClient = rs.getString("cp");
				coordonnees = new Coordonnees(adresseClient, villeClient, telephoneClient, cpClient);
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
		return coordonnees;
	}

	/**
	 * Méthode permettant de mettre à jour en base les coordonnees d'un lcient à partir de son identifiant.
	 * @param idClient L'identifiant unique du client.
	 * @param newCoordonnees Les coordonnees client à jour.
	 * @return Retourne true si la méthode arrive a se dérouler sans erreurs, retourne false sinon.
	 */
	public static boolean updateCoordonneesByClientId(int idClient, Coordonnees newCoordonnees) {
		// INformation d'acces à la base de donnees
		String url = "jdbc:mysql://localhost/ProxiBanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		boolean status = true;

		try {
			// Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Creation d'un statement
			st = cn.createStatement();
			String sql = "UPDATE coordonnees SET ville = '" + newCoordonnees.getVille() + "', telephone = '"
					+ newCoordonnees.getTelephone() + "', cp = '" + newCoordonnees.getCp() + "', adresse = '"
					+ newCoordonnees.getAdresse() + "' WHERE idClient='" + idClient + "';";
			// Etape 4: Execution requête
			st.executeUpdate(sql);
		} catch (SQLException e) {
			status = false;
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			status = false;
			e.printStackTrace();
		} finally {
			try {
				// Etape 6 : liberer ressources de la memoire.
				cn.close();
				st.close();

			} catch (SQLException e) {
				status = false;
				e.printStackTrace();
			}
		}
		return status;
	}

	/**
	 * Méthode permettant de supprimer en base les coordonnes d'un client à partir de son identifiant unique
	 * @param idClient L'identifiant unique du client dont on souhaite supprimer les coordonnees
	 * @return Retourne true si la méthode arrive a se dérouler sans erreurs, retourne false sinon
	 */
	public static boolean deleteCoordonneesByClientId(int idClient) {
		// INformation d'acces à la base de donnees
		String url = "jdbc:mysql://localhost/ProxiBanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		boolean status = true;

		try {
			// Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Creation d'un statement
			st = cn.createStatement();
			String sql = "DELETE FROM coordonnees WHERE idClient ='" + idClient + "';";
			// Etape 4: Execution requête
			st.executeUpdate(sql);
		} catch (SQLException e) {
			status = false;
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			status = false;
			e.printStackTrace();
		} finally {
			try {
				// Etape 5 : liberer ressources de la memoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				status = false;
				e.printStackTrace();
			}
		}
		return status;
	}
}
