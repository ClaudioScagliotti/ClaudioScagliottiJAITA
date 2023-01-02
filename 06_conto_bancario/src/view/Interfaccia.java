package view;
import model.Conto;
import java.util.Scanner;

public class Interfaccia {
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		//String n=nome();
		//String c=cognome();
		Conto a=new Conto(nome(),cognome());
		a.accesso(numeroC(), password());
		System.out.println("Cifra da versare:");
		a.versamento(euro());
		System.out.println("Cifra da prelevare:");
		a.prelievo(euro());
		
		}

	public static String nome() {
		System.out.println("Inserisci il tuo nome:");
		//Scanner sc= new Scanner(System.in);
		String nome = sc.nextLine();
		return nome;
	}

	public static String cognome() {
		System.out.println("Inserisci il tuo cognome:");
		//Scanner sc1= new Scanner(System.in);
		String cognome = sc.nextLine();
		return cognome;
	}
	public static int numeroC() {
		System.out.println("Inserisci il tuo numero conto:");
		//Scanner sc2= new Scanner(System.in);
		//if(sc.hasNextLine()==true) {
		int numeroC = Integer.parseInt(sc.nextLine());
		return numeroC;
		//}return 0;
	}
	public static int password() {
		System.out.println("Inserisci la tua pass:");
		//Scanner sc2= new Scanner(System.in);
		int pass = Integer.parseInt(sc.nextLine());
		return pass;
	}
	public static int euro() {
		System.out.println("Inserisci la cifra:");
		//Scanner sc3= new Scanner(System.in);
		int s = Integer.parseInt(sc.nextLine());
		return s;
	}

}