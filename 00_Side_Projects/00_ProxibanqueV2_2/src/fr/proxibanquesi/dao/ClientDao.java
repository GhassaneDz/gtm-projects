package fr.proxibanquesi.dao;

import java.util.List;
import fr.proxibanquesi.model.Client;

/**
 * Cette interface permet de r�alser les op�rations du CRUD Cot� client
 * 
 * @author Anthony le Cigne et Jean-Michel Hiltbrunner
 *
 */
public interface ClientDao {

	// *** CREATION ***

	/**
	 * Cr�er un client � partir du constructeur Client et le persister dans la Base
	 * de donn�es
	 * 
	 * @param client
	 *            Client � ajouter dans la base de donn�es
	 */
	void creerClient(Client client);

	// *** LECTURE ***

	/**
	 * Obtenir les informations du Client reconnu � partir de son identifiant unique
	 * 
	 * @param idClient
	 *            Identifiant unique du client
	 * @return le Client identifi� dans la base de donn�es
	 */
	Client obtenirClient(int idClient);

	/**
	 * Permet d'obtenir la liste de tous les clients de l'agence Proxibanque
	 * 
	 * @return ArrayList de tous les clients
	 */
	List<Client> obtenirTousClients();

	// *** MODIFICATION ***

	/**
	 * R�alise la modification des donn�es basiques du client (nom, pr�nom... �
	 * partir du formulaire web)
	 * 
	 * @param idClient
	 *            Identifiant unique du client � modifier
	 * @param client
	 *            le Client identifi� dans la base de donn�es
	 */
	void modifierClient(int idClient, Client client);

	// *** SUPPRESSION ***

	/**
	 * Supprime un client de la base de donn�es, sa suppression entraine par cascade
	 * la suppression de ses comptes et de ses cartes associ�es.
	 * Cette suppression par cascade, dans cette version, est g�r�e par la base SQL.
	 * 
	 * @param idClient
	 *            Identifiant unique du client � supprimer
	 */
	void supprimerClient(int idClient);

}
