package controller;
import java.util.Scanner;

import model.ColonninaElettrica;
import model.Distributore;
import model.PompaGas;

public class ControllerPompa {
	static Scanner sc= new Scanner(System.in);
	public static String stringa(String cosa_da_inserire) {

		switch(cosa_da_inserire) {
		case "nome":

			System.out.println("Inserisci il nome:");
			break;

		case "indirizzo":

			System.out.println("Inserisci l'indirizzo:");
			break;

		case "pompe":

			System.out.println("Inserisci il numero di pompe:");
			break;

		case "capBenzTot":

			System.out.println("Inserisci la capacità totale di benzina in litri:");
			break;

		case "capDiesTot":

			System.out.println("Inserisci la capacità totale di diesel in litri:");
			break;

		case "capBenz":

			System.out.println("Inserisci la capacità attuale di benzina in litri:");
			break;

		case "capDies":

			System.out.println("Inserisci la capacità attuale di diesel in litri:");
			break;


		case "capGas":

			System.out.println("Inserisci la capacità attuale di gas in metri cubi:");
			break;
		case "capGasTot":

			System.out.println("Inserisci la capacità totale di gas in metri cubi:");
			break;

		}

		return sc.nextLine();
	}																				//FINE FUNZIONE

	public static Distributore inizioOrd() {
		Distributore d1= new Distributore(ControllerPompa.stringa("nome"),
				ControllerPompa.stringa("indirizzo"),
				Integer.parseInt(ControllerPompa.stringa("pompe")),
				Integer.parseInt(ControllerPompa.stringa("capBenzTot")),
				Integer.parseInt(ControllerPompa.stringa("capDiesTot")));
		System.out.println(d1); 
		return d1;		
	}//fine funzione 


	public static PompaGas inizioGas() {
		PompaGas d2=new PompaGas(ControllerPompa.stringa("nome"),
				ControllerPompa.stringa("indirizzo"),
				Integer.parseInt(ControllerPompa.stringa("pompe")),
				Integer.parseInt(ControllerPompa.stringa("capBenzTot")),
				Integer.parseInt(ControllerPompa.stringa("capDiesTot")),
				Integer.parseInt(ControllerPompa.stringa("capGasTot")));
		System.out.println(d2); 
		return d2;
	}

	public static ColonninaElettrica inizioEl() {
		ColonninaElettrica d3=new ColonninaElettrica(ControllerPompa.stringa("nome"),
				ControllerPompa.stringa("indirizzo"),
				Integer.parseInt(ControllerPompa.stringa("pompe")),
				Integer.parseInt(ControllerPompa.stringa("capBenzTot")),
				Integer.parseInt(ControllerPompa.stringa("capDiesTot")));
		System.out.println(d3); 
		return d3;
	}




	public static void caricamentoOrd(Distributore d) {
		int inserimento=0;
		int quantita;
		do {
			System.out.println("Premi 1 per caricare benzina, 2 per caricare diesel 3 per uscire");
			inserimento= Integer.parseInt(sc.nextLine());
			if (inserimento==3){ break;}
			else {

				System.out.println("Scrivi la quantita che vuoi inserire in litri");
				quantita= Integer.parseInt(sc.nextLine());
				if(inserimento==1) {
					d.CaricamentoBenz(quantita);
				}else if(inserimento==2) {
					d.CaricamentoDiesel(quantita);
				} else System.out.println("Non hai inserito 1 o 2, riprova\n"); 
			}
		}while(inserimento!=3);
	}


	public static void caricamentoEl(ColonninaElettrica d) {
		int inserimento=0;
		int quantita;
		do {
			System.out.println("Premi 1 per caricare benzina, 2 per caricare diesel 3 per uscire");
			inserimento= Integer.parseInt(sc.nextLine());
			if (inserimento==3){ break;}
			else {

				System.out.println("Scrivi la quantita che vuoi inserire in litri");
				quantita= Integer.parseInt(sc.nextLine());
				if(inserimento==1) {
					d.CaricamentoBenz(quantita);
				}else if(inserimento==2) {
					d.CaricamentoDiesel(quantita);
				} else System.out.println("Non hai inserito 1 o 2, riprova\n"); 
			}
		}while(inserimento!=3);
	}


