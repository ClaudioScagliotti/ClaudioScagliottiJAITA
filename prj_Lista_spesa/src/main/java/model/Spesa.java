package model;

public class Spesa {
	private double totale;
	private boolean pagata;
	private double importo;
	public Spesa(double totale, boolean pagata) {
		super();
		this.totale = totale;
		this.pagata = pagata;
	}
	public double getTotale() {
		return totale;
	}
	public void setTotale(double totale) {
		this.totale = totale;
	}
	public boolean isPagata() {
		return pagata;
	}
	public void setPagata(boolean pagata) {
		this.pagata = pagata;
	}
	public double getImporto() {
		return importo;
	}
	public void setImporto(double importo) {
		this.importo = importo;
	}
	
	
}

