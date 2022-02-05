package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/elenco")

public class SerieTVMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SerieTVCTRL ctrl;
       
    
    public SerieTVMVC() {
        this.ctrl=new SerieTVCTRL();
        System.out.println("Ho creato la servlet e inizializzato il controller");
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("elencoSerie", this.ctrl.getls());
		request.getRequestDispatcher("elenco.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("elencoSerie", this.ctrl.getls(request.getParameter("genere")));
		request.getRequestDispatcher("elenco.jsp").forward(request, response);
		doGet(request, response);
	}

}
