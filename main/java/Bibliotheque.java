

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
		
		request.setAttribute("livres", getLivres());
		this.getServletContext().getRequestDispatcher("/jsps/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private ArrayList<Livre> getLivres(){
		 
		ArrayList<Livre> livres = new ArrayList<Livre>();
		
		Livre livre1 = new Livre("00001", "Carrie au bal du diable", "Stephen King");
		Livre livre2 = new Livre("00002", "Ring", "Kōji Suzuki" );
		Livre livre3 = new Livre("00003", "Chtulhu", "HP Lovecraft" );
		
		livres.add(livre1);
		livres.add(livre2);
		livres.add(livre3);
		
		return livres ;
	};

}
