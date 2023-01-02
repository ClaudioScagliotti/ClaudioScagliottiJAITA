package presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import controller.AutoreLibroController;

@WebServlet("/delAutoreLibro")
public class DelAutoreLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private AutoreLibroController controller;
   
    public DelAutoreLibro() throws ClassNotFoundException, SQLException {
        super();
      controller= AutoreLibroController.getController();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int autore_id=Integer.parseInt(request.getParameter("autore_id"));
		
		try {
			boolean nAutoreCancellati=controller.deleteAutoreLibroAutoreId(autore_id);
			if(nAutoreCancellati == true) {
				
				request.setAttribute("avvisoMessaggio",  "Relazione autore libro cancellata con successo");
				
			}else {
				
				request.setAttribute("avvisoMessaggio",  "Anomalia, cancellati " + nAutoreCancellati + " records.");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
		doGet(request, response);
	}
	

}
