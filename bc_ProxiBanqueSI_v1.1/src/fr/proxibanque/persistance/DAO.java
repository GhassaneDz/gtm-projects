package fr.proxibanque.persistance;

import java.util.List;

/**
 * Cette interface g�n�rique d�crit les op�rations g�n�rales li�es � la
 * persistance des donn�es (CRUD - Create, Read, Update, Delete) pour un objet
 * de type T dot� d'un attribut d'identification ID.
 *
 * @author Anthony Le Cigne
 *
 */

public interface DAO<T> {

	// *** SAUVEGARDE ***
	
	String sauvegarder(T t);
	
	// *** LECTURE ***
	
	T obtenir(String id);
	List<T> obtenirTous();
	
	// *** MODIFICATION ***
	
	void modifier(String id, T t);
	
	// *** SUPPRESSION ***
	
	void supprimer(String id);

}