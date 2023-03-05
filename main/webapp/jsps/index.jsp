<%@page import="models.Livre" %>
<%@page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bibliotheque</title>
	</head>
	<body>
		<h1>Ma liste de livres</h1>
		

			<!-- 
request.setAttribute("livres", getLivres());
			 -->
			 	<% 	ArrayList<Livre> livres =(ArrayList<Livre>) request.getAttribute("livres") ; %>
			 	<%for (Livre l : livres) { %>
			 		<p><%=l.getTitre() %>  </p>
			
		
				<% } %>



	</body>
</html>