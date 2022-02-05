package model;

public class Serie {
 private String titolo;
 private String genere;
 private int stagioni;
 private int anno_inizio;
 private int valutazione;
 private int episodi;
 private Boolean finita;
 private String descrizione;

public Serie(String titolo, String genere, int stagioni, int anno_inizio, int episodi, Boolean finita) {
	this.titolo = titolo;
	this.genere = genere;
	this.stagioni = stagioni;
	this.anno_inizio = anno_inizio;
	this.episodi = episodi;
	this.finita = finita;
}
public String getTitolo() {
	return titolo;
}

public String getGenere() {
	return genere;
}

public int getValutazione() {
	return valutazione;
}
public void setValutazione(int valutazione) {
	this.valutazione = valutazione;
}
public int getStagioni() {
	return stagioni;
}

public int getAnno_inizio() {
	return anno_inizio;
}

public int getEpisodi() {
	return episodi;
}

public Boolean getFinita() {
	return finita;
}
public String getDescrizione() {
	return descrizione;
}
public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}


}
