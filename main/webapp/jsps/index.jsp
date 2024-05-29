	<%@page import="models.Livre" %>
<%@page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Bibliotheque</title>
		<link rel="stylesheet" href="css/style.css">
	</head>
	<body>

		<header>
			<div class="top-header">
				<h2>Bibliothèque en ligne</h2>
			</div>
			<div class="topimage">
				<img src="resources/bib.jpg" alt="a library with books">
			</div>	
		</header>

		<main>
			<div class="books-list">
				<h1>Ma liste de livres</h1>
				<table>
					<tr>
						<th>Titre</th>
						<th>Auteur</th>
						<th>Modifier</th>
					</tr>
					 <% 	ArrayList<Livre> livres =(ArrayList<Livre>) request.getAttribute("livres") ;
						
						 for (Livre l : livres) { 
							 request.setAttribute("reference", l.getReference());
							 String Lreference =l.getReference();
						 %>
					 <tr>
						 <td><%=l.getTitre() %>  </td>
						 <td><%= l.getAuteur() %> </td>
	
						 <td>
							   <form method="POST" action="bibliotheque">
								 <input type="hidden" name="reference" value="<%=l.getReference()%>">
								 <input type="submit" name="modifier" class="submit">
							 </form>
						 </td>					 
					<% } %>	
					</tr>				
				</table>

			</div>
			
			<div class="new-book">
				<h2>Ajouter un nouveau livre</h2>
				<div class="ajout">
					<form method="POST" action="ajout">
						<div class="adding-form">
							<label for="titre">Titre</label><br>
							<input type="text" name="titre" id="titre"><br>
						</div>
			
						<div class="adding-form">
							<label for="auteur">Auteur</label><br>
							<input type="text" name="auteur" id="auteur"><br>
						</div>
			
						<div>
							<input type="submit" class="submit">			
						</div>		
					</form>
				</div>
		</div>

		</main>

		<footer>
			<div class="bottomcontainer">
				<p class="bottomelements">my github</p>
				<p class="bottomelements">my codin games page</p>
				<p class="bottomelements">my linked in profile</p>
			
			</div>
			<p >Author : morgane-du-tweize</p>
		</footer>

	</body>
</html>