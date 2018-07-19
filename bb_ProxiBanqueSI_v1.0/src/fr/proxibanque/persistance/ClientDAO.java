package fr.proxibanque.persistance;

import java.util.List;
import fr.proxibanque.model.Client;

/**
 * Cette interface d�crit les op�rations g�n�rales li�es � la persistance des
 * donn�es clients (CRUD - Create, Read, Update, Delete).
 *
 * @author Joumard S�bastien, Le Cigne Anthony
 *
 */

public interface ClientDAO {

	public String sauvegarder(Client c);
	public void modifier(String id, Client c);
	public Client obtenir(String id);
	public void supprimer(String id);
	public List<Client> obtenirTous();
	
}