<%@page import="models.Livre" %>
<%@page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bibliotheque</title>
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>

		<header>Bibliothèque en ligne</header>

		<main>
		
		<h1>Ma liste de livres</h1>
		
			<table>
				<tr>
					<th>Titre</th>
					<th>Auteur</th>
				</tr>
			 	<% 	ArrayList<Livre> livres =(ArrayList<Livre>) request.getAttribute("livres") ; %>
			 	<%for (Livre l : livres) { %>
			 	<tr>
			 		<td><%=l.getTitre() %>   </td>
			 		<td><%= l.getAuteur() %>  </td>
			 	
				<% } %>	
				</tr>	
			
			</table>		

		
		</main>

		<footer>Author : morgane-du-tweize</footer>

	</body>
</html>