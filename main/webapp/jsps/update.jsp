<%@page import="models.Livre"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Update book</title>
		<link href="css/style.css" rel="stylesheet">
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
				<% Livre livre = (Livre) request.getAttribute("livre"); %>
				<h1>Modifier le livre suivant :</h1>		
	
				<div>
					<ul>
						<li>Titre : <%= livre.getTitre() %></li>
						<li>Auteur : <%= livre.getAuteur() %></li>
					</ul>
				</div>
			</div>
			
			<div class="new-book">
				<h2>Entrez nouveau titre et nouvel auteur</h2>
				<div class="ajout">
					<form method="POST" action="update">
						<div class="adding-form">
							<label for="titre">Titre</label><br>
							<input type="text" name="titre" id="titre"><br>
						</div>
			
						<div class="adding-form">
							<label for="auteur">Auteur</label><br>
							<input type="text" name="auteur" id="auteur"><br>
						</div>
						<input type="hidden" name="reference" value="<%=livre.getReference()%>">
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
			<p class="bottomelements">Author : morgane-du-tweize</p>
		</footer>

	</body>
</html>