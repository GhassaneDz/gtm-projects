package fr.proxibanque.model;

/**
 * Cette classe d�crit les caract�ristiques d'un client ProxiBanque.
 * 
 * @author Joumard S�bastien, Le Cigne Anthony
 *
 */

public class Client {

	// *** ATTRIBUTES ***

	private String id;
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;
	private CompteCourant compteCourant;
	private CompteEpargne compteEpargne;

	// *** CONSTRUCTORS ***

	public Client(String nom, String prenom, String adresse, String codePostal, String ville, String telephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}

	// *** GETTERS and SETTERS ***

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

	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	// *** OTHER METHODS ***

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
				+ "Nom : " + this.nom + "\n"
				+ "Pr�nom : " + this.prenom + "\n"
				+ "Adresse : " + this.adresse + "\n"
				+ "Code postal : " + this.codePostal + "\n"
				+ "Ville : " + this.ville + "\n"
				+ "T�l�phone : " + this.telephone + "\n"
				+ "Compte courant : " + this.compteCourant + "\n"
				+ "Compte �pargne : " + strEpargne + "\n";
	}

}