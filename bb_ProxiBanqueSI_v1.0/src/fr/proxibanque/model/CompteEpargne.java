package fr.proxibanque.model;

/**
 * Cette classe d�crit les caract�ristiques d'un compte �pargne ProxiBanque.
 * Chaque client peut disposer d'un compte �pargne apr�s ajout explicite par un
 * conseiller. Aucune carte bancaire n'est associ�e � un compte �pargne.
 * 
 * @author Joumard S�bastien, Le Cigne Anthony
 *
 */

public class CompteEpargne extends Compte {

	// *** ATTRIBUTES ***
	
	// TODO Le taux n'est pas utilis� dans ProxiBanqueSI v1
	private final double TAUX = 3.0;

	// *** CONSTRUCTORS ***
	
	public CompteEpargne(String numero, double solde, String dateOuverture) {
		super(numero, solde, dateOuverture);
	}
	
	// *** OTHER METHODS ***
	
	@Override
	public String toString() {
		return super.toString(); // exemple : N� = 141951579, solde = 0.0, date ouv. = 2018-03-16
	}
}
