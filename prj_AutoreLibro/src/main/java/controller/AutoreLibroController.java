package controller;
 
import java.sql.SQLException;
import java.util.List;

import model.AutoreLibro;
import repository.Database;
 
public class AutoreLibroController {
 
	private static AutoreLibroController instance;
 
	private Database db;
 
	public AutoreLibroController() throws ClassNotFoundException, SQLException {
		db = Database.getDatabase();
	}
 
	public static AutoreLibroController getController() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new AutoreLibroController();
		}
		return instance;
	}	
 
	public List<AutoreLibro> getAllAutoriLibri() throws SQLException{
		return db.getAllAutoriLibri();
	}
	
	public boolean insertAutoreLibro(int libro_id, int autore_id) throws SQLException {
		AutoreLibro daInserire= new AutoreLibro();
		daInserire.setAlLibroId(libro_id);
		daInserire.setAlAutoreId(autore_id);
		return db.insertAutoreLibro(daInserire);
		
	}
	
	public boolean deleteAutoreLibroAutoreId(int autore_id) throws SQLException {
		
		db.deleteAutoreLibroAutoreId(autore_id);
		return true;
	
	}
}
 