package fr.proxibanque.service;

import java.text.SimpleDateFormat;
import java.util.*;
import fr.proxibanque.modele.*;
import fr.proxibanque.persistance.*;

/**
 * Cette classe impl�mente l'interface ConseillerService. Elle fournit les
 * m�thodes permettant aux conseillers d'effectuer les op�rations n�cessaires �
 * l'activit� de ProxiBanque (gestion des clients, des comptes, des cartes, et
 * op�rations diverses).
 * 
 * @author Anthony Le Cigne
 *
 */

public class ProxiBanqueServiceImp implements ProxiBanqueService {

	private DAO<Client> dao = new MemClientDAO();

	// *** HELPER METHODS ***

	/**
	 * Permet de g�n�rer une cha�ne de caract�res compos�e de 8 chiffres
	 * al�atoires, utilis�e comme num�ro de compte et/ou de num�ro de carte.
	 * 
	 * @return str cha�ne de caract�res � chiffres al�atoire
	 */
	private String genererNumero() {
		String str = "";
		int randomNumber = (int) (Math.random() * 1_000_000_000);
		str = str + String.format("%09d", randomNumber);
		return str;
	}

	/**
	 * Permet de g�n�rer la date de cr�ation d'un compte au format yyyy-MM-dd.
	 * 
	 * @return date de type cha�ne de caract�re
	 */
	private String genererDateCreation() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		return sdfDate.format(now);
	}

	private CompteCourant creerCompteCourant() {
		String numeroCompte = genererNumero();
		String dateCreation = genererDateCreation();
		return new CompteCourant(numeroCompte, 0.0, dateCreation);
	}

	// *** GESTION CLIENTS ***

	@Override
	public String creerClient(Client client) {
		String idRetour = "";
		if (client != null) {
			client.setCompteCourant(creerCompteCourant());
			idRetour = dao.sauvegarder(client);
		} else {
			System.err.println("Client invalide !");
		}

		return idRetour;
	}

	@Override
	// TODO R�attribution du compte courant et du compte �pargne... propre ?
	// La r�attribution de l'ID est g�r�e par la couche DAO
	public void modifierClient(String id, Client nouveauClient) {
		Client ancienClient = dao.obtenir(id);
		CompteCourant compteCourant = ancienClient.getCompteCourant();
		CompteEpargne compteEpargne = ancienClient.getCompteEpargne();
		nouveauClient.setCompteCourant(compteCourant);
		nouveauClient.setCompteEpargne(compteEpargne);
		dao.modifier(id, nouveauClient);
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

	// *** GESTION COMPTES ***

	@Override
	public void assignerCompteEpargne(String id) {
		Client client = dao.obtenir(id);
		String numeroCompte = genererNumero();
		String dateCreation = genererDateCreation();
		client.setCompteEpargne(new CompteEpargne(numeroCompte, 0.0, dateCreation));
	}

	// *** GESTION CARTES ***

	@Override
	public void assignerCarte(String id, CarteVisa carte) {
		Client client = dao.obtenir(id);
		carte.setNumero(genererNumero());
		client.getCompteCourant().setCarte(carte);
	}

	// *** OPERATIONS ***

	@Override
	// TODO corriger impl�mentation - se r�f�rer au m�tier
	public double simulerCredit(double montant, int dureeMois, double taux) {
		return (montant / dureeMois) * taux;
	}

	@Override
	public void faireVirement(String idClientDebit, String idClientCredit,
			double montant) {
		Client clientDebit = obtenirClient(idClientDebit);
		Client clientCredit = obtenirClient(idClientCredit);
		CompteCourant compteDebit = clientDebit.getCompteCourant();
		CompteCourant compteCredit = clientCredit.getCompteCourant();
		double soldeDebit = compteDebit.getSolde();
		double soldeCredit = compteCredit.getSolde();

		if (soldeDebit - montant > CompteCourant.DECOUVERT_MAX) {
			compteDebit.setSolde(soldeDebit - montant);
			compteCredit.setSolde(soldeCredit + montant);
		} else {
			System.err.println("D�passement du d�couvert autoris� !");
		}
	}

	public void crediterCompte(String id, double montant) {
		Client client = obtenirClient(id);
		double soldeCourant = client.getCompteCourant().getSolde();
		double soldeNouveau = soldeCourant + montant;
		client.getCompteCourant().setSolde(soldeNouveau);
	}

	/**
	 * @param	client	un client ProxiBanque
	 * @return			un bool�en, vrai si le client ne passe pas l'audit
	 */
	private boolean auditerClient(Client client) {
		return client.getCompteCourant().getSolde() < -5000.0;
	}

	@Override
	public ArrayList<Client> auditerAgence() {
		ArrayList<Client> clients = new ArrayList<>(obtenirListeClients());
		ArrayList<Client> clientsNonRentables = new ArrayList<>();

		for (Client client : clients) {
			if (auditerClient(client)) {
				clientsNonRentables.add(client);
			}
		}

		return clientsNonRentables;
	}

}
