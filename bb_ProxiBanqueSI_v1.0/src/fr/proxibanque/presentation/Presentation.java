package fr.proxibanque.presentation;

import java.util.ArrayList;
import java.util.Scanner;
import fr.proxibanque.model.*;
import fr.proxibanque.service.*;

/**
 * Cette classe contient des m�thodes li�es � l'interface en ligne de commande
 * de ProxiBanqueSI. Celles-ci sollicitent l'utilisateur afin de d'�crire des
 * informations dans la base de donn�es ProxiBanque.
 * 
 * @author Anthony Le Cigne
 * @version 0.0.1
 *
 */

public class Presentation {

	// Attributs statiques - � affiner
	public static Scanner sc = new Scanner(System.in);
	public static Conseiller conseiller = new Conseiller("C0005", "John", "Doe");
	public static ConseillerService cs = new ConseillerServiceImp();

	// *** HELPERS DE L'INTERFACE ***

	private static Client promptClient() {
		System.out.println("Veuillez saisir les informations client.");
		System.out.println("Nom : ");
		String nom = sc.nextLine();
		System.out.println("Pr�nom : ");
		String prenom = sc.nextLine();
		System.out.println("Adresse : ");
		String adresse = sc.nextLine();
		System.out.println("Code postal : ");
		String codePostal = sc.nextLine();
		System.out.println("Ville : ");
		String ville = sc.nextLine();
		System.out.println("T�l�phone : ");
		String t�l�phone = sc.nextLine();
		return new Client(nom, prenom, adresse, codePostal, ville, t�l�phone);
	}

	private static String promptId(String message) {
		System.out.println(message);
		String id = sc.nextLine();
		return id;
	}

	// *** MENU PRINCIPAL ***

	public static void menuPrincipal() {
		boolean continuer = true;
		while (continuer) {
			int choix;
			System.out.println("=== Bienvenue sur ProxiBanqueSI ===\n");
			System.out.println("1. Gestion clients");
			System.out.println("2. Op�rations bancaires");
			System.out.println("0. D�connexion");
			choix = sc.nextInt();
			sc.nextLine();
			switch (choix) {
			case 1:
				sousMenuClients();
				break;
			case 2:
				sousMenuOperations();
				break;
			// TODO Bug [Normal] Si plusieurs m�thodes menuPrincipal() sont imbriqu�es,
			// plusieurs d�connexions peuvent �tre n�cessaires
			case 0:
				System.out.println("D�connexion...");
				continuer = false;
				break;
			default:
				System.err.println("Entr�e invalide.");
			}
		}
	}

	// *** 1 - CLIENTS ***

	public static void sousMenuClients() {
		System.out.println("\n=== Menu de gestion clients ===\n");
		int choix;
		System.out.println("1. Cr�er un client");
		System.out.println("2. Lister tous les clients");
		System.out.println("3. Lister les ID de vos clients");
		System.out.println("4. Modifier un client");
		System.out.println("5. Lire les informations d'un client");
		System.out.println("6. Supprimer un client");
		System.out.println("7. Assigner un compte �pargne");
		System.out.println("8. Assigner une carte � un compte courant");
		System.out.println("0. Retour au menu sup�rieur");
		choix = sc.nextInt();
		sc.nextLine();
		switch (choix) {
		case 1:
			creerClient();
			break;
		case 2:
			listerTousClients();
			break;
		case 3:
			listerClientsConseiller();
			break;
		case 4:
			modifierClient();
			break;
		case 5:
			lireClient();
			break;
		case 6:
			supprimerClient();
			break;
		case 7:
			assignerCompteEpargne();
			break;
		case 8:
			assignerCarte();
			break;
		case 0:
			menuPrincipal();
			break;
		default:
			System.err.println("Entr�e invalide.");
		}
	}

	// *** 1.1 - CREER CLIENTS ***

	public static void creerClient() {
		Client client = promptClient();
		String id = cs.creerClient(conseiller, client);
		System.out.println(cs.obtenirClient(id));
	}

	// *** 1.2 - LISTER TOUS LES CLIENTS ***

	public static void listerTousClients() {
		System.out.println(cs.obtenirListeClients());
	}

	// *** 1.3 - LISTER CLIENTS CONSEILLER ***

	public static void listerClientsConseiller() {
		System.out.println(conseiller);
	}

	// *** 1.4 - MODIFIER CLIENT ***

