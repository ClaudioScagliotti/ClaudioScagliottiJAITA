package view;
import model.FiguraGeometrica;
import model.Punto;
import model.Quadrato;
import model.Rettangolo;
import model.Segmento;
import model.Triangolo;
public class Geometriademo {
	public static void main(String[] args) {
Punto a=new Punto(4,3);
Punto b=new Punto(4,6);
Punto c=new Punto(8,6);
System.out.println("Punto a:"+a.toString());
System.out.println("Punto b:"+b.toString());
Segmento ab=new Segmento(a,b);
Segmento bc=new Segmento(a,b);
Segmento ac=new Segmento(a,b);
Triangolo t= new Triangolo(a,b,c);
System.out.println("perimetro:"+t.perimetro());
System.out.println("somma lati:"+ab.Lunghezza()+" + "+ac.Lunghezza()+" + "+bc.Lunghezza());
Rettangolo r= new Rettangolo(ab,bc);
System.out.println("Perimetro rettangolo : "+r.perimetro()+"  Area rettangolo: "+r.area());
	Quadrato q= new Quadrato(ab);
	System.out.println("Perimetro quadrato : "+q.perimetro()+"  Area quadrato: "+q.area());
	
	Rettangolo rq= new Quadrato(ab);
	System.out.println("Perimetro quadrato : "+rq.perimetro()+"  Area quadrato: "+rq.area());

	FiguraGeometrica[] stanze= new FiguraGeometrica[4];
	stanze[0]= new Rettangolo(ab, bc);
	stanze[1]= new Quadrato(ab);
	stanze[2]= new Triangolo(a,b,c);
	stanze[3]= new Quadrato(ac);
	double superficie=0;
	
	for(FiguraGeometrica fg: stanze)
	{
		superficie+= fg.area();
	}
	System.out.println("la superficie complessiva è "+superficie);
	}
	
}
