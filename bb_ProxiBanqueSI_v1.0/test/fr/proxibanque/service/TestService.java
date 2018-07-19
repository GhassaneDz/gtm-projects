package fr.proxibanque.service;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.proxibanque.model.Client;
import fr.proxibanque.model.Conseiller;
import fr.proxibanque.service.ConseillerService;
import fr.proxibanque.service.ConseillerServiceImp;

/**
 * Cette classe r�alise quatre tests :
 * - test d'une simulation d'un cr�dit ;
 * - test d'un virement SANS d�passement de la limite de d�couvert autoris�
 * - test d'un virement AVEC d�passement de la limite de d�couvert autoris�
 * - test d'attribution d'un maximum de 10 clients � un conseiller
 *  
 * @author Joumard S�bastien, Le Cigne Anthony
 *
 */

class TestService {

	private ConseillerService cs;
	Client c1;
	Client c2;
	Conseiller cons;

	@BeforeEach
	void instanciationConseillerServiceImp() {

		cs = new ConseillerServiceImp();

		// Cr�ation conseiller
		cons = new Conseiller("ID1", "Pr�nom", "Nom");

		// Cr�ation client
		c1 = new Client("Nom-1", "Pr�nom-1", "Adresse-1", "CodePostal-1", "Ville-1", "Telephone-1");
		cs.creerClient(cons, c1);
		c2 = new Client("Nom-2", "Pr�nom-2", "Adresse-2", "CodePostal-2", "Ville-2", "Telephone-2");
		cs.creerClient(cons, c2);

	}

	@Test
	void testSimulerCredit() {

		assertTrue((int) ((1000 / 12) * 1.7) == (int) (cs.simulerCredit(1000, 12, 1.7)));
	}

	@Test
	void testFaireVirement() {

		cs.faireVirement(c1, c2, 500.0);
		assertTrue(-500 == c1.getCompteCourant().getSolde());
		assertTrue(+500 == c2.getCompteCourant().getSolde());
	}

	@Test
	void testFaireVirementMaximumMilleEuro() {

		// Le solde des deux comptes ne devrait pas changer et un message d'erreur
		// devrait s'afficher
		cs.faireVirement(c1, c2, 1001.0);
		assertTrue(0 == c1.getCompteCourant().getSolde());
		assertTrue(0 == c2.getCompteCourant().getSolde());
	}

	@Test
	void testCreationClientMaximumDixParConseiller() {
		
		Conseiller cons2 = new Conseiller("ID2", "Pr�nom", "Nom");
		
		// Assignation de 15 clients � un conseiller
		for (int i = 0; i < 15; i++) {
			cs.creerClient(cons2, new Client("Nom-" + i, "Pr�nom-" + i, "Adresse-" + i, "CodePostal-" + i, "Ville-" + i,
					"Telephone-" + i));
		}
		
		// Seul 10 clients seront attribu� au conseillers
		assertTrue(10==cons2.getListeClients().size());
	}

}
