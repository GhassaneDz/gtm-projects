package fr.proxibanque.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import fr.proxibanque.model.*;
import fr.proxibanque.persistance.*;

/**
 * Cette classe impl�mente l'interface ConseillerService. Elle fournit les
 * m�thodes permettant aux conseillers d'effectuer les op�rations n�cessaires �
 * l'activit� de ProxiBanque (gestion des clients, des comptes, des cartes, et
 * op�rations diverses).
 * 
 * @author Joumard S�bastien, Le Cigne Anthony
 *
 */

public class ConseillerServiceImp implements ConseillerService {

	private ClientDAO dao = new MemClientDAO();

	// *** HELPER METHODS ***

	/**
	 * Permet de g�n�rer une cha�ne de caract�res compos�e de 8 chiffres al�atoires,
	 * utilis�e comme num�ro de compte et/ou de num�ro de carte.
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
	public String creerClient(Conseiller cons, Client c) {
		String idRetour = "";
		// TODO Inverser le test pour entrer dans l'erreur avant de cr�er le client
		// Ceci n'a pas pu �tre fait car cela modifiait l'un de nos tests unitaires.
		if (cons.getListeClients().size() < 10) {

			if (c != null) {
				c.setCompteCourant(creerCompteCourant());
				idRetour = dao.sauvegarder(c);
				cons.getListeClients().add(idRetour);
			} else {
				System.err.println("Client invalide !");
			}

		} else {
			System.err.println("Nombre max de client atteint !");
		}
		return idRetour;
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
	public void supprimerClient(Conseiller cons, String id) {
		dao.supprimer(id);
		cons.getListeClients().remove(id);
	}

	@Override
	public List<Client> obtenirListeClients() {
		return dao.obtenirTous();
	}

	// *** GESTION COMPTES ***

	@Override
	public void assignerCompteEpargne(Client c) {
		String numeroCompte = genererNumero();
		String dateCreation = genererDateCreation();
		c.setCompteEpargne(new CompteEpargne(numeroCompte, 0.0, dateCreation));
	}

	// *** GESTION CARTES ***

	@Override
	public void assignerCarte(Client c, CarteVisa carte) {
		carte.setNumero(genererNumero());
		c.getCompteCourant().setCarte(carte);
	}

	// *** OPERATIONS ***

	@Override
	// TODO corriger impl�mentation - se r�f�rer au m�tier
	public double simulerCredit(double montant, int dureeMois, double taux) {
		return (montant / dureeMois) * taux;
	}

	@Override
	public void faireVirement(Client clientDebit, Client clientCredit, double montant) {
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

	public void crediterCompte(Client client, double montant) {
		double soldeCourant = client.getCompteCourant().getSolde();
		double soldeNouveau = soldeCourant + montant;
		client.getCompteCourant().setSolde(soldeNouveau);
	}

	/**
	 * @param c un client ProxiBanque
	 * @return  un bool�en, vrai si le client ne passe pas l'audit
	 */
	private boolean auditerClient(Client c) {
		return c.getCompteCourant().getSolde() < -5000.0;
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
