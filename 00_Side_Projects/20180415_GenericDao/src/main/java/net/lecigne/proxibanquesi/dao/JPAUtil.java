package net.lecigne.proxibanquesi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory emf;

	static {
		emf = Persistence.createEntityManagerFactory("my-pu");
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public static void closeEMF() {
		emf.close();
	}

}
