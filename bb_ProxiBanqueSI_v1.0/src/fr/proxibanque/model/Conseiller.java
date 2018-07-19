package fr.proxibanque.model;

import java.util.ArrayList;

/**
 * Cette classe d�crit les caract�ristiques des conseillers ProxiBanque.
 * 
 * @author Joumard S�bastien, Le Cigne Anthony
 *
 */

public class Conseiller extends Employe {

	// *** ATTRIBUTES ***
	
	private ArrayList<String> listeClients = new ArrayList<>();

	// *** CONSTRUCTORS ***
	
	public Conseiller(String id, String prenom, String nom) {
		super(id, prenom, nom);
	}

	// *** GETTERS and SETTERS ***
	
	public ArrayList<String> getListeClients() {
		return listeClients;
	}

	// *** OTHER METHODS ***
	
	@Override
	public String toString() {
		String finalStr = "Clients associ�s %s: %s";
		String idStr = new String(); // liste d'ID clients
		int nbClients = this.listeClients.size();
		
		if (nbClients > 0) {
			for (String id : this.listeClients) {
				idStr += id + " "; // on peuple la cha�ne de caract�res d'ID clients
			}
			finalStr = String.format(finalStr, ("(" + nbClients + ") "), idStr);
		} else {
			finalStr = String.format(finalStr, "", "pas de clients.");
		}
						
		return super.toString() // Exemple : ID, \n, Nom, \n, Pr�nom, \n
				+ finalStr;
	}
	
}