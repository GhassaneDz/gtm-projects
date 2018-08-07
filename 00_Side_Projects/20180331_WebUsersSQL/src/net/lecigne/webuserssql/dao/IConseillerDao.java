package net.lecigne.webuserssql.dao;

import net.lecigne.webuserssql.model.Conseiller;

/**
 * Cette interface d�crit les op�rations g�n�rales li�es � la persistance des
 * donn�es (CRUD - Create, Read, Update, Delete) pour les objets conseillers.
 *
 * @author Anthony Le Cigne
 *
 */

public interface IConseillerDao {

	// *** CREATION ***

	void creerConseiller(Conseiller conseiller);
	
	// *** OBTENTION ***
	
	Conseiller obtenirConseiller(String login);
	
}
