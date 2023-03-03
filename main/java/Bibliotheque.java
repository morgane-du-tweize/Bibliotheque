

import java.io.IOException;
import java.util.ArrayList;

import models.Livre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bibliotheque
 */
@WebServlet(
		name = "bibliotheque", 
		urlPatterns = { 
				"", "/bibliotheque"
		})

public class Bibliotheque extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bibliotheque() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// créer référence vers objet de type ArrayList<Livre>
		// instancier objet de type ArrayList<Livre>
		ArrayList livres = getLivres();
		// balancer ça à objet request
		request.setAttribute("livres", livres);
		this.getServletContext().getRequestDispatcher("/jsps/index.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private ArrayList<Livre> getLivres(){
		ArrayList<Livre> livres = new ArrayList<>();
		
		Livre livre1 = new Livre("001", "Carrie au bal du Diable", "Stephen King");
		Livre livre2 = new Livre("002", "Ring", "Kōji Suzuki");
		Livre livre3 = new Livre("003", "Chtulhu", "H. P. Lovrcraft");

		livres.add(livre1);
		livres.add(livre2);
		livres.add(livre3);
		
		return livres ;
		
	}

}
