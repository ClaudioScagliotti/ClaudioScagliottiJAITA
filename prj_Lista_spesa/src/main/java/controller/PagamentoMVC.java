package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Spesa;

import java.io.IOException;

@WebServlet("/pagamento")
public class PagamentoMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PagamentoMVC() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Spesa s= new Spesa(0, false);
		request.setAttribute("spesa", s);
		double resto=s.getImporto()-s.getTotale();
		
		if(resto>=0) {
			request.setAttribute("pagata", true);
		}
		else {
			request.setAttribute("pagata", false);
		}
		/*if(Double.parseDouble(request.getParameter("importo"))>=Double.parseDouble(request.getParameter("tot"))) {
			request.setAttribute("pagata", true);
		}
		else {
			request.setAttribute("pagata", false);
		}*/
		request.getRequestDispatcher("pagamento.jsp").forward(request, response);
		
	}

	
	

}
