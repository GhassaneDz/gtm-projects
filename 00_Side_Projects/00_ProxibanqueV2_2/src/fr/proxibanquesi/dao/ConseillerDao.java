package fr.proxibanquesi.dao;

import fr.proxibanquesi.model.Conseiller;

/**
 * Cette interface permet de connaitre un conseiller identifi� par son login
 * 
 * @author Anthony le Cigne et Jean-Michel Hiltbrunner
 *
 */
public interface ConseillerDao {

	/**
	 * A partir d'un login renvoie les informations sur le conseiller interrog�
	 * 
	 * @param login
	 *            l'identifiant unique du conseiller
	 * @return le conseiller identifi� par son login
	 */
	Conseiller obtenirConseiller(String login);

}
