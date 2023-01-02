package presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Autore;

import java.io.IOException;
import java.sql.SQLException;

import controller.AutoreController;

@WebServlet("/modificaAutore")
public class ModificaAutore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AutoreController controller; 
   
    public ModificaAutore() throws ClassNotFoundException, SQLException {
    	controller= AutoreController.getController();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idDaModificare=Integer.parseInt(request.getParameter("modificaId"));
		try {
			Autore a= controller.getAutoreById(idDaModificare);
			request.setAttribute("id", a.getId());
			request.setAttribute("nome", a.getNome());
			request.setAttribute("cognome", a.getCognome());
			request.setAttribute("nazionalita", a.getNazionalita());
		} catch (SQLException e) {
			
			e.printStackTrace();
			request.setAttribute("avvisoMessaggio", e.getMessage());
		}
		request.getRequestDispatcher("modificaAutore.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String nome=request.getParameter("nome");
			String cognome=request.getParameter("cognome");
			String nazionalita=request.getParameter("nazionalita");
		
			int nRigheAggiornate=controller.updateAutore(id, nome, cognome, nazionalita);
			
			if(nRigheAggiornate==1)
				request.setAttribute("avvisoMessaggio", "Autore aggiornato con successo");
			else
				request.setAttribute("avvisoMessaggio", "Anomalia, aggiornati "+nRigheAggiornate+" records.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("avvisoMessaggio", e.getMessage());
		}
		request.getRequestDispatcher("listaAutori").forward(request, response);
	}

}
