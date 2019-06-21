package it.unibs.giocodiruolo;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;



public class Partita {
	
	private static final String OPZIONI = "Digita l'opzione che preferisci\n\t[1] scelta numero 1\n\t[2] Scelta numero 2\n";
	private static final String SCELTA = "é giunto il momento di fare una scelta :";
	private static final String MEX_ERROR = "ERRORE: hai digitato la scelta sbagliata. Digita nuovamente l'opzione corretta";
	
	private static String mappa = "base.xml";
	
	
	
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
	
	public static int menuScelte3() {
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
			}else if(sceltaTmp==3) {
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
	
	
	
	public static void menuPartita (ArrayList<Casella> listaCaselle, Giocatore g1 ) {
		int scelta=0;
		int posizione=0;
		int link;
		int numLink;
		
		System.out.println(listaCaselle.get(0).getDescrizione());
		System.out.println(listaCaselle.get(1).getDescrizione());
		
		do {
			numLink = listaCaselle.get(1).getCollegamenti().size();
			if (numLink==2) {
				scelta = menuScelte();
			}else if (numLink==3) {
				scelta = menuScelte3();
			}
			if (scelta == 1) {
				posizione = 4;
			}else if(scelta == 2) {
				posizione = 2;
			}
			System.out.println(listaCaselle.get(posizione).getDescrizione());
			
			
			
		}while(true);
		
	}// fine menuPartita
	
	
	public static ArrayList<Casella> leggiXML () {
		ArrayList<Casella> listaCaselle = new ArrayList<Casella>();
		int k = 0; // contatore per contare la lista di caselle
		XMLInputFactory xmlif = null;
		XMLStreamReader xmlr=null;
		
		try {
			 xmlif = XMLInputFactory.newInstance();
			 xmlr = xmlif.createXMLStreamReader(mappa, new FileInputStream(mappa)); 
			 while (xmlr.hasNext()) { // continua a leggere finché ha eventi a disposizione 
				 switch (xmlr.getEventType()) { // switch sul tipo di evento
				 
				 case XMLStreamConstants.START_DOCUMENT:
					 break;
			     
				 case XMLStreamConstants.START_ELEMENT: 
			    	 if (xmlr.getLocalName().equals("cell")) {
			    		 Casella nuovaCasella = new Casella();
			    		 listaCaselle.add(nuovaCasella);
			    		 k++;
			    	 }
			         for (int i = 0; i < xmlr.getAttributeCount(); i++) {
			        	 switch (xmlr.getAttributeLocalName(i)) {
							case "id":
								int idInt = Integer.parseInt(xmlr.getAttributeValue(i));
								listaCaselle.get(k-1).setId(idInt);
								break;
	
							case "type":
								listaCaselle.get(k-1).setType(xmlr.getAttributeValue(i));
								break;
							default:
								break;
						}
			        	 
			        	 /*
			        	 if (xmlr.getLocalName().equals("description")) {
				    		 listaCaselle.get(k-1).setDescrizione(xmlr.getElementText());
				    	 }
			        	 */
			         }
			         if (xmlr.getLocalName().equals("description")) {
			    		 listaCaselle.get(k-1).setDescrizione(xmlr.getElementText());
			    	 }
			         break;
			     
				 case XMLStreamConstants.END_ELEMENT:
			    	 break;
			     
				 case XMLStreamConstants.COMMENT:
			         break; 
			     
				 case XMLStreamConstants.CHARACTERS: // content all’interno di un elemento: stampa il testo 
			    	 if (xmlr.getText().trim().length() > 0) // controlla se il testo non contiene solo spazi
			    	 break;
			    	 }
			    
				 xmlr.next();
			    
			     }
			 
			 } 
		 catch (Exception e) {
			 //System.out.println("Errore nell'inizializzazione del reader:");
			 //System.out.println(e.getMessage()); 
			 }
		
		return listaCaselle;
	}
	
	
	
	
}
	
	
	

