package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

public class DbConnect {
	
	private Connection connection ;
	
	public ArrayList<Livre> recupererLivres(){
		ArrayList<Livre> livres = new ArrayList<Livre>();
		Statement statement = null ;
		ResultSet resultat = null ;
		
		loadDatabase();
		
		try {
			statement = connection.createStatement();
			
			// exécuter la requête
			resultat = statement.executeQuery("SELECT id, titre, auteur FROM livre");
			
			// récupérer les données
			while (resultat.next()) {
				String reference = resultat.getString("id");
				String titre = resultat.getString("titre");
				String auteur = resultat.getString("auteur");

				Livre livre = new Livre(reference, titre, auteur);
				livres.add(livre);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			
			// fermeture de la connection
			try {
				if (resultat != null)
					resultat.close();
				if (statement != null) 
					statement.close();
				if (connection != null) 
					connection.close();
	
			}
			catch (SQLException e) {
				
			}
			
		}
		return livres ;
	}
	
	private void loadDatabase() {
		
		// charger le driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) {
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bibliotheque", username, password);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ajouterLivre(Livre livre) {
		loadDatabase();
		
		try {
			PreparedStatement prep = connection.prepareStatement("INSERT INTO livre (titre, auteur) VALUES (?, ?);");
			prep.setString(1, livre.getTitre());
			prep.setString(2, livre.getAuteur());
			
			prep.executeUpdate();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

}
