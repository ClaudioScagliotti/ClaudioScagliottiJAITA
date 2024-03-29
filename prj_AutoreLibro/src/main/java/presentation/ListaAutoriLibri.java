package presentation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AutoreLibro;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import controller.AutoreController;
import controller.AutoreLibroController;

@WebServlet("/listaAutoriLibri")
public class ListaAutoriLibri extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private AutoreLibroController controller;
    
    public ListaAutoriLibri() throws ClassNotFoundException, SQLException {
    	controller= AutoreLibroController.getController();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AutoreLibro> listaAutoriLibri;
		try {
			listaAutoriLibri= controller.getAllAutoriLibri();
			request.setAttribute("listaAutoriLibri", listaAutoriLibri); 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		request.getRequestDispatcher("autoreLibro.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
