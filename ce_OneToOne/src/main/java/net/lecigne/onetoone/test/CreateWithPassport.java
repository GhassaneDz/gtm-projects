package net.lecigne.onetoone.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import net.lecigne.onetoone.model.Customer;
import net.lecigne.onetoone.model.Passport;
import net.lecigne.onetoone.util.HibernateUtil;
import net.lecigne.onetoone.util.RndStr;

public class CreateWithPassport {

	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public static void main(String[] args) {

		Session session = sessionFactory.openSession();
		Transaction txn = session.getTransaction();
		Passport passport = new Passport(RndStr.generate(8));
		Customer customer = new Customer(RndStr.generate(8));

		// Relation bidirectionnelle ; on doit refl�ter ceci c�t� objet. Cela dit, la
		// premi�re ligne suffit pour ce qui est de la base de donn�es.
		//
		// Si on ne met que la deuxi�me ligne, alors le Customer n'aura pas de
		// passeport. En effet, l'objet de classe Passport n'a pas les moyens
		// d'influencer la table Customer (pas propri�taire).
		//
		// On peut rem�dier � cela gr�ce � la m�thode addCustomer de la classe Passport
		// (qui fait les deux �tapes).
		customer.setPassport(passport);
		passport.setCustomer(customer);

//		passport.addCustomer(customer);

		try {
			txn.begin();
			// Ceci n'est pas n�cessaire gr�ce au CascadeType.PERSIST de la classe Customer
			// session.persist(passport);
			session.persist(customer);
			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
			sessionFactory.close();
		}

	}

}
