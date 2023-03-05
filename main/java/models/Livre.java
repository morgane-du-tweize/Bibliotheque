package models;

public class Livre {
	
	private String reference;
	private String titre;
	private String auteur;
	
	public Livre(String reference, String titre, String auteur) {
		this.reference = reference;
		this.titre = titre;
		this.auteur = auteur;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Livre [reference=" + reference + ", titre=" + titre + ", auteur=" + auteur + "]";
	}

}
