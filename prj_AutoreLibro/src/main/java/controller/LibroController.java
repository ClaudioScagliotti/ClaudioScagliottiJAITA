package controller;
 
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import model.Autore;
import model.Libro;

import repository.Database;
 
public class LibroController {
 
	private static LibroController instance;
 
	private Database db;
 
	public LibroController() throws ClassNotFoundException, SQLException {
		db = Database.getDatabase();
	}
 
	public static LibroController getController() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new LibroController();
		}
		return instance;
	}	
 
	public List<Libro> getAllLibri() throws SQLException{
		return db.getAllLibri();
	}
	
	public boolean deleteLibro(int idLibro) throws SQLException {
		
		if(db.getLibriInAutoriLibri(idLibro)>0) {
			return false;
		}else {
			db.deleteLibro(idLibro);
			return true;
		}
		
	}
	
	public boolean insertLibro(String titolo, double prezzo, int pagine) throws SQLException{
		Libro daInserire=new Libro();
		
		daInserire.setTitolo(titolo);
		daInserire.setPrezzo(prezzo);
		daInserire.setPagine(pagine);

		return db.insertLibro(daInserire);
	}
	
	public Libro getLibroById(int id) throws SQLException{
		return db.getLibroById(id);
	}
	public int updateLibro(int id, String titolo, Double prezzo, int pagine) throws SQLException{
		Libro daAggiornare=new Libro();
		
		daAggiornare.setId(id);
		daAggiornare.setTitolo(titolo);
		daAggiornare.setPrezzo(prezzo);
		daAggiornare.setPagine(pagine);
	
		
		return db.updateLibro(daAggiornare);
	}
}
 
