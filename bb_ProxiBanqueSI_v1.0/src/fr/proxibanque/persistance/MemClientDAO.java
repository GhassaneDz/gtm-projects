package fr.proxibanque.persistance;

import java.util.*;
import fr.proxibanque.model.Client;

/**
 * Cette classe impl�mente l'interface ClientDAO au niveau d'un objet de type
 * Map stock� en m�moire. Elle contient des m�thodes permettant de r�aliser le
 * CRUD sur celui-ci.
 * 
 * @author Joumard S�bastien, Le Cigne Anthony
 *
 */

public class MemClientDAO implements ClientDAO {

	private static final Map<String, Client> DB = new HashMap<>();
	
	@Override
	public String sauvegarder(Client c) {
		String uniqueId = genererIdUnique(c);
		c.setId(uniqueId);
		DB.put(uniqueId, c);
		return uniqueId;
	}
	
	/**
	 * @param  c l'objet client tel que d�crit par la couche mod�le
	 * @return   une cha�ne de caract�re qui servira de mapkey (premi�re lettre du
	 *           pr�nom suivie du nom et d'une cha�ne num�rique de 4 chiffres)
	 */
	private String genererIdUnique(Client c) {
		String username = "";
		username = c.getPrenom().substring(0, 1).toLowerCase()
				+ c.getNom().toLowerCase();
		int randomNumber = (int) (Math.random() * 10_000);
		username = username + String.format("%04d", randomNumber);
		return username;
	}

	@Override
	public void modifier(String id, Client c) {
		c.setId(id);
		DB.put(id, c);
	}

	@Override
	public Client obtenir(String id) {
		return DB.get(id);
	}

	@Override
	public void supprimer(String id) {
		DB.remove(id);
	}

	@Override
	public List<Client> obtenirTous() {
		return new ArrayList<Client>(DB.values());
	}

}