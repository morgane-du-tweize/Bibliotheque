package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Livre implements Crud<Livre>{
	
	private String reference ;
	private String titre ;
	private String auteur ;
	
	public Livre(String titre, String auteur) {
		setTitre(titre);
		setAuteur(auteur);
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
	@Override
	public ArrayList<Livre> selectAll() {
		ArrayList<Livre> livres = new ArrayList<>();
		
		String query = "SELECT titre, auteur FROM livre;";
		
		try (PreparedStatement prep = DbConnect.getConnector().prepareStatement(query)) {
			
			ResultSet result = prep.executeQuery();
			
			while (result.next()) {
				Livre l = new Livre("", "");
				l.setTitre(result.getString("titre"));
				l.setAuteur(result.getString("auteur"));
				
				livres.add(l);
			}
			DbConnect.getConnector().close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return livres ;
		
	}
	@Override
	public void insert() {
		
		String query = "INSERT INTO livre (titre, auteur) VALUES (?, ?);";
		
		try (PreparedStatement prep = DbConnect.getConnector().prepareStatement(query)) {
			prep.setString(1, this.titre);
			prep.setString(2, this.auteur);
			
			prep.executeUpdate();
			ResultSet res = prep.getGeneratedKeys();
			
			while (res.next()) {
				this.reference = res.getString(0);
			}
			
			DbConnect.getConnector().close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

/*
INSERT INTO livre (titre, auteur) VALUES
    ("Carrie au bal du diable", "Stephen King"),
    ("Ring", "Kōji Suzuki"),
    ("Trailerpark", "Russel Banks"),
    ("Chtulhu", "HP Lovecraft ")
;
 */

