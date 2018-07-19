package fr.proxibanque.model;

/**
 * Cette classe abstraite factorise les caract�ristiques des employ�s
 * ProxiBanque (conseillers et g�rants).
 * 
 * @author Joumard S�bastien, Le Cigne Anthony
 *
 */

public abstract class Employe {

	// *** ATTRIBUTES ***

	private String id;
	private String prenom;
	private String nom;

	// *** CONSTRUCTORS ***

	public Employe(String id, String prenom, String nom) {
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
	}

	// *** OTHER METHODS ***

	@Override
	public String toString() {
			
		return "ID employ� : " + this.id + "\n"
				+ "Nom : " + this.nom + "\n"
				+ "Pr�nom : " + this.prenom + "\n";
	}
	
}
