package net.lecigne.webuserssql.dao;

import java.util.List;
import net.lecigne.webuserssql.model.Client;

/**
 * Cette interface d�crit les op�rations g�n�rales li�es � la persistance des
 * donn�es (CRUD - Create, Read, Update, Delete) pour les objets client.
 *
 * @author Anthony Le Cigne
 *
 */
public interface ClientDao {

	// *** CREATION ***

	void creerClient(Client client);

	// *** LECTURE ***

	Client obtenirClient(int id);

	List<Client> obtenirTousClients();

	// *** MODIFICATION ***

	void modifierClient(int id);

	// *** SUPPRESSION ***

	void supprimerClient(int id);

}
