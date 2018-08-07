package ref.spring.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ref.spring.model.Client;

public interface DAO extends JpaRepository<Client, Integer> {

	// Operation du CRUD d�ja d�critent dans JpaRepository
	// Possibilit� de cr�er des requ�tes :
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#query-by-example
	// 4.3.2. Query creation

	// ex :

	List<Client> findAllClientByNom(String nom);
	
	public Client findClientByNom(String nom);

	public Client findClientById(int id);
	
	List<Client> findAllClientByAdresseVille(String ville);
}
