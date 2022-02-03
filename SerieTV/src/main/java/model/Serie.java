package model;

public class Serie {
 private String titolo;
 private String genere;
 private int stagioni;
 private int anno_inizio;
 private int valutazione;
 private int episodi;
 private Boolean finita;
public Serie(String titolo, String genere) {
	super();
	this.titolo = titolo;
	this.genere = genere;
	
}
public String getTitolo() {
	return titolo;
}
public void setTitolo(String titolo) {
	this.titolo = titolo;
}
public String getGenere() {
	return genere;
}
public void setGenere(String genere) {
	this.genere = genere;
}
public int getValutazione() {
	return valutazione;
}
public void setValutazione(int valutazione) {
	this.valutazione = valutazione;
}
 
}
