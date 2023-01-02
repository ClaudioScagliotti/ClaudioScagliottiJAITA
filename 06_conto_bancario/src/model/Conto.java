package model;
import java.util.Scanner;

public class Conto {
private int numeroConto;
public String nome_cliente;
public String cognome_cliente;
private int password;
private int saldo;
private boolean accesso=false;
int password1;
public Conto(String nome_cliente,String cognome_cliente) {
	this.nome_cliente=nome_cliente;
	this.cognome_cliente=cognome_cliente;
	this.numeroConto=createNumero();
	Scanner sc= new Scanner(System.in);
	System.out.println("Inserire nuova password:");
	this.password = sc.nextInt();
	sc.nextLine();
	System.out.println("Confermare la password:");
	do {
	password1 = sc.nextInt();
	sc.nextLine();
	if(this.password!=password1) System.out.println("Le password inserite non coincidono, riprovare:");
	
	} while(password!=password1);
	sc.close();
	System.out.println("Conto attivato correttamente, fai l'accesso per eseguire operazioni");	
}
public int createNumero()
{
	int numero=(int) (1000000*Math.random());
	System.out.println("Il tuo numero di conto è: "+numero);
	return numero;
	
}

public void accesso(int numeroC, int password) {
	
	if (this.numeroConto==numeroC) {
		System.out.println("Inserisci la password:");
		if (this.password==password) {
			System.out.println("Complimenti sei entrato");
			 accesso=true;
		}else System.out.println("Password errata");
	}else System.out.println("Numero di conto errato");
	this.accesso=true;
}

public void versamento(int cifra) {
	if(accesso) {
		this.saldo+=cifra;
		System.out.println("Ora il tuo saldo è:"+this.saldo);
	}else System.out.println("Devi eseguire l'accesso per operare sul conto");
}

public void prelievo(int cifra) {
	if(accesso) {
		if(this.saldo>cifra) {
			this.saldo-=cifra;
			System.out.println("Ora il tuo saldo è:"+this.saldo);
		} else System.out.println("Saldo non sufficiente");
	}else System.out.println("Devi eseguire l'accesso per operare sul conto");
}








}
