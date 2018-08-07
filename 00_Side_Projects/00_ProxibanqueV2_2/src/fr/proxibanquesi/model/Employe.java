package fr.proxibanquesi.model;

/**
 * Cette classe abstraite factorise les caract�ristiques des employ�s
 * ProxiBanque (conseillers et g�rants).
 * 
 * @author Jean-Michel Hiltbrunner, Anthony Le Cigne
 *
 */

public abstract class Employe {

	// *** ATTRIBUTES ***

	private int id;
	private String prenom;
	private String nom;
	private String login;
	private String password;

	// *** CONSTRUCTORS ***

	public Employe(String prenom, String nom, String login, String password) {
		this.prenom = prenom;
		this.nom = nom;
		this.login = login;
		this.password = password;
	}

	// *** GETTERS and SETTERS ***

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNom() {
		return nom;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	// *** OTHER METHODS ***

	@Override
	public String toString() {

		return "ID employ� : " + this.id + "\n" + "Nom : " + this.nom + "\n" + "Pr�nom : " + this.prenom + "\n";
	}

}
