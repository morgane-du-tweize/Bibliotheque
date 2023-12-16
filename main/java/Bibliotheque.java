import java.io.IOException;
import java.util.ArrayList;
import models.Livre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
		name = "bibliotheque",
		urlPatterns = {
				"", "/bibliotheque"
		})

public class Bibliotheque extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Livre l = new Livre ("", "");
		ArrayList<Livre> livres = l.selectAll();
		request.setAttribute("livres", livres);
		request.getRequestDispatcher("jsps/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String reference = request.getParameter("reference");
		request.setAttribute("reference", reference);
		session.setAttribute("reference", reference);
		response.sendRedirect(request.getContextPath() + "/update");
	}

}
