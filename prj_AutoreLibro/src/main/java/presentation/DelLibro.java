package presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import controller.AutoreController;
import controller.LibroController;

@WebServlet("/delLibro")
public class DelLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private LibroController controller;
    public DelLibro() throws ClassNotFoundException, SQLException {
        super();
        controller=LibroController.getController();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idLibro= Integer.parseInt(request.getParameter("idLibro"));
		try {
			boolean nLibroCancellati=controller.deleteLibro(idLibro);
			if(nLibroCancellati == true) {
				
				request.setAttribute("avvisoMessaggio",  "Libro cancellato con successo");
				
			}else {
				
				request.setAttribute("avvisoMessaggio",  "Anomalia, cancellati " + nLibroCancellati + " records.");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		request.getRequestDispatcher("listaLibri").forward(request, response);
		doGet(request, response);
	}

}
