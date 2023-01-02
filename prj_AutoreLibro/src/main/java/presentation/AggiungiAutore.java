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

@WebServlet("/aggiungiAutore")
public class AggiungiAutore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AutoreController controller; 
    
    public AggiungiAutore() throws ClassNotFoundException, SQLException {
    	controller= AutoreController.getController();
     
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nome=request.getParameter("nome");
			String cognome=request.getParameter("cognome");
			String nazionalita=request.getParameter("nazionalita");
			
			boolean inserito=controller.insertAutore(nome, cognome, nazionalita);
			if(inserito)
				request.setAttribute("avvisoMessaggio", "Autore inserito con successo");
			else
				request.setAttribute("avvisoMessaggio", "Anomalia, autore non inserito.");
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("avvisoMessaggio", e.getMessage());
		}
		
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}

	
	}


