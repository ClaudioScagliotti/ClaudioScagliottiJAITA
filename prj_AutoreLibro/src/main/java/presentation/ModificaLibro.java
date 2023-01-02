package presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Libro;

import java.io.IOException;
import java.sql.SQLException;

import controller.LibroController;

@WebServlet("/modificaLibro")
public class ModificaLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private LibroController controller;
   
    public ModificaLibro() throws ClassNotFoundException, SQLException {
        controller= LibroController.getController();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idDaModificare=Integer.parseInt(request.getParameter("modificaId"));
		try {
			Libro l= controller.getLibroById(idDaModificare);
			request.setAttribute("id", l.getId());
			request.setAttribute("titolo", l.getTitolo());
			request.setAttribute("prezzo", l.getPrezzo());
			request.setAttribute("pagine", l.getPagine());
		} catch (SQLException e) {
			
			e.printStackTrace();
			request.setAttribute("avvisoMessaggio", e.getMessage());
		}
		request.getRequestDispatcher("modificaLibro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int id = Integer.parseInt(request.getParameter("id"));
		String titolo=request.getParameter("titolo");
		Double prezzo=Double.parseDouble(request.getParameter("prezzo"));
		int pagine=Integer.parseInt(request.getParameter("pagine"));
		
			int nRigheAggiornate=controller.updateLibro(id, titolo, prezzo, pagine);
			if(nRigheAggiornate==1)
				request.setAttribute("avvisoMessaggio", "Libro aggiornato con successo");
			else
				request.setAttribute("avvisoMessaggio", "Anomalia, aggiornati "+nRigheAggiornate+" records.");
		} catch (SQLException e) {
			
			e.printStackTrace();
			request.setAttribute("avvisoMessaggio", e.getMessage());
		}
		request.getRequestDispatcher("listaLibri").forward(request, response);
	}

}
