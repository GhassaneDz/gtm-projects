package net.lecigne.webuserssql.dao;

import java.sql.*;

/**
 * Cette classe abstraite impl�mente enti�rement les m�thodes n�cessaires au bon
 * d�roulement d'une interaction (connexion, d�connexion) entre :
 * 
 * - une classe concr�te de DAO utilisant JDBC<br>
 * - une base de donn�es SQL.
 * 
 * Se r�f�rer aux classes concr�tes de la pr�sente couche DAO pour des exemples
 * d'extension de cette classe.
 * 
 * @author Anthony Le Cigne
 *
 */

public abstract class DaoJDBC {

	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/proxibanque";
	private static final String login = "root";
	private static final String password = "";

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection cnx = null;
		Class.forName(driver);
		cnx = DriverManager.getConnection(url, login, password);
		return cnx;
	}

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
