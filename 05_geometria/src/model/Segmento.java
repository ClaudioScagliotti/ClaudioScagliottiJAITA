package model;

public class Segmento {
	private Punto a;
	private Punto b;
	public Segmento(Punto a, Punto b) {
		this.a = a;
		this.b = b;
	}
	
	
	public double Lunghezza() {
		double lunghezza=0;
	//lunghezza= Math.sqrt( Math.pow(b.getY(),2)+Math.pow(a.getY(),2)+Math.pow(b.getX(),2)+Math.pow(a.getX(),2));
	lunghezza = Math.sqrt(  Math.pow(b.getY() - a.getY(), 2) + Math.pow(b.getX() - a.getX(), 2));
		return lunghezza;
	}
	public Segmento(double lunghezza) {
		this.a= new Punto(0,0);
		this.b= new Punto(lunghezza,0);
	}
}
