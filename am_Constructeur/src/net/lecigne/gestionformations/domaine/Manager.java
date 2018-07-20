package net.lecigne.gestionformations.domaine;

/**
 * @author Anthony Le Cigne
 */

public class Manager extends Employe {

	/**
	 * Constructeur de la classe Manager, cr�� � partir du constructeur de la classe
	 * Employ�.
	 * 
	 * @param nom
	 * @param prenom
	 * @param id
	 */

	public Manager(String nom, String prenom, int id) {
		super(nom, prenom, id);
	}

	/**
	 * Le manager peut valider les demandes de formation de ses employ�s.
	 */
	
	public void validerFormation() {
		System.out.println("Le manager " 
				+ this.getPrenom()
				+ " " 
				+ this.getNom()
				+ " valide les demandes de formation de ses employ�s.");
	}

}
