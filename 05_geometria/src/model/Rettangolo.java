package model;

public class Rettangolo extends FiguraGeometrica{
	private Segmento base, altezza;

	public Rettangolo(Segmento base, Segmento altezza) {
		this.base = base;
		this.altezza = altezza;
		this.nomeForma="Rettangolare";
	}
	public double perimetro()
	{
		return 2*(base.Lunghezza()+altezza.Lunghezza());
	}
	
	public double area()
	{
		System.out.println("Ho applicato la formula del rettangolo");
		return (base.Lunghezza() * altezza.Lunghezza());
	}
}
