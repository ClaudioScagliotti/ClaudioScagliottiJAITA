package model;

public class ColonninaElettrica extends Distributore{

	public ColonninaElettrica(String nomeDistributore, String indirizzo, int numeroPompe, int capacitaBenzTotale,
			int capacitaDieselTotale) {
		super(nomeDistributore, indirizzo, numeroPompe, capacitaBenzTotale, capacitaDieselTotale);

	}

	@Override
	public String toString() {
		return "Distributore " + nomeDistributore + ", all'indirizzo: " + indirizzo +
				".\n Numero di pompe: "+ numeroPompe + ", capacita' benzina totale:" 
				+ capacitaBenzTotale + ", capacita' Diesel totale:"
				+ capacitaDieselTotale + "\n Capacita' attuale di Benzina:"
				+ capacitaBenz + ", capacita' attuale di Diesel:" + capacitaDiesel+
				"\n E' inoltre possibile effettuare la ricarica di veicoli elettrici";

	}

	public String usoElettrico(int quantita) {

		storico+="Venduti "+ quantita+ " kilowatt\n";



		return storico;
	}
}
