package model;

public class Distributore {
	protected String nomeDistributore;
	protected String indirizzo;
	protected int numeroPompe;
	protected int capacitaBenzTotale;
	protected int capacitaDieselTotale;
	protected int capacitaBenz=0;
	protected int capacitaDiesel=0;
	protected String storico="";
	public Distributore(String nomeDistributore, String indirizzo, int numeroPompe, int capacitaBenzTotale,
			int capacitaDieselTotale) {
		super();
		this.nomeDistributore = nomeDistributore;
		this.indirizzo = indirizzo;
		this.numeroPompe = numeroPompe;
		this.capacitaBenzTotale = capacitaBenzTotale;
		this.capacitaDieselTotale = capacitaDieselTotale;
	}
	public int getCapacitaBenz() {
		return capacitaBenz;
	}
	public void setCapacitaBenz(int capacitaBenz) {
		this.capacitaBenz = capacitaBenz;
	}
	public int getCapacitaDiesel() {
		return capacitaDiesel;
	}
	public void setCapacitaDiesel(int capacitaDiesel) {
		this.capacitaDiesel = capacitaDiesel;
	}
	public String getNomeDistributore() {
		return nomeDistributore;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public int getNumeroPompe() {
		return numeroPompe;
	}
	public int getCapacitaBenzTotale() {
		return capacitaBenzTotale;
	}
	public int getCapacitaDieselTotale() {
		return capacitaDieselTotale;
	}
	@Override
	public String toString() {
		return "Distributore " + nomeDistributore + ", all'indirizzo: " + indirizzo + ".\n Numero di pompe: "
				+ numeroPompe + ", capacita' benzina totale:" + capacitaBenzTotale + ", capacita' Diesel totale:"
				+ capacitaDieselTotale + "\n Capacita' attuale di Benzina:" + capacitaBenz + ", capacita' attuale di Diesel:" + capacitaDiesel;
	}

	public String CaricamentoBenz(int quantita) {
		if((capacitaBenz+quantita)<capacitaBenzTotale) {
			this.capacitaBenz+=quantita;
			storico+="Caricati "+ quantita+ " litri di benzina\n";
		} else {
			storico+="Caricati "+ (capacitaBenzTotale-capacitaBenz)+ " litri di benzina \n";
			capacitaBenz=capacitaBenzTotale;
		}
		return storico;
	}
	public String CaricamentoDiesel(int quantita) {
		if((capacitaDiesel+quantita)<capacitaDieselTotale) {
			this.capacitaDiesel+=quantita;
			storico+="Caricati "+ quantita+ " litri di diesel\n";
		} else {
			storico+="Caricati "+ (capacitaDieselTotale-capacitaDiesel)+ " litri di diesel \n";
			capacitaDiesel=capacitaDieselTotale;
		}
		return storico;
	}

	public String PrelievoBenz(int quantita) {
		if((capacitaBenz-quantita)>0) {
			this.capacitaBenz-=quantita;
			storico+="Venduti "+ quantita+ " litri di benzina\n";
		} else {

			storico+="Venduti "+ (capacitaBenz)+ " litri di benzina \n";
			capacitaBenz=0;
		}
		return storico;
	}

	public String PrelievoDiesel(int quantita) {
		if((capacitaDiesel-quantita)>0) {
			this.capacitaDiesel-=quantita;
			storico+="Venduti "+ quantita+ " litri di diesel\n";
		} else {
			storico+="Venduti "+ (capacitaDiesel)+ " litri di diesel \n";
			capacitaDiesel=0;
		}
		return storico;
	}
	public String getStorico() {
		return storico;
	}




}
