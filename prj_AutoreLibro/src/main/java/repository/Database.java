package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Autore;

import model.AutoreLibro;

import model.Libro;



public class Database {

	private static Database instance;
	private Connection con;
	
	private final static String DB_URL = "jdbc:mysql://localhost:3306/generation";
	private final static String DB_USER = "app_generation";
	private final static String DB_PASSWORD = "generation_2022";
	private final static String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	private Database() throws SQLException, ClassNotFoundException {
		Class.forName(DB_DRIVER);
		con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}
	
	public static Database getDatabase() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}
	
	
	
	public List<Libro> getAllLibri() throws SQLException{
		String sql="SELECT id, titolo, prezzo, pagine"+ " FROM generation.libro ";
		
		PreparedStatement istruzione= con.prepareStatement(sql);		
		
		//executeQuery si usa per le SELECT
		ResultSet risultatiQuery=istruzione.executeQuery();
		
		//Monto una lista vuota di studenti
		List<Libro> listaLibri=new ArrayList<>();
		
		while(risultatiQuery.next()) {
			//Per ogni record che arriva da DB istanzio uno studente
			Libro rstu=new Libro();
			//Ci imposto dentro le varie colonne della sua riga
			rstu.setId(risultatiQuery.getInt("id"));
			rstu.setTitolo(risultatiQuery.getString("titolo"));
			rstu.setPrezzo(risultatiQuery.getDouble("prezzo"));
			rstu.setPagine(risultatiQuery.getInt("pagine"));
			
			//Lo aggiungo alla lista degli studenti
			listaLibri.add(rstu);
		}
		
		//Quando ho finito di leggere cosa mi è arrivato dal DB
		//ritorno al chiamante la lista di studenti
		return listaLibri;
	}
	
	public List<Autore> getAllAutori() throws SQLException{
		String sql="SELECT id,nome, cognome, nazionalita"+ " FROM generation.autore ";
		
		PreparedStatement istruzione= con.prepareStatement(sql);		
		
		//executeQuery si usa per le SELECT
		ResultSet risultatiQuery=istruzione.executeQuery();
		
		//Monto una lista vuota di studenti
		List<Autore> listaAutori=new ArrayList<>();
		
		while(risultatiQuery.next()) {
			//Per ogni record che arriva da DB istanzio uno studente
			Autore rstu=new Autore();
			//Ci imposto dentro le varie colonne della sua riga
			rstu.setId(risultatiQuery.getInt("id"));
			rstu.setNome(risultatiQuery.getString("nome"));
			rstu.setCognome(risultatiQuery.getString("cognome"));
			rstu.setNazionalita(risultatiQuery.getString("nazionalita"));
			
			//Lo aggiungo alla lista degli studenti
			listaAutori.add(rstu);
		}
		
		//Quando ho finito di leggere cosa mi è arrivato dal DB
		//ritorno al chiamante la lista di studenti
		return listaAutori;
	}
	public List<AutoreLibro> getAllAutoriLibri() throws SQLException{
		String sql="SELECT al.autore_id,"
				+ " al.libro_id,"
				+ " a.cognome,"
				+ " l.titolo,"
				+ " l.prezzo "
				+ "FROM generation.autore_libro al"
				+ " JOIN generation.autore a ON (a.id=al.autore_id)"
				+ " JOIN generation.libro l ON (l.id= al.libro_id)";
			PreparedStatement istruzione= con.prepareStatement(sql);		
		
		//executeQuery si usa per le SELECT
			ResultSet risultatiQuery=istruzione.executeQuery();
		
		List<AutoreLibro> listaAutoreLibro= new ArrayList<>();
		while(risultatiQuery.next()) {
			AutoreLibro rstu= new AutoreLibro();
			rstu.setAlAutoreId(risultatiQuery.getInt("autore_id"));
			rstu.setAlLibroId(risultatiQuery.getInt("autore_id"));
			rstu.setaCognome(risultatiQuery.getString("cognome"));
			rstu.setlTitolo(risultatiQuery.getString("titolo"));
			rstu.setlPrezzo(risultatiQuery.getDouble("prezzo"));
			listaAutoreLibro.add(rstu);
		}
		
		return listaAutoreLibro;
	}
	
	public int getAutoriInAutoriLibri(int idAutore) throws SQLException {
		String sql="SELECT count(*) AS counter FROM generation.autore_libro al WHERE al.autore_id = ?";
		PreparedStatement istruzione= con.prepareStatement(sql);
		istruzione.setInt(1, idAutore);
		ResultSet risultatiQuery=istruzione.executeQuery();
		int counter=0;
		while(risultatiQuery.next()) {
			
			counter= risultatiQuery.getInt("counter");
			
		}
		
		return counter;
	}
	
	
	public int getLibriInAutoriLibri(int idLibro) throws SQLException {
		String sql="SELECT count(*) AS counter FROM generation.autore_libro al WHERE al.libro_id = ?";
		PreparedStatement istruzione= con.prepareStatement(sql);
		istruzione.setInt(1, idLibro);
		ResultSet risultatiQuery=istruzione.executeQuery();
		int counter=0;
		while(risultatiQuery.next()) {
			
			counter= risultatiQuery.getInt("counter");
			
		}
		
		return counter;
	}
	
	
	
	
	
	public int deleteAutore(int idAutore) throws SQLException {
		String sql="DELETE FROM generation.autore WHERE id= ?";
		PreparedStatement istruzione= con.prepareStatement(sql);
		istruzione.setInt(1, idAutore);
		return istruzione.executeUpdate();
		
		
	}
	public int deleteLibro(int idLibro) throws SQLException {
		String sql="DELETE FROM generation.libro WHERE id= ?";
		PreparedStatement istruzione= con.prepareStatement(sql);
		istruzione.setInt(1, idLibro);
		return istruzione.executeUpdate();
		
		
	}
	
	public int deleteAutoreLibroAutoreId(int autore_id) throws SQLException {
		String sql="DELETE FROM autore_libro WHERE autore_id=?";
		PreparedStatement istruzione= con.prepareStatement(sql);
		istruzione.setInt(1, autore_id);
		return istruzione.executeUpdate();
	}
	/*public int deleteAutoreLibroLibroId(int libro_id) throws SQLException {
		String sql="DELETE FROM autore_libro WHERE libro_id=?";
		PreparedStatement istruzione= con.prepareStatement(sql);
		istruzione.setInt(1, libro_id);
		return istruzione.executeUpdate();
		
	}
	*/
	
	
	public boolean insertAutoreLibro(AutoreLibro al) throws SQLException {
		String sql="INSERT INTO generation.autore_libro (libro_id, autore_id) VALUES (?, ?);";
		PreparedStatement istruzione= con.prepareStatement(sql);
		
		istruzione.setInt(1, al.getAlLibroId());
		istruzione.setInt(2, al.getAlLibroId());
		int numRigheModificate=istruzione.executeUpdate();
		if(numRigheModificate==1) return true;
		
		return false;
		
	}
	
	
	
	public boolean insertLibro(Libro l) throws SQLException{
		String sql="INSERT INTO generation.libro (titolo, prezzo, pagine) VALUES (?, ?, ?);";
		
		PreparedStatement istruzione= con.prepareStatement(sql);
		
		
		istruzione.setString(1, l.getTitolo());
		istruzione.setDouble(2, l.getPrezzo());
		istruzione.setInt(3, l.getPagine());
	
		
		//executeUpdate si usa per INSERT, UPDATE, DELETE
		int numRigheModificate=istruzione.executeUpdate();
		
		if(numRigheModificate==1) return true;
		
		return false;
	}
	
	public boolean insertAutore(Autore l) throws SQLException{
		String sql="INSERT INTO generation.autore (nome, cognome, nazionalita) VALUES (?, ?, ?);";
		
		PreparedStatement istruzione= con.prepareStatement(sql);
		
		
		istruzione.setString(1, l.getNome());
		istruzione.setString(2, l.getCognome());
		istruzione.setString(3, l.getNazionalita());
	
		
		//executeUpdate si usa per INSERT, UPDATE, DELETE
		int numRigheModificate=istruzione.executeUpdate();
		
		if(numRigheModificate==1) { return true;}
		
		return false;
	}
	
	public Autore getAutoreById(int id) throws SQLException{
		String sql="SELECT id, nome, cognome, nazionalita"
				+ " FROM generation.autore "
				+ " WHERE id=? ; ";
		
		PreparedStatement istruzione= con.prepareStatement(sql);		
		istruzione.setInt(1, id);
		
		//executeQuery si usa per le SELECT
		ResultSet risultatiQuery=istruzione.executeQuery();
		while(risultatiQuery.next()) {
			Autore rstu=new Autore();
			rstu.setId(risultatiQuery.getInt("id"));
			rstu.setNome(risultatiQuery.getString("nome"));
			rstu.setCognome(risultatiQuery.getString("cognome"));
			rstu.setNazionalita(risultatiQuery.getString("nazionalita"));
			return rstu;
		}
		
		return null;
	}
	
	public int updateAutore(Autore stu) throws SQLException{
		String sql="UPDATE generation.autore "
				+ " SET nome=?, cognome=?, nazionalita=? "
				+ " WHERE id=? ; ";
		
		PreparedStatement istruzione= con.prepareStatement(sql);
		
		istruzione.setString(1, stu.getNome());
		istruzione.setString(2, stu.getCognome());
		istruzione.setString(3, stu.getNazionalita());
		istruzione.setInt(4, stu.getId());
		
		//executeUpdate si usa per INSERT, UPDATE, DELETE
		return istruzione.executeUpdate();
		
	}
	
	public Libro getLibroById(int id) throws SQLException{
		String sql="SELECT id, titolo, prezzo, pagine"
				+ " FROM generation.libro "
				+ " WHERE id=? ; ";
		
		PreparedStatement istruzione= con.prepareStatement(sql);		
		istruzione.setInt(1, id);
		
		//executeQuery si usa per le SELECT
		ResultSet risultatiQuery=istruzione.executeQuery();
		while(risultatiQuery.next()) {
			Libro rstu=new Libro();
			rstu.setId(risultatiQuery.getInt("id"));
			rstu.setTitolo(risultatiQuery.getString("titolo"));
			rstu.setPrezzo(Double.parseDouble(risultatiQuery.getString("prezzo")));
			rstu.setPagine(Integer.parseInt(risultatiQuery.getString("pagine")));
			return rstu;
		}
		
		return null;
	}
	
	public int updateLibro(Libro stu) throws SQLException{
		String sql="UPDATE generation.libro "
				+ " SET titolo=?, prezzo=?, pagine=? "
				+ " WHERE id=? ; ";
		
		PreparedStatement istruzione= con.prepareStatement(sql);
		
		istruzione.setString(1, stu.getTitolo());
		istruzione.setDouble(2, stu.getPrezzo());
		istruzione.setInt(3, stu.getPagine());
		istruzione.setInt(4, stu.getId());
		
		//executeUpdate si usa per INSERT, UPDATE, DELETE
		return istruzione.executeUpdate();
		
	}
	
	
	
	
	
}
