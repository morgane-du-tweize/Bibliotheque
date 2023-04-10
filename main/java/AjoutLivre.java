
import models.DbConnect;
import models.Livre;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjoutLivre
 */
@WebServlet("/ajout")
public class AjoutLivre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutLivre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/jsps/ajout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titre = request.getParameter("titre");
		String auteur = request.getParameter("auteur");
		Livre nouveaulivre = new Livre(titre, auteur);
		System.out.println(nouveaulivre);
		
		DbConnect connect = new DbConnect();
		connect.ajouterLivre(nouveaulivre);		
		
		response.sendRedirect(request.getContextPath() + "");
	}



}
