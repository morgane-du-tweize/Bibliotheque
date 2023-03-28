<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Formulaire d'ajout de livre</title>
		<link rel="stylesheet" href="css/style.css">		
	</head>
	<body>
		<h1>Ajout de livre</h1>
		
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
		
		<div>
			<p><a href="/bibliotheque">Retour à l'accueil</a></p>
		</div>
	
	</body>
</html>