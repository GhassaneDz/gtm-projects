package net.lecigne.gestionformations.domaine;

/**
 * @author Anthony Le Cigne
 */

public class Employe {

	// *** ATTRIBUTES ***

	private String nom;
	private String prenom;
	private int id;

	// *** CONSTRUCTORS ***

	public Employe(String nom, String prenom, int id) {
		this.nom = nom;
		this.prenom = prenom;
		this.id = id;
	}

	// *** ACCESSORS ***

	public String getNom() {
		return this.nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public int getId() {
		return this.id;
	}
	
	// *** MUTATORS ***

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	// *** OTHER METHODS ***
	
	/**
	 * L'employe demande une formation
	 */

	public void demanderFormation(String theme) {
		System.out.println("L'employ� "
				+ this.prenom 
				+ " " 
				+ this.nom 
				+ " demande une formation sur " 
				+ theme
				+ ".");
	}

	/**
	 * M�thode toString() permet d'avoir l'�tat d'un objet d�s lors qu'on affiche
	 * r�f�rence System.out.println (monObjet);
	 */
	
	@Override
	public String toString() {
		return "Employ� [id="
				+ this.id
				+ ", nom="
				+ this.nom
				+ ", prenom="
				+ this.prenom + "]";
	}

}