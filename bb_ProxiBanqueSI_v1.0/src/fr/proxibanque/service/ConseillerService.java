package fr.proxibanque.service;

import java.util.ArrayList;
import java.util.List;

import fr.proxibanque.model.*;

/**
 * Cette interface recense les op�rations que peuvent effectuer les conseillers
 * bancaires de ProxiBanque.
 * 
 * @author Joumard S�bastien, Le Cigne Anthony
 *
 */

public interface ConseillerService {

	// *** GESTION CLIENTS ***
	
	/**
	 * Permet de cr�er un client dans la base de donn�e ProxiBanque et �galement
	 * d'attribuer ce client au conseiller responsable de la cr�ation du client. La
	 * cr�ation n'est pas effectu�e si le conseiller a d�j� 10 clients � sa charge.
	 * 
	 * @param cons      conseiller proxibanque
	 * @param cli       client proxibanque
	 * @return idRetour id client proxibanque
	 */
	public String creerClient(Conseiller cons, Client cli);
	public void modifierClient(String id, Client c);
	public Client obtenirClient(String id);
	public void supprimerClient(Conseiller cons, String id);
	public List<Client> obtenirListeClients();

	// *** GESTION COMPTES ***
	
	public void assignerCompteEpargne(Client c);
	
	// *** GESTION CARTES ***
	
	public void assignerCarte(Client c, CarteVisa carte);
	
	// *** OPERATIONS ***
	
	public double simulerCredit(double montant, int dureeMois, double taux);
	public void faireVirement(Client cDebit, Client cCredit, double montant);
	public void crediterCompte(Client client, double montant);
	public ArrayList<Client> auditerAgence();
	
}