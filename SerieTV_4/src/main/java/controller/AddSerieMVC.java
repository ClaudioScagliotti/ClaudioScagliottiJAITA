package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Serie;

import java.io.IOException;

@WebServlet("/addSerie")
public class AddSerieMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SerieTVCTRL ctrl;
       
    
    public AddSerieMVC() {
        this.ctrl=new SerieTVCTRL();
        System.out.println("Ho creato la servlet  per aggiungere e inizializzato il controller");
     
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.ctrl.addSerie(request.getParameter("titolo"),request.getParameter("genere") );
		request.getRequestDispatcher("elenco.jsp").forward(request, response);
		
		
	}

}
