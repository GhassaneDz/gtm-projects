package fr.proxibanque.modele;

/**
 * Cette classe d�crit les caract�ristiques d'un client ProxiBanque.
 * 
 * @author Anthony Le Cigne
 *
 */

public class Client {

	// *** ATTRIBUTS ***

	private String id; // G�n�r� automatiquement par la couche DAO
	private String prenom;
	private String nom;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;
	private CompteCourant compteCourant; // G�n�r� automatiquement par la couche service
	private CompteEpargne compteEpargne; // Attribu� plus tard au besoin par la couche service

	// *** CONSTRUCTEURS ***

	public Client(String prenom, String nom, String adresse, String codePostal,
			String ville, String telephone) {
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}

	// *** ACCESSEURS et MUTATEURS ***
	// TODO Supprimer les m�thodes inutilis�es

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	// TODO � supprimer
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}
	
	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	// *** AUTRES METHODES ***

	@Override
	public String toString() {
		String strEpargne = new String();

		// Cha�ne de caract�re par d�faut si pas de compte �pargne
		if (this.compteEpargne != null) {
			strEpargne = this.compteEpargne.toString();
		} else {
			strEpargne = "pas de compte �pargne associ�e au client";
		}
				
		return  "\n=== CLIENT ===\n"
				+ "ID client : " + this.id + "\n"
				+ "Pr�nom : " + this.prenom + "\n"
				+ "Nom : " + this.nom + "\n"
				+ "Adresse : " + this.adresse + "\n"
				+ "Code postal : " + this.codePostal + "\n"
				+ "Ville : " + this.ville + "\n"
				+ "T�l�phone : " + this.telephone + "\n"
				+ "Compte courant : " + this.compteCourant + "\n"
				+ "Compte �pargne : " + strEpargne + "\n";
	}

}
