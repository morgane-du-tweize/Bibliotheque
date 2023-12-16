package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Livre implements Crud<Livre>{
	
	public String reference ;
	private String titre ;
	private String auteur ;
	
	public Livre() {
		
	}
	
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
		
		String query = "SELECT id, titre, auteur FROM livre;";
		
		try (PreparedStatement prep = DbConnect.getConnector().prepareStatement(query)) {
			
			ResultSet result = prep.executeQuery();
			
			while (result.next()) {
				Livre l = new Livre();
				l.setTitre(result.getString("titre"));
				l.setAuteur(result.getString("auteur"));
				l.setReference(result.getString("id"));
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

	public Livre select(String reference) {
		String query = "SELECT * FROM livre WHERE id =?;" ;
		Livre livre = new Livre();
		
		try (PreparedStatement prep = DbConnect.getConnector().prepareStatement(query)){
			prep.setString(1, reference);
			ResultSet result = prep.executeQuery();
			
			while (result.next()) {
				livre.setTitre(result.getString("titre"));
				livre.setAuteur(result.getString("auteur"));
				return livre ;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null ;
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

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update() {
		
		String query = "UPDATE livre SET titre =?, auteur=? WHERE id=? ;";
		
		try (PreparedStatement prep = DbConnect.getConnector().prepareStatement(query)){
			prep.setString(1, this.titre);
			prep.setString(2, this.auteur);
			prep.setString(3, this.reference);
			
			prep.executeUpdate();
			ResultSet res = prep.getGeneratedKeys();

		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
