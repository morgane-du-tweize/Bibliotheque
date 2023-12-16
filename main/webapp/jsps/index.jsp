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
					<th>Modifier</th>
				</tr>
			 	<% 	ArrayList<Livre> livres =(ArrayList<Livre>) request.getAttribute("livres") ;
					
			 		for (Livre l : livres) { 
				 		request.setAttribute("reference", l.getReference());
				 		session.setAttribute("reference", l.getReference());
				 		String Lreference =l.getReference();
			 		%>
			 	<tr>
			 		<td><%=l.getTitre() %>  </td>
			 		<td><%= l.getAuteur() %> </td>

			 		<td>
			 		  	<form method="POST" action="bibliotheque">
			 				<input type="hidden" name="reference" value="<%=l.getReference()%>">
			 				<input type="submit" name="modifier">
			 			</form>		 		
			 		 
			 		</td>
			 	
				<% } %>	
				</tr>	
			
			</table>
			
			<h2>Ajouter un nouveau livre</h2>
			<div class="ajout">
				<form method="POST" action="ajout">
					<div class="formelement">
						<label for="titre">Titre</label><br>
						<input type="text" name="titre"><br>
					</div>
		
					<div class="formelement">
						<label for="auteur">Auteur</label><br>
						<input type="text" name="auteur"><br>
					</div>
		
					<div class="formelement">
						<input type="submit">			
					</div>		
				</form>
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