	// TODO Bug [CRITICAL] - la modification supprime les ajouts post�rieurs � la
	// cr�ation
	// (compte courant, compte �pargne, cartes)
	public static void modifierClient() {
		String id = promptId("Veuillez saisir l'ID du client � modifier : ");
		Client client = promptClient();
		cs.modifierClient(id, client);
	}

	// *** 1.5 - LIRE CLIENT ***

	public static void lireClient() {
		String id = promptId("Veuillez saisir l'ID du client � lire : ");
		System.out.println(cs.obtenirClient(id));
	}

	// *** 1.6 - SUPPRIMER CLIENT ***

	public static void supprimerClient() {
		String id = promptId("Veuillez saisir l'ID du client � supprimer : ");
		cs.supprimerClient(conseiller, id);
	}

	// *** 1.7 - ASSIGNER COMPTE EPARGNE ***

	public static void assignerCompteEpargne() {
		String id = promptId("Veuillez saisir l'ID du client b�n�ficiaire du compte Epargne : ");
		Client client = cs.obtenirClient(id);
		cs.assignerCompteEpargne(client);
	}

	// *** 1.8 - ASSIGNER CARTE (� un compte courant) ***

	public static void assignerCarte() {
		String id = promptId("Veuillez saisir l'ID du client b�n�ficiaire de la carte : ");
		Client client = cs.obtenirClient(id);
		CarteVisa carte = null;
		System.out.println("1. Carte Electron");
		System.out.println("2. Carte Premier");
		int choix = sc.nextInt();
		sc.nextLine();
		switch (choix) {
		case 1:
			carte = new CarteElectron();
			break;
		case 2:
			carte = new CartePremier();
			break;
		default:
			System.err.println();
		}
		cs.assignerCarte(client, carte);
	}

	// *** 2 - OPERATIONS ***

	public static void sousMenuOperations() {
		System.out.println("\n=== Menu d'op�rations bancaires ===\n");
		int choix;
		System.out.println("1. Faire un virement");
		System.out.println("2. Cr�diter un compte courant");
		System.out.println("3. Auditer l'agence");
		choix = sc.nextInt();
		sc.nextLine();
		switch (choix) {
		case 1:
			faireVirement();
			break;
		case 2:
			crediterCompteCourant();
			break;
		case 3:
			auditerAgence();
			break;
		case 0:
			menuPrincipal();
			break;
		default:
			System.err.println("Entr�e invalide.");
		}
	}

	// *** 2.1 - VIREMENTS ***

	public static void faireVirement() {
		String id1 = promptId("Veuillez saisir l'ID du client pr�lev� : ");
		String id2 = promptId("Veuillez saisir l'ID du client cr�dit� : ");
		System.out.println("Veuillez saisir le montant : ");
		double montant = sc.nextDouble();
		sc.nextLine();
		cs.faireVirement(cs.obtenirClient(id1), cs.obtenirClient(id2), montant);
	}

	// *** 2.2 - CREDITER COMPTE ***

	// Ceci peut �tre utilis� pour tester la fonction d'audit - on d�bite de mani�re
	// � passer le montant sous 5000 $CUR
	public static void crediterCompteCourant() {
		String id = promptId("Veuillez saisir l'ID du client � cr�diter : ");
		System.out.println("Veuillez saisir un montant : ");
		double montant = sc.nextDouble();
		sc.nextLine();
		cs.crediterCompte(cs.obtenirClient(id), montant);
	}

	// *** 2.3 - AUDIT ***

	public static void auditerAgence() {
		ArrayList<Client> clientsAlerte = cs.auditerAgence();
		System.out.println("=> Clients d�biteurs de plus de 5000 � : ");
		System.out.println(clientsAlerte);
	}

	public static void main(String[] args) {

		// Cr�ation G�rant
		Gerant gerant = new Gerant("G0001", "Stan", "Smith");
		
		// Cr�ation Agence
		Agence agence = new Agence("A1234", "16/03/2018", gerant);
		
		System.out.println(agence.toString());
		
		// Cr�ation de 9 clients pour le dernier conseiller (celui qui
		// manipule l'interface) (permet de tester la limite d'ajout en ajoutant 2
		// clients suppl�mentaires)
		for (int i = 0; i < 9; i++) {
			cs.creerClient(conseiller, new Client("Nom", "Pr�nom", "Adresse",
					"CodePostal", "Ville", "Telephone"));
		}
		
		menuPrincipal();

	}

}