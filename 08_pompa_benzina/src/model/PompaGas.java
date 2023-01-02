package model;

public class PompaGas extends Distributore{
	private int capacitaGasTotale;
	private int capacitaGas=0;
	public PompaGas(String nomeDistributore, String indirizzo, int numeroPompe, int capacitaBenzTotale,
			int capacitaDieselTotale, int capacitaGasTotale) {
		super(nomeDistributore, indirizzo, numeroPompe, capacitaBenzTotale, capacitaDieselTotale);
		this.capacitaGasTotale = capacitaGasTotale;	
	}
	public int getCapacitaGas() {
		return capacitaGas;
	}
	public void setCapacitaGas(int capacitaGas) {
		this.capacitaGas = capacitaGas;
	}
	public int getCapacitaGasTotale() {
		return capacitaGasTotale;
	}
	@Override
	public String toString() {
		return "Distributore " + nomeDistributore + ", all'indirizzo: " + indirizzo + ".\n Numero di pompe: "
				+ numeroPompe + ", capacita' benzina totale:" + capacitaBenzTotale + ", capacita' Diesel totale:"
				+ capacitaDieselTotale + "\n Capacita' attuale di Benzina:" 
				+ capacitaBenz + ", capacita' attuale di Diesel:" 
				+ capacitaDiesel+ "\n Distributore di gas: \n capacita' totale: "
				+ capacitaGasTotale + ", capacita' attuale:" + capacitaGas;
	}

	public String CaricamentoGas(int quantita) {
		if((capacitaGas+quantita)<capacitaGasTotale) {
			this.capacitaGas+=quantita;
			storico+="Caricati "+ quantita+ " metri cubi di gas\n";
		} else {
			storico+="Caricati "+ (capacitaGasTotale-capacitaGas)+ " metri cubi di gas \n";
			capacitaGas=capacitaGasTotale;
		}
		return storico;
	}


	public String PrelievoGas(int quantita) {
		if((capacitaGas-quantita)>0) {
			this.capacitaGas-=quantita;
			storico+="Venduti "+ quantita+ " metri cubi di gas\n";
		} else {
			storico+="Venduti "+ (capacitaGas)+ "  metri cubi di gas\n";
			capacitaGas=0;
		}
		return storico;
	}


}
