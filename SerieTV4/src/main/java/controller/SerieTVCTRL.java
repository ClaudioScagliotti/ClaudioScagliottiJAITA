package controller;

import java.util.ArrayList;
import java.util.List;


import model.Serie;

public class SerieTVCTRL {
	private static List<Serie> ls;
	public SerieTVCTRL() {
		if(ls==null) {
			ls=new ArrayList<Serie>();
			//e(String titolo, String genere, int stagioni, int anno_inizio, int episodi, Boolean finita)
			ls.add(new Serie("Breaking bad","drammatico",5,2002,50,true));
			ls.add(new Serie("Black Mirror","distopico", 5, 2010, 60, false));
			ls.add(new Serie("Twin Peaks","mistero",3,1991, 30,true));
			ls.add(new Serie("How I Met Your Mother","sitcom",5,2002,100,true));
			ls.add(new Serie("Friends","sitcom",10,1990,100,true));
			ls.add(new Serie("Rick e Morty","animazione",5,2020,40,false));
			ls.add(new Serie("Peaky Blinders","drammatico",5,2015,30,false));
			ls.add(new Serie("Mindhunter","drammatico",2,2018,20,true));
			
			
		}
	}
	
	public void addSerie(String titolo, String genere, int stagioni, int anno_inizio, int episodi, Boolean finita) {
		Serie s1= new Serie(titolo,genere, stagioni, anno_inizio,  episodi,  finita);
		ls.add(s1);
	}
	
	public List<Serie> getls(){
		return ls;
	}
	
	
	public List<Serie> getls(String genere){
		if(!genere.equals("")) {
			List<Serie> serieGenere= new ArrayList<Serie>();
			for(Serie s1: this.ls) {
				if(s1.getGenere().equals(genere)){
					serieGenere.add(s1);
				}
			}
			return serieGenere;
		} else {
			return ls;
		}
			
		}
	
	
	



}
