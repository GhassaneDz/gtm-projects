package net.lecigne.hibernate.tests;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import net.lecigne.hibernate.dto.FourWheeler;
import net.lecigne.hibernate.dto.TwoWheeler;
import net.lecigne.hibernate.dto.UserDetails;
import net.lecigne.hibernate.dto.Vehicle;

public class HibernateTest {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	// Bloc statique - ex�cut� une seule fois
	static {
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	// Alternative :
	// private static SessionFactory sessionFactory =
	// HibernateUtil.getSessionFactory();

	public static String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	public static void createTestUsers() {

		List<UserDetails> users = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			UserDetails user = new UserDetails("Name #" + i, i + " rue de la Petite Vache", "Aurillac");
			List<Vehicle> vehicles = new ArrayList<>();
			for (int j = 0; j < 3; j++) {
				Vehicle vehicle = (Math.random() < 0.5) ? new TwoWheeler(randomString(8))
						: new FourWheeler(randomString(8));
				vehicles.add(vehicle);
			}
			user.setVehicles(vehicles);
			users.add(user);
		}

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		// N�cessaire si pas de CascadeType.PERSIST
		for (UserDetails user : users) {
			// for (Vehicle v : user.getVehicles()) {
			// session.save(v);
			// }
			session.save(user);
		}

		session.getTransaction().commit();
		session.close();

	}

	public static void main(String[] args) {

		createTestUsers();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from UserDetails");
		List<UserDetails> users = query.list();

		// Appel "artificiel" � size pour charger les v�hicules en m�moire
		for (UserDetails user : users) {
			user.getVehicles().size();
		}

		session.getTransaction().commit();
		session.close();

		// Par d�faut, Hibernate ne charge pas les objets en m�moire (comportement
		// "lazy"). Donc apr�s avoir ferm� la session, c'est trop tard pour acc�der aux
		// objets. SAUF si on y a acc�d� dans la session (cf. boucle ci-dessus).

		System.out.println("Size: " + users.size());
		System.out.println(users);

		sessionFactory.close(); // Sinon le main reste en route. Le serveur g�re la sessionFactory en g�n�ral,
								// mais ici on est dans le main

	}

}
