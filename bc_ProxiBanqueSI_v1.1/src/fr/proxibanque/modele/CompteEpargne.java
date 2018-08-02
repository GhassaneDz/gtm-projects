package fr.proxibanque.modele;

/**
 * Cette classe d�crit les caract�ristiques d'un compte �pargne ProxiBanque.
 * Chaque client peut disposer d'un compte �pargne apr�s ajout explicite par un
 * conseiller. Aucune carte bancaire n'est associ�e � un compte �pargne.
 * 
 * @author Anthony Le Cigne
 *
 */

public class CompteEpargne extends Compte {

	// *** ATTRIBUTS ***
	
	@SuppressWarnings("unused") 		// TODO Le taux n'est pas utilis� dans
	private final double TAUX = 3.0;	// ProxiBanqueSI v1.0
	

	// *** CONSTRUCTEURS ***
	
	public CompteEpargne(String numero, double solde, String dateOuverture) {
		super(numero, solde, dateOuverture);
	}
	
	// *** AUTRES METHODES ***
	
	@Override
	public String toString() {
		return // N� = 141951579, solde = 0.0, date ouv. = 2018-03-16
				super.toString();
	}
}
