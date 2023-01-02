package presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import controller.LibroController;

@WebServlet("/aggiungiLibro")
public class AggiungiLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private LibroController controller;
   
    public AggiungiLibro() throws ClassNotFoundException, SQLException {
    	controller= LibroController.getController();
    
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String titolo=request.getParameter("titolo");
		Double prezzo=Double.parseDouble(request.getParameter("prezzo"));
		int pagine=Integer.parseInt(request.getParameter("pagine"));
		boolean inserito=controller.insertLibro(titolo, prezzo, pagine);
		if(inserito)
			request.setAttribute("avvisoMessaggio", "Libro inserito con successo");
		else
			request.getSession().setAttribute("avvisoMessaggio", "Anomalia, libro non inserito.");
		
	}catch(Exception e) {
		e.printStackTrace();
		request.setAttribute("avvisoMessaggio", e.getMessage());
	}
	
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