	public static void caricamentoGas(PompaGas d) {
		int inserimento=0;
		int quantita;

		do {
			System.out.println("Premi 1 per caricare benzina, 2 per caricare diesel, 3 per il gas, 4 per uscire:");
			inserimento= Integer.parseInt(sc.nextLine());
			if (inserimento==4){ break;} else {
				System.out.println("Scrivi la quantita che vuoi inserire in litri o metri cubi");
				quantita= Integer.parseInt(sc.nextLine());
				if(inserimento==1) {
					d.CaricamentoBenz(quantita);
				}else if(inserimento==2) {
					d.CaricamentoDiesel(quantita);
				} else if(inserimento==3) {
					d.CaricamentoGas(quantita);
				}
				else
					System.out.println("Non hai inserito 1, 2, 3, 4 riprova\n");
			}
		}while(inserimento!=4);
	}

	public static void utilizzoOrd(Distributore d) {
		int inserimento;
		int quantita;
		do {
			System.out.println("Premi 1 per rifornirti di benzina, 2 per rifornirti di diesel 3 per uscire");
			inserimento= Integer.parseInt(sc.nextLine());
			if (inserimento==3){ break;}
			else {

				System.out.println("Scrivi la quantita che vuoi prelevare in litri");
				quantita= Integer.parseInt(sc.nextLine());
				if(inserimento==1) {
					d.PrelievoBenz(quantita);
				}else if(inserimento==2) {
					d.PrelievoDiesel(quantita);
				} else System.out.println("Non hai inserito 1 o 2, riprova\n"); 
			}
		}while(inserimento!=3);
	}


	public static void utilizzoGas(PompaGas d) {
		int inserimento;
		int quantita;
		do {
			System.out.println("Premi 1 per rifornirti di benzina, 2 per rifornirti di diesel, 3 per rifornirti di gas, 4 per uscire: ");
			inserimento= Integer.parseInt(sc.nextLine());
			if (inserimento==4){ break;}
			else if (inserimento==3){
				System.out.println("Scrivi la quantita di energia che vuoi in Kilowatt:");
				quantita= Integer.parseInt(sc.nextLine());
				d.PrelievoGas(quantita);
			}else {

				System.out.println("Scrivi la quantita che vuoi prelevare in litri");
				quantita= Integer.parseInt(sc.nextLine());
				if(inserimento==1) {
					d.PrelievoBenz(quantita);
				}else if(inserimento==2) {
					d.PrelievoDiesel(quantita);
				} else System.out.println("Non hai inserito 1 o 2, riprova\n"); 
			}
		}while(inserimento!=4);
	}

	public static void utilizzoEl(ColonninaElettrica d) {
		int inserimento;
		int quantita;
		do {
			System.out.println("Premi 1 per rifornirti di benzina, 2 per rifornirti di diesel, 3 per rifornirti di elettricita' 4 per uscire: ");
			inserimento= Integer.parseInt(sc.nextLine());
			if (inserimento==4){ break;}
			else if (inserimento==3){
				System.out.println("Scrivi la quantita di energia che vuoi in Kilowatt:");
				quantita= Integer.parseInt(sc.nextLine());
				d.usoElettrico(quantita);
			}else {

				System.out.println("Scrivi la quantita che vuoi prelevare in litri");
				quantita= Integer.parseInt(sc.nextLine());
				if(inserimento==1) {
					d.PrelievoBenz(quantita);
				}else if(inserimento==2) {
					d.PrelievoDiesel(quantita);
				} else System.out.println("Non hai inserito 1 o 2, riprova\n"); 
			}
		}while(inserimento!=4);
	}






}

