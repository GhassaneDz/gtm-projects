package net.lecigne.webusers.service;

import java.util.List;
import net.lecigne.webusers.model.Client;

/**
 * Cette interface recense les op�rations que peuvent effectuer les conseillers
 * bancaires de ProxiBanque.
 * 
 * @author Joumard S�bastien, Le Cigne Anthony
 *
 */

public interface Service {

	// *** GESTION CLIENTS ***

	/**
	 * Permet de cr�er un client dans la base de donn�e ProxiBanque et �galement
	 * d'attribuer ce client au conseiller responsable de la cr�ation du client. La
	 * cr�ation n'est pas effectu�e si le conseiller a d�j� 10 clients � sa charge.
	 * 
	 * @param cons
	 *          conseiller proxibanque
	 * @param cli
	 *          client proxibanque
	 * @return idRetour id client proxibanque
	 */
	public void creerClient(Client cli);

	public void modifierClient(String id, Client c);

	public Client obtenirClient(String id);

	public void supprimerClient(String id);

	public List<Client> obtenirListeClients();

}