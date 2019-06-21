package it.unibs.giocodiruolo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Partita {
	
	private static final String OPZIONI = "Digita l'opzione che preferisci\n\t[1] scelta numero 1\n\t[2] Scelta numero 2\n";
	private static final String SCELTA = "é giunto il momento di fare una scelta :";
	private static final String MEX_ERROR = "ERRORE: hai digitato la scelta sbagliata. Digita nuovamente l'opzione corretta";
	
	
	
	
	/**
	 * 
	 * @return ritorna 1 o 2 per la gestione delle scelte
	 */
	public static int menuScelte() {
		int scelta=0;
		int sceltaTmp;
		boolean flag = false;
		
		System.out.println(SCELTA);
		System.out.println(OPZIONI);
		
		sceltaTmp = leggiScelta();   // valore temporanoe in cui salvo il valore acquisito da tastiera
		
		do {
			if (sceltaTmp==1) {
				scelta = sceltaTmp;
				flag = true;
			}else if(sceltaTmp==2) {
				scelta = sceltaTmp;
				flag = true;
			}else {
				System.out.println(MEX_ERROR);
				flag = false;
				sceltaTmp = leggiScelta();
			}
		} while (!flag);
		return scelta;
	}
	
	
	/**
	 * 
	 * @return ritorna un intero letto da tastiera
	 */
	public static int leggiScelta () {
		Scanner tastiera =  new Scanner(System.in);
		boolean letto = false;
		int valoreLetto = 0;
		
		do {
			try {
				valoreLetto = tastiera.nextInt();
				letto = true;
			}
			catch(InputMismatchException e) {
				System.out.println(MEX_ERROR);
				String daButtare = tastiera.next();
			}
		} while (!letto);
		return valoreLetto;
	}
	
}
	
	
	

