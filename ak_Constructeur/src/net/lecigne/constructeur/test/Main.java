package net.lecigne.constructeur.test;

import java.util.*;
import net.lecigne.constructeur.model.Person;

/**
 * Classe de d�marrage de l'application.
 * 
 * @author Anthony Le Cigne
 * @version 0.1
 *
 */

public class Main {

	/**
	 * La m�thode main est statique, elle est charg�e en m�moire au d�marrage de
	 * l'application et peut donc �tre utilis�e avant la cr�ation de tout objet.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		Person p1 = new Person("Richard", "Stallman", "GNU");
		Person p2 = new Person("Linus", "Torvalds", "Linux");
		Person p3 = new Person("Alan", "Cox", "UNIX");

		LinkedList<Person> persons = new LinkedList<Person>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);

		// *** FOR ***

		System.out.println("=== FOR ===");

		for (int x = 0; x < persons.size(); x++) {
			System.out.println(persons.get(x) + "\n");
		}

		// *** FOR-EACH ***

		System.out.println("=== FOR-EACH ===");

		for (Person person : persons) {
			System.out.println(person + "\n");
		}

		// *** ITERATOR ***

		System.out.println("=== ITERATOR ===");

		ListIterator li = persons.listIterator();

		while (li.hasNext()) {
			System.out.println(li.next() + "\n");
		}

	}

}
