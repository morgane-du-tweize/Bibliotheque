<%@page import="models.Livre"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Update book</title>
		<link href="css/style.css" rel="stylesheet">
	</head>

	<body>
		
		<header>
			<h2>Bibliothèque en ligne</h2>

			<div class="topimage"></div>	
		</header>
		
		<main>
			<% Livre livre = (Livre) request.getAttribute("livre"); %>
			<h1>Modifier le livre suivant :</h1>
			
			<div class="flex-container">
			
				<div class="update">
					<ul>
						<li>Titre : <%= livre.getTitre() %></li>
						<li>Auteur : <%= livre.getAuteur() %></li>
					</ul>			
				</div>
	
				<div class="books ajout">
					<h3>Entrez nouveau titre et nouvel auteur</h3>
					<form method="POST" action="update">
						<div class="formelement">
							<label for="titre">Titre</label><br>
							<input type="text" name="titre"><br>
						</div>
			
						<div class="formelement">
							<label for="auteur">Auteur</label><br>
							<input type="text" name="auteur"><br>
						</div>
						<input type="hidden" name="reference" value="<%=livre.getReference()%>">
						<div class="formelement">
							<input type="submit">			
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