package fr.proxibanquesi.service;

import java.util.List;

import fr.proxibanquesi.model.*;

/**
 * Cette interface regroupe les services m�tiers de l'agence proxibanque. Elle
 * regroupe toutes les op�rations bancaires classiques.
 * 
 * @author Anthony le Cigne et Jean-Michel Hiltbrunner
 *
 */
public interface PBService {

	// *** CLIENTS ***

	// Cr�ation

	/**
	 * Cr�� un client et le persiste dans la base de donn�es Clients
	 * 
	 * @param client
	 *            Client � ajouter dans la base de donn�es
	 */
	void creerClient(Client client);

	// Lecture

	/**
	 * Donner les caract�ristiques du client � partir de sont identifiant
	 * 
	 * @param idClient
	 *            Identifiant uniuqye du client
	 * @return Client identifi� par son um�ro
	 */
	Client obtenirClient(int idClient);

	/**
	 * Donne l'ensemble des clients de l'agence Proxibanque pr�sent dans la base de
	 * donn�es clients
	 * 
	 * @return ArrayList de l'ensemble des clients
	 */
	List<Client> obtenirListeClients();

	// Modification

	/**
	 * Permet de modifier les caract�ristiques d'un client pr�sent dans la base de
	 * donn�es
	 * 
	 * @param idClient
	 *            Identifiant unique du client
	 * @param client
	 *            Client associ� � son identifiant
	 */
	void modifierClient(int idClient, Client client);

	// Supression

	/**
	 * Supprime un client, ses comptes et cartes des bases de donn�es Proxibanque
	 * 
	 * @param idClient
	 *            Identifiant unique du client � supprimer
	 */
	void supprimerClient(int idClient);

	// *** COMPTES ***

	// Ajout de comptes

	/**
	 * Ajout d'un compte courant � un client pr�sent dans l'agence
	 * 
	 * @param idClient
	 *            Identifiant unique du client
	 */
	void associerCompteCourant(int idClient);

	/**
	 * Ajout d'un compte �pargne � un client pr�sent dans l'agence
	 * 
	 * @param idClient
	 *            Identifiant unique du client
	 */
	void associerCompteEpargne(int idClient);

	// Obtentions de comptes

	/**
	 * R�cup�rer le compte courant d�tenu par un client identifi� dans l'agence
	 * 
	 * @param idClient
	 *            Identifiant unique du client
	 * @return Compte courant associ� au client
	 */
	CompteCourant obtenirCompteCourant(int idClient);

	/**
	 * R�cup�rer le compte �pargne d�tenu par le client identifi� dans l'agence
	 * 
	 * @param idClient
	 *            Identifiant unique du client
	 * @return Compte �pargne associ�
	 */
	CompteEpargne obtenirCompteEpargne(int idClient);

	// *** OPERATIONS ***

	/**
	 * Permet de simuler un cr�dit � la consommation connaissant la dur�e et le
	 * montant souhait� par le client. Le taux est � la discr�tion du conseiller.
	 * Source : https://www.ilemaths.net/calcul-credit.php
	 * 
	 * @param montant
	 *            Somme souhait�e par le client
	 * @param dureeMois
	 *            Dur�e esp�r�e du cr�dit
	 * @param taux
	 *            Taux d'int�ret du cr�dit (compris entre 0 et 100)
	 * @return Mensualit� du cr�dit
	 */
	public double simulerCredit(double montant, int dureeMois, double taux);

	/**
	 * Cette m�thode permet de r�aliser un virement d'argent entre deux comptes
	 * bancaires. Le virement est possible si le solde r�sultant n'atteint pas le
	 * montant du d�couvert autoris�
	 * 
	 * @param idClientSrc
	 *            Identifiant unique du premier client dont on souhaite d�biter le
	 *            compte
	 * @param idClientDest
	 *            Identifiant unique du second client dont on souhaite cr�diter le
	 *            compte
	 * @param montant
	 *            Somme d'argent transf�r�e pendant le virement (d�cimales
	 *            autoris�es)
	 */

	public void faireVirement(int idClientSrc, int idClientDest, double montant);

	// *** CONSEILLERS ***

	// Lecture

	/**
	 * Identifie un conseiller � partir de son login unique
	 * 
	 * @param login
	 *            Identifiant du conseiller
	 * @return Conseiller de l'agence
	 */
	Conseiller obtenirConseiller(String login);

}
