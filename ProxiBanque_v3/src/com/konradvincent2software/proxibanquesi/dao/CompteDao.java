package com.konradvincent2software.proxibanquesi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.konradvincent2software.proxibanquesi.domaine.Compte;
import com.konradvincent2software.proxibanquesi.domaine.CompteCourant;
import com.konradvincent2software.proxibanquesi.domaine.CompteEpargne;

/**
 * Classe CompteDao, permet la gestion des Comptes en base
 * 
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class CompteDao {

	/**
	 * Méthode permettant de créer en base un compte.
	 * 
	 * @param compte
	 *            Objet compte lié au compte qu'on souhaite créer. (Objet de type COmpte)
	 * @param typeCompte
	 *            Le type de compte qui va être crée: "Courant" ou "Epargne". (String)
	 * @param idClient
	 *            Identifiant du client titulaire du futur compte. (int)
	 * @return Renvoie true si la méthode se déroule sans probleme, renvoie
	 *         false sinon. (booléen)
	 */
	public boolean createCompte(Compte compte, String typeCompte, int idClient) {
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
			String sql = "INSERT INTO Compte (type, numero, solde, dateouverture, idclient) VALUES ('" + typeCompte
					+ "','" + compte.getNumero() + "','" + compte.getSolde() + "','" + compte.getDateOuverture() + "','"
					+ idClient + "');";
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
	 * Méthode permettant d'obtenir les informations d'un compte à partir de son
	 * numéro.
	 * 
	 * @param numCompte
	 *            Le numéro du compte dont on souhaite obtenir des informations. (String)
	 * @return Retourne l'objet compte à partir du numero de compte specifié en
	 *         parametre de la méthode. (Objet de type Compte)
	 */
	public Compte readCompteByNum(String numCompte) {
		// INformation d'acces à la base de donnees
		String url = "jdbc:mysql://localhost/ProxiBanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Compte compte = null;
		String typeCompte, numeroCompte, dateCompte;
		int idClient;
		float soldeCompte;
		ClientDao clientDao = new ClientDao();

		try {
			// Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM compte WHERE numero='" + numCompte + "';";
			// Etape 4: Execution requête
			rs = st.executeQuery(sql);
			// Etape 5 : Parcours de resultset
			while (rs.next()) {
				typeCompte = rs.getString("type");
				numeroCompte = rs.getString("numero");
				soldeCompte = rs.getFloat("solde");
				idClient = rs.getInt("idClient");
				dateCompte = rs.getString("dateouverture");
				if (typeCompte.equals("epargne")) {
					compte = new CompteEpargne(numeroCompte, soldeCompte, dateCompte,
							clientDao.readClientById(idClient));
				} else
					compte = new CompteCourant(numeroCompte, soldeCompte, dateCompte,
							clientDao.readClientById(idClient));
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
		return compte;
	}

	public ArrayList<Compte> readAllCompte() {
		// INformation d'acces à la base de donnees
		String url = "jdbc:mysql://localhost/ProxiBanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Compte compte = null;
		String typeCompte, numeroCompte, dateCompte;
		int idClient;
		float soldeCompte;
		ArrayList<Compte> ListeCompte = new ArrayList<Compte>();
		ClientDao clientDao = new ClientDao();

		try {
			// Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM compte;";
			// Etape 4: Execution requête
			rs = st.executeQuery(sql);
			// Etape 5 : Parcours de resultset
			while (rs.next()) {
				typeCompte = rs.getString("type");
				numeroCompte = rs.getString("numero");
				soldeCompte = rs.getFloat("solde");
				idClient = rs.getInt("idClient");
				dateCompte = rs.getString("dateouverture");
				if (typeCompte.equals("epargne")) {
					compte = new CompteEpargne(numeroCompte, soldeCompte, dateCompte,
							clientDao.readClientById(idClient));
				} else {
					compte = new CompteCourant(numeroCompte, soldeCompte, dateCompte,
							clientDao.readClientById(idClient));
				}
				ListeCompte.add((Compte) compte);
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
		return ListeCompte;
	}

	/**
	 * Cette methode permet de recuperer un compte à partir de son proprietaire
	 * et du type de compte.
	 * 
	 * @param idClient
	 *            L'identifiant du client. (int)
	 * @param Type
	 *            Le type de compte dont on cherche les informations. (String)
	 * @return Retourne un objet compte contenant les informations recherchées. (Objet de type Compte)
	 */
	public Compte readCompteByClientAndByType(int idClient, String Type) {
		// INformation d'acces à la base de donnees
		String url = "jdbc:mysql://localhost/ProxiBanque";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Compte compte = null;
		String numeroCompte, dateCompte;
		float soldeCompte;
		ClientDao clientDao = new ClientDao();

		try {
			// Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM compte WHERE idClient='" + idClient + "'AND type='" + Type + "';";
			// Etape 4: Execution requête
			rs = st.executeQuery(sql);
			// Etape 5 : Parcours de resultset
			while (rs.next()) {
				numeroCompte = rs.getString("numero");
				soldeCompte = rs.getFloat("solde");
				dateCompte = rs.getString("dateouverture");
				if (Type.equals("Epargne")) {
					compte = new CompteEpargne(numeroCompte, soldeCompte, dateCompte,
							clientDao.readClientById(idClient));
				} else if (Type.equals("Courant")) {
					compte = new CompteCourant(numeroCompte, soldeCompte, dateCompte,
							clientDao.readClientById(idClient));
				} else
					return null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				// Etape 6 : liberer ressources de la memoire.
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return compte;
	}

	/**
	 * Méthode permettant de modifier en base le solde d'un compte à partir du
	 * numéro de compte.
	 * 
	 * @param numCompte
	 *            Le numéro de compte qu'on souhaite mettre à jour. (String)
	 * @param newSolde
	 *            Le nouveau solde du compte à mettre à jour. (float)
	 * @return Renvoie true si la méthode se déroule sans probleme, renvoie
	 *         false sinon. (booléen)
	 */
	public boolean updateCompteByNum(String numCompte, float newSolde) {
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
			String sql = "UPDATE Compte SET solde = '" + newSolde + "' WHERE numero='" + numCompte + "';";
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
	 * Méthode permettant de supprimer en base un compte à partir de son numéro.
	 * 
	 * @param numCompte
	 *            Le numéro du compte à supprimer dans la base de données. (String)
	 * @return Renvoie true si la méthode se déroule sans probleme, renvoie
	 *         false sinon. (booléen)
	 */
	public boolean deleteCompteByNum(String numCompte) {
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
			String sql = "DELETE FROM Compte WHERE numero ='" + numCompte + "';";
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

	/**
	 * Méthode permettant de supprimer en base un compte à partir de
	 * l'identifiant client.
	 * 
	 * @param idClient
	 *            L'identifiant du client dont on souhaite supprimer le ou les
	 *            comptes. (int)
	 * @return Renvoie true si la méthode se déroule sans probleme, renvoie
	 *         false sinon. (booléen)
	 */
	public boolean deleteCompteByIdClient(int idClient) {
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
			String sql = "DELETE FROM Compte WHERE idClient ='" + idClient + "';";
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
