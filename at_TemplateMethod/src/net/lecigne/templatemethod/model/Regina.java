package net.lecigne.templatemethod.model;

public class Regina extends Pizza {

	public Regina(String name) {
		super(name);
	}

	@Override
	public void addTopping() {
		System.out.println("Ajout de champignons...");
		System.out.println("Ajout de d�s de jambons...");
		System.out.println("Ajout d'olives...");
	}

	@Override
	public void addCheese() {
		System.out.println("Ajout de gruy�re r�p�...");
	}
	
}
