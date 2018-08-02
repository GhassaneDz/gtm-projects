package net.lecigne.onetomany.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import net.lecigne.onetomany.model.Professor;
import net.lecigne.onetomany.model.Student;
import net.lecigne.onetomany.util.HibernateUtil;

public class UpdateFromInverseEnd {

	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	public static void main(String[] args) {

		Session session = sessionFactory.openSession();
		Transaction txn = session.getTransaction();
		Student student = null;
		Professor professor = null;

		try {
			txn.begin();
			// Professeur sans �tudiants
			professor = (Professor) session.get(Professor.class, 2L);
			// Cet �tudiant a le professeur n�1
			student = (Student) session.get(Student.class, 1L);
			// MAJ du point de vue de l'inverse end, pas de droit de MAJ - �a ne fonctionne
			// pas !
			professor.getStudents().add(student);
			// On v�rifie que les changements sont appliqu�s
			professor.setName("Jacques Monod");
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
