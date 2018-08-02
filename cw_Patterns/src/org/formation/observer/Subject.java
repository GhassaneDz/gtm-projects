package org.formation.observer;

// Pourrait �tre abstraite, avec notifyObservers d�j� impl�ment�e
public interface Subject {

	void register(Observer o);

	void unRegister(Observer o);

	void notifyObservers();

}
