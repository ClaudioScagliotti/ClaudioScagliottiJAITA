package controller;

import java.util.ArrayList;
import java.util.List;


import model.Serie;

public class SerieTVCTRL {
	private static List<Serie> ls;
	
	


	public SerieTVCTRL() {
		if(ls==null) {
			ls=new ArrayList<Serie>();
			ls.add(new Serie("Breaking bad","drammatico"));
		}
	}
	
	public void addSerie(String titolo, String genere) {
		Serie s1= new Serie(titolo,genere);
		ls.add(s1);
	}
	
	public List<Serie> getls(){
		return ls;
	}
	
	
	public List<Serie> getls(String genere){
		
			List<Serie> serieGenere= new ArrayList<Serie>();
			for(Serie s1: this.ls) {
				if(s1.getGenere().equals(genere)){
					serieGenere.add(s1);
				}
			}
			return serieGenere;
		}


}
