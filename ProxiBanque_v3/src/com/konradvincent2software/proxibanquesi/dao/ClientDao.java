package com.clementvincent2software.proxibanquesi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import com.clementvincent2software.proxibanquesi.domaine.Client;

/**
 * Classe ClientDao, permet la gestion des Clients en base
 * 
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class ClientDao implements IClientDao {

	/**
	 * Méthode permettant la création en base d'un nouveau client en base
	 * 
	 * @param client
	 */
	public static boolean createClient(Client client) {
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
			String sql = "INSERT INTO Client(nom, prenom, civilite, email, id, idconseiller) VALUES ('"
					+ client.getNom() + "','" + client.getPrenom() + "','" + client.getCivilite() + "','"
					+ client.getEmail() + "','" + client.getId() + "','" + client.getMonConseiller().getLogin() + "');";
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
	 * Méthode permettant de récupérer en base les informations de tout les
	 * clients
	 * 
	 * @return collection de Client
	 */
	public static Collection<Client> readAllClient() {
		// INformation d'acces à la base de donnees
		String url = "jdbc:mysql://localhost/ProxiBanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Collection<Client> collection = new ArrayList<Client>();
		String nomClient, prenomClient, civiliteClient;
		int idClient;

		try {
			// Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM client";
			// Etape 4: Execution requête
			rs = st.executeQuery(sql);
			// Etape 5 : Parcours de resultset
			while (rs.next()) {
				nomClient = rs.getString("nom");
				prenomClient = rs.getString("prenom");
				civiliteClient = rs.getString("civilite");
				idClient = rs.getInt("id");
				collection.add(new Client(nomClient, prenomClient, civiliteClient, idClient));
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
		return collection;
	}

	/**
	 * Méthode permettant de récupérer en base la liste des clients d'un
	 * conseiller à partir de son login
	 * 
	 * @param logInit
	 *            login du conseiller
	 * @return Collection de Client
	 */
	public static Collection<Client> readClientByConseiller(String logInit) {
		// INformation d'acces à la base de donnees
		String url = "jdbc:mysql://localhost/ProxiBanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Collection<Client> collection = new ArrayList<Client>();
		String nomClient, prenomClient, civiliteClient;
		int idClient;

		try {
			// Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM client WHERE idConseiller='" + logInit + "';";
			// Etape 4: Execution requête
			rs = st.executeQuery(sql);
			// Etape 5 : Parcours de resultset
			while (rs.next()) {
				nomClient = rs.getString("nom");
				prenomClient = rs.getString("prenom");
				civiliteClient = rs.getString("civilite");
				idClient = rs.getInt("id");
				collection.add(new Client(nomClient, prenomClient, civiliteClient, idClient));
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
		return collection;
	}

	/**
	 * Méthode permettant de récupérer en base les informations d'un Client à
	 * partir de son identifiant
	 * 
	 * @param idInit
	 *            identifiant du client
	 * @return Client
	 */
	public static Client readClientById(int idInit) {
		// INformation d'acces à la base de donnees
		String url = "jdbc:mysql://localhost/ProxiBanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Client client = null;
		String nomClient, prenomClient, civiliteClient;
		int idClient;

		try {
			// Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM client WHERE id='" + idInit + "';";
			// Etape 4: Execution requête
			rs = st.executeQuery(sql);
			// Etape 5 : Parcours de resultset
			while (rs.next()) {
				nomClient = rs.getString("nom");
				prenomClient = rs.getString("prenom");
				civiliteClient = rs.getString("civilite");
				idClient = rs.getInt("id");
				client = new Client(nomClient, prenomClient, civiliteClient, idClient);
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
		return client;
	}

	/**
	 * Méthode permettant de mettre à jour en base un client à partir de son
	 * identifiant
	 * 
	 * @param idInit
	 *            identifiant du Client à mettre à jour
	 * @param newClient
	 *            Objet Client contenant les nouvelles informations
	 */
	public static boolean updateClientById(int idInit, Client newClient) {
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
			String sql = "UPDATE Client SET nom = '" + newClient.getNom() + "', prenom = '" + newClient.getPrenom()
					+ "', civilite = '" + newClient.getCivilite() + "', email = '" + newClient.getEmail()
					+ "' WHERE id='" + idInit + "';";
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
	 * Méthode permettant de supprimer en base un client à partir de son
	 * identifiant
	 * 
	 * @param idInit
	 *            identifiant du client à supprimer
	 */
	public static boolean deleteClientById(int idInit) {
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
			String sql = "DELETE FROM Client WHERE id ='" + idInit + "';";
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
