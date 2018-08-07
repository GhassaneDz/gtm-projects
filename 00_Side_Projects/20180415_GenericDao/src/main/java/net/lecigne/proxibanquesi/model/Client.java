package net.lecigne.proxibanquesi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Cette classe d�crit les caract�ristiques d'un client ProxiBanque.
 * 
 * @author Anthony Le Cigne
 *
 */

@Entity
public class Client {

	// *** ATTRIBUTES ***

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idClient;
	private String nom;
	private String prenom;
	private String adresse;
	private String codePostal;
	private String ville;
	private String telephone;

	// *** CONSTRUCTORS ***

	public Client(String nom, String prenom, String adresse, String codePostal, String ville,
			String telephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}

	// *** GETTERS and SETTERS ***

	public long getIdClient() {
		return idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	// *** OTHER METHODS ***

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", adresse="
				+ adresse + ", codePostal=" + codePostal + ", ville=" + ville + ", telephone="
				+ telephone + "]";
	}

}