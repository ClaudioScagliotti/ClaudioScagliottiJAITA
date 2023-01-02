package model;

public class Quadrato extends Rettangolo {
	private Segmento lato;
	
	public Quadrato(Segmento lato) {
		super(lato, lato);
		this.lato=lato;
		this.nomeForma="Quadrata";
		
	}

	@Override
	public double area() {
		System.out.println("Ho applicato la formula del quadrato");
		return Math.pow(lato.Lunghezza(), 2);
	}
	
}
