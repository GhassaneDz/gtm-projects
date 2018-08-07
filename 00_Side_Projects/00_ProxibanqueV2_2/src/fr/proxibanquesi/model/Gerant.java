package fr.proxibanquesi.model;

/**
 * Cette classe d�crit les caract�ristiques des g�rants d'agence ProxiBanque.
 * 
 * @author Jean-Michel Hiltbrunner, Anthony Le Cigne
 *
 */

public class Gerant extends Employe {

	// *** CONSTRUCTORS ***
	
	public Gerant(String prenom, String nom, String login, String password) {
		super(prenom, nom, login, password);
	}

}