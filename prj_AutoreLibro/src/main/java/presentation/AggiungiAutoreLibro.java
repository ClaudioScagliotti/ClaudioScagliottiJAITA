package presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import controller.AutoreLibroController;


@WebServlet("/aggiungiAutoreLibro")
public class AggiungiAutoreLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AutoreLibroController controller;

    public AggiungiAutoreLibro() throws ClassNotFoundException, SQLException {
    	controller= AutoreLibroController.getController();
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int libro_id=Integer.parseInt(request.getParameter("libro_id"));
			int autore_id=Integer.parseInt(request.getParameter("autore_id"));
			boolean inserito=controller.insertAutoreLibro(libro_id, autore_id);
			if(inserito)
				request.setAttribute("avvisoMessaggio", "Relazione autore libro inserita con successo");
			else
				request.getSession().setAttribute("avvisoMessaggio", "Anomalia, relazione non inserita.");
		} catch (SQLException e) {
			
			e.printStackTrace();
			request.setAttribute("avvisoMessaggio", e.getMessage());
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
