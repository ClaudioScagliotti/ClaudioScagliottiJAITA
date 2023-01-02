package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Database;
import model.Prodotto;
import model.Spesa;

import java.io.IOException;
import java.util.List;

@WebServlet("/totaleSpesa")
public class TotaleMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TotaleMVC() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Database db= Database.getDatabase();
		
		double tot= db.getTot();
		request.setAttribute("totale",tot);
		Spesa s= new Spesa(tot, false);
		request.setAttribute("spesa", s);
		request.getRequestDispatcher("totaleSpesa.jsp").forward(request, response);
		//response.sendRedirect("pagamento.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
