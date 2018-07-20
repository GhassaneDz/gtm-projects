package domaine;

/**
 * @author Anthony Le Cigne
 *
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

	// *** GETTERS and SETTERS ***
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// *** OTHER METHODS ***

	// Demande d'une formation
	public void demanderFormation(String theme) {
		System.out.println("L'employ� "
				+ this.prenom
				+ " "
				+ this.nom 
				+ " demande une formation sur "
				+ theme
				+ ".");
	}

}