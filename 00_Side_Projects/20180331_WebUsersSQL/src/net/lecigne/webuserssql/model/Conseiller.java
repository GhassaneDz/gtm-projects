package net.lecigne.webuserssql.model;

/**
 * Cette classe d�crit les caract�ristiques des conseillers ProxiBanque.
 * 
 * @author Anthony Le Cigne
 *
 */

public class Conseiller extends Employe {

	// *** CONSTRUCTEUR(S) ***

	public Conseiller(String password, String nom, String prenom) {
		super(password, nom, prenom);
	}

	// *** GETTERS et SETTERS ***
	// H�rit�s

	// *** OTHER METHODS ***

	@Override
	public String toString() {
		return "Conseiller " + super.toString();
	}

}