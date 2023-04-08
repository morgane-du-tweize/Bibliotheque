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

		<header>
			<h2>Bibliothèque en ligne</h2>

			<div class="topimage"></div>	
		</header>

		<main>
		
			<h1 class="aligned">Ma liste de livres</h1>
		
			<table class="books">
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
			
			<div>
				<h2><a href="ajout">Ajouter un nouveau livre</a></h2>
			</div>	

		
		</main>

		<footer>
			<div class="bottomcontainer">
				<p class="bottomelements">my github</p>
				<p class="bottomelements">my codin games page</p>
				<p class="bottomelements">my linked in profile</p>
			
			</div>
			<p class="bottomelements">Author : morgane-du-tweize</p>
		</footer>

	</body>
</html>