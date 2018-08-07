package net.lecigne.clientservrestsql.dao;

import java.util.List;

import net.lecigne.clientservrestsql.model.Client;

public interface ClientDao {

	void creerClient(Client client);
	
	Client obtenirClient(long idClient);
	
	void modifierClient(Client client);
	
	/**
	 * Supprimer un client. On passe un id plut�t qu'un objet afin d'all�ger les transferts.
	 * 
	 * @param idClient
	 */
	void supprimerClient(long idClient);
	
	List<Client> obtenirTousClients();
	
	//test git pour tester :)
	
}

// Ceci est une modif d'Anthony
