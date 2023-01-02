package model;

public class Triangolo extends FiguraGeometrica{
	private Punto a,b,c;
	private Segmento ab,bc,ac;
	public Triangolo(Punto a,Punto b, Punto c) {
		this.a=a;
		this.b=b;
		this.c=c;	
		
		this.ab=new Segmento(a,b);
		this.ac=new Segmento(a,c);
		this.bc=new Segmento(b,c);
		this.nomeForma= "Triangolare";
	}
	
	public Triangolo(Segmento ab, Segmento bc, Segmento ac) {
		this.ab=ab;
		this.bc=bc;
		this.ac=ac;
	}
	public double perimetro() {
		double perimetro=ab.Lunghezza()+ac.Lunghezza()+bc.Lunghezza();
		return perimetro;
	}
	
}
