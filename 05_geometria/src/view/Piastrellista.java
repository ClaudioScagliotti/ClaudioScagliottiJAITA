package view;

import java.util.Scanner;
import java.lang.String;
import model.FiguraGeometrica;

public class Piastrellista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Quante stanze ha l'appartamento?");
		int nStanze = sc.nextInt();
		sc.nextLine();
		
		FiguraGeometrica[] stanze= new FiguraGeometrica[nStanze];
		for(int i=0; i<stanze.length; i++)
		{
			System.out.println("Che forma ha la stanza "+i+"? (t, q, r");
			String formaStanza= sc.next();
			sc.nextLine();
		}
		
		
		if(formaStanza.equals("t"))
		{
			System.out.println("dimensione lato 1 in cm");
			int lato1= sc.nextInt();
			sc.nextLine();
			System.out.println("dimensione lato 2 in cm");
			int lato2= sc.nextInt();
			sc.nextLine();
			System.out.println("dimensione lato 3 in cm");
			int lato3= sc.nextInt();
			sc.nextLine();
			
		} else 
			if (formaStanza.equals("q")) {
				
				System.out.println("dimensione lato in cm");
				double lato= sc.nextDouble();
				sc.nextLine();
			}else 
				if(formaStanza.equals("r")) {
					System.out.println("dimensione lato lungo in cm");
					double latoLungo= sc.nextDouble();
					sc.nextLine();
					System.out.println("dimensione lato corto in cm");
					double latoCorto= sc.nextDouble();
					sc.nextLine();
				}
		
	}

}
