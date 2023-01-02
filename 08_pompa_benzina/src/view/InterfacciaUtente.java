package view;
import controller.ControllerPompa;
import java.util.Scanner;
import model.Distributore;
import model.PompaGas;
import model.ColonninaElettrica;
public class InterfacciaUtente {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);

		String scelta="";
		do {
			System.out.println("Benvenuto.\n Seleziona quale tipo di nuovo distributore creare: (ordinario,conGas,conElettrico)");
			scelta=sc.nextLine();
			switch(scelta) {
			case "ordinario":

				Distributore d1=ControllerPompa.inizioOrd();
				System.out.println("\nARRIVO DEL FORNITORE\n");
				ControllerPompa.caricamentoOrd(d1);
				System.out.println("\nARRIVO DEI CLIENTI\n");
				ControllerPompa.utilizzoOrd(d1);
				System.out.println("\nRIEPILOGO\n");
				System.out.println(d1.toString()); 
				System.out.println("\n---Storico:---");
				System.out.println(d1.getStorico());
				break;	
			case "conGas":
				PompaGas d2=ControllerPompa.inizioGas();
				System.out.println("\nARRIVO DEL FORNITORE\n");
				ControllerPompa.caricamentoGas(d2);
				System.out.println("\nARRIVO DEI CLIENTI\n");
				ControllerPompa.utilizzoGas(d2);
				System.out.println("\nRIEPILOGO\n");
				System.out.println(d2.toString());  	
				System.out.println("\n---Storico:---");
				System.out.println(d2.getStorico());
				break;
			case "conElettrico":
				ColonninaElettrica d3= ControllerPompa.inizioEl();
				System.out.println("\nARRIVO DEL FORNITORE\n");
				ControllerPompa.caricamentoEl(d3);
				System.out.println("\nARRIVO DEI CLIENTI\n");
				ControllerPompa.utilizzoEl(d3);
				System.out.println("\nRIEPILOGO\n");
				System.out.println(d3.toString());
				System.out.println("\n---Storico:---");
				System.out.println(d3.getStorico()); 		
				break;
			default:
				System.out.println("Non hai inserito una delle tre possibilita' (ordinario,conGas,conElettrico) \n FINE");
				break;
			}
		}while((scelta=="ordinario") && (scelta=="conGas") && (scelta=="conElettrico"));

	}



}