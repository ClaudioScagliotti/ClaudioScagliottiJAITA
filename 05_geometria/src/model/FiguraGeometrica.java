package model;

public class FiguraGeometrica {
	public double area() {
		
		return 0;
	}
	protected String nome;
		protected String nomeForma;
		@Override
		public String toString() {
			return "FiguraGeometrica [nome=" + nome + ", nomeForma=" + nomeForma + "] ha superficie di "+area() ;
		}
		
}
