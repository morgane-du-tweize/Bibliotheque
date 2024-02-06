package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Livre;


@WebServlet("/update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String reference = (String) session.getAttribute("reference");
		Livre livre = new Livre();
		livre = livre.select(reference);
		livre.setReference(reference);
		request.setAttribute("livre", livre);
		request.getRequestDispatcher("/jsps/update.jsp").forward(request, response);
	}
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String reference = request.getParameter("reference");
		String titre = request.getParameter("titre");
		String auteur = request.getParameter("auteur");

		Livre nouveauLivre = new Livre (titre, auteur);
		nouveauLivre.setReference(reference);
		System.out.println(nouveauLivre);
		nouveauLivre.update();
		response.sendRedirect(request.getContextPath() + "");			
	}

}
