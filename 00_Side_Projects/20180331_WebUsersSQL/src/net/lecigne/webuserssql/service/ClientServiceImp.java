package net.lecigne.webuserssql.service;

import java.util.List;

import net.lecigne.webuserssql.dao.*;
import net.lecigne.webuserssql.model.Client;

/**
 * Cette classe impl�mente l'interface ClientService. Elle fournit les m�thodes
 * permettant d'effectuer les op�rations n�cessaires � la gestion des clients
 * (cr�ation, lecture, modification, suppression).
 * 
 * @author Joumard S�bastien, Le Cigne Anthony
 *
 */

public class ClientServiceImp implements IClientService {

	private ClientDao dao = new ClientDaoImp();

	@Override
	public void creerClient(Client client) {
		if (client != null) {
			dao.creerClient(client);
		}
	}

	@Override
	public Client obtenirClient(int id) {
		return dao.obtenirClient(id);
	}

	@Override
	public List<Client> obtenirListeClients() {
		return dao.obtenirTousClients();
	}

	@Override
	public void modifierClient(int id) {
		dao.modifierClient(id);
	}

	@Override
	public void supprimerClient(int id) {
		dao.supprimerClient(id);
	}

}
