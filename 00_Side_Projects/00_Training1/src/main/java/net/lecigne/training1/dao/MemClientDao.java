package net.lecigne.training1.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.stereotype.Repository;

import java.util.TreeMap;

import net.lecigne.training1.model.Client;

@Repository("memDao")
public class MemClientDao implements ManualClientDao {

	private static final TreeMap<Long, Client> DB = new TreeMap<>();

	@Override
	public void sauvegarder(Client client) {
		// Si on sauvegarde un objet d�j� r�f�renc� dans le TreeMap (du point de vue
		// m�moire et non m�tier), alors ne rien faire.
		if (DB.get(client.getId()) == client) {
			return;
		}
		long idClientUnique = genererIdUnique();
		client.setId(idClientUnique);
		DB.put(idClientUnique, client);
	}

	/**
	 * G�n�re une cl� unique bas�e sur l'ordre des cl�s d'un TreeMap.
	 * 
	 * @return cl� unique
	 */
	private long genererIdUnique() {
		Entry<Long, Client> lastEntry = DB.lastEntry();
		if (lastEntry != null) {
			return lastEntry.getKey() + 1;
		} else {
			return 0;
		}
	}

	@Override
	public void modifier(Client client) {
		DB.put(client.getId(), client);
	}

	@Override
	public Client obtenir(Long idClient) {
		return DB.get(idClient);
	}

	@Override
	public List<Client> obtenirTous() {
		return new ArrayList<Client>(DB.values());
	}

	@Override
	public void supprimer(Long idClient) {
		DB.remove(idClient);
	}

}
