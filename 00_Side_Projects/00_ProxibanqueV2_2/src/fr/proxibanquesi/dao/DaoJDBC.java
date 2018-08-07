package fr.proxibanquesi.dao;

import java.sql.*;

/**
 * Cette classe abstraite permet d'�tablir une connexion et une d�connexion � la
 * base de donn�es MySQL locale avec les Drivers et l'url n�cessaire pour
 * atteindre les bases de donn�es
 * 
 * @author Anthony le Cigne et Jean-Michel Hiltbrunner
 *
 */
public abstract class DaoJDBC {

	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/proxibanquesi";
	private static final String login = "root";
	private static final String password = "";

	/**
	 * Ouvre une connexion � la base de donn�es sdont l'url est sp�cifi�e dans le
	 * String url
	 * 
	 * @return Une connection � la base de donn�es
	 * @throws ClassNotFoundException
	 *             Si le driver charg� n'est pas impl�ment� ou n'existe pas �
	 *             l'adresse mentionn�e
	 * @throws SQLException
	 *             si une erreur SQL est point�e lors de la connexion � la base de
	 *             donn�es
	 */
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection cnx = null;
		Class.forName(driver);
		cnx = DriverManager.getConnection(url, login, password);
		return cnx;
	}

	/**
	 * Cette m�thode permet de lib�rer les ressources syst�mes en fermant connexion
	 * � la BDD, les requ�tes SQL et les r�sultats des requ�tes SQL.
	 * 
	 * @param cnx
	 *            Connexion � la base de donn�es MySQL
	 * @param pstmt
	 *            Statements utilis�s pour r�aliser les requ�tes SQL
	 * @param rs
	 *            Tableau des r�sultats des requ�tes SQL
	 */
	public void closeConnection(Connection cnx, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (cnx != null) {
				cnx.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
