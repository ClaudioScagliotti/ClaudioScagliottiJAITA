package model;
import java.util.ArrayList;
import java.util.List;
public class Database {
	private static Database instance;
	private static List<Prodotto> listaProdotti;
	private static Spesa spesa;
	 private Database() {
			listaProdotti.add(new Prodotto(0,"Banana", 1.00, "frutta"));
			listaProdotti.add(new Prodotto(1,"Biscotti", 2.00, "dolci"));
			listaProdotti.add(new Prodotto(2,"Carota", 0.80, "verdura"));
			listaProdotti.add(new Prodotto(3,"Pasta", 0.70, "cibo"));
			listaProdotti.add(new Prodotto(4,"Mela", 1.00, "frutta"));
			Spesa spesa= new Spesa(0,false);
			
			

	 }
	public static Database getDatabase() {
		if(instance==null) {
			listaProdotti= new ArrayList<Prodotto>();
			
			instance=new Database();
			
		
		}

		return instance;
	}
	
	public List<Prodotto> getLista(){
		return listaProdotti;
	}
	
	public double getTot(){
		double tot=0;
		for(Prodotto p: listaProdotti) {
			double prezzo = p.getPrezzo();
			 tot+= prezzo;
			
		}
		return tot;
	}
}
