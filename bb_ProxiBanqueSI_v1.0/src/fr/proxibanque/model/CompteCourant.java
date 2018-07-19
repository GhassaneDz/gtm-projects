package fr.proxibanque.model;

/**
 * Cette classe d�crit les caract�ristiques d'un compte courant ProxiBanque.
 * Chaque client dispose d'un compte courant g�n�r� automatiquement � la
 * cr�ation client. Une carte bancaire peut �tre associ�e � un compte courant
 * par un conseiller ProxiBanque.
 * 
 * @author Joumard S�bastien, Le Cigne Anthony
 *
 */

public class CompteCourant extends Compte {

	// *** ATTRIBUTES ***
	
	private CarteVisa carte;
	public static final double DECOUVERT_MAX = -1000.0;

	// *** CONSTRUCTORS ***
	
	public CompteCourant(String numero, double solde, String dateOuverture) {
		// Le compte courant est cr�� sans carte bancaire par d�faut
		super(numero, solde, dateOuverture);
	}

	// *** GETTERS and SETTERS ***
	
	public void setCarte(CarteVisa carte) {
		this.carte = carte;
	}

	// *** OTHER METHODS ***
	
	@Override
	public String toString() {
		String strCarte = new String();

		// cha�ne de caract�re par d�faut si pas de carte associ�e au compte courant
		if (this.carte != null) {
			strCarte = this.carte.toString();
		} else {
			strCarte = "pas de carte associ�e au compte";
		}

		return super.toString() // exemple : N� = 141951579, solde = 0.0, date ouv. = 2018-03-16
				+ "\n" + "=> Carte du compte courant : " + strCarte;
	}

}
