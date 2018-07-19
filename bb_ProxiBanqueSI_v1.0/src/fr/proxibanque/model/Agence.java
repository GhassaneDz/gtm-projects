package fr.proxibanque.model;

/**
 * Une agence ProxiBanque, disposant d'un g�rant unique.
 * 
 * @author Joumard S�bastien, Le Cigne Anthony
 *
 */

public class Agence {

	// *** ATTRIBUTES ***

	private String id;
	private String dateCreation;
	private Gerant gerant;

	// *** CONSTRUCTORS ***

	public Agence(String id, String dateCreation, Gerant gerant) {
		this.id = id;
		this.dateCreation = dateCreation;
		this.gerant = gerant;
	}

	public String toString() {
		return "Agence " + id + " cr��e le : " + dateCreation + ", \nG�rant :\n" + gerant.toString();
	}

}