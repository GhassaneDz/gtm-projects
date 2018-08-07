package net.lecigne.webusers.service;

import java.util.ArrayList;
import java.util.List;

import net.lecigne.webusers.dao.ClientDAO;
import net.lecigne.webusers.dao.MemClientDAO;
import net.lecigne.webusers.model.Client;

/**
 * Cette classe impl�mente l'interface ConseillerService. Elle fournit les
 * m�thodes permettant aux conseillers d'effectuer les op�rations n�cessaires �
 * l'activit� de ProxiBanque (gestion des clients, des comptes, des cartes, et
 * op�rations diverses).
 * 
 * @author Joumard S�bastien, Le Cigne Anthony
 *
 */

public class ServiceImp implements Service {

	private ClientDAO dao = new MemClientDAO();

	@Override
	public void creerClient(Client c) {
		if (c != null) {
			dao.sauvegarder(c);
		}
	}

	@Override
	public void modifierClient(String id, Client c) {
		dao.modifier(id, c);
	}

	@Override
	public Client obtenirClient(String id) {
		return dao.obtenir(id);
	}

	@Override
	public void supprimerClient(String id) {
		dao.supprimer(id);
	}

	@Override
	public List<Client> obtenirListeClients() {
		return dao.obtenirTous();
	}

}
