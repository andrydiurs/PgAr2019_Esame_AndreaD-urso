package it.unibs.giocodiruolo;

import java.util.ArrayList;

public class GiocoDiRuoloMain {

	private static final String INIZIO = "Sei all'inizio, preparati a partire, la tua prima destinazione sarà la pianura";
	private static final String PIANURA = "Sei arrivato in una zona tranquilla e pianeggiante. Dove Vuoi andare ? Montagna[1] o Mare[2]";
	private static final String MARE = "Sei arrivati in una splendida spiaggia. Voi prendere una nave e salpare[1], voi esplorare le montagne [2] oppure la pianura [3]?";
	private static final String FINE = "Congratulazioni, il tuo viaggio è terminato";
	private static final String MONTAGNA = "Arrivare fin quassù è stato faticoso. Vedi il paesaggio sotto di te. Dove vuoi andare ? Pianura[1] o Mare[2]";	
	
	public static void main(String[] args) {
		Giocatore personaggio = new Giocatore();
		
		ArrayList<Integer> collegamentiC0 = new ArrayList<Integer>();
		collegamentiC0.add(1);
		
		ArrayList<Integer> collegamentiC1 = new ArrayList<Integer>();
		collegamentiC1.add(4);
		collegamentiC1.add(2);
		
		ArrayList<Integer> collegamentiC2 = new ArrayList<Integer>();
		collegamentiC2.add(1);
		collegamentiC2.add(3);
		collegamentiC2.add(4);
		
		ArrayList<Integer> collegamentiC3 = new ArrayList<Integer>();
		collegamentiC3.add(2);
		
		ArrayList<Integer> collegamentiC4 = new ArrayList<Integer>();
		collegamentiC4.add(1);
		collegamentiC4.add(2);
		
		Casella c0 = new Casella(INIZIO, 0, collegamentiC0);
		Casella c1 = new Casella(PIANURA, 1, collegamentiC1);
		Casella c2 = new Casella(MARE, 2, collegamentiC2);
		Casella c3 = new Casella(FINE, 3, collegamentiC3);
		Casella c4 = new Casella(MONTAGNA, 4, collegamentiC4);
		c4.effetto(-20);
		
		ArrayList<Casella> listaCaselle = new ArrayList<Casella>();
		listaCaselle.add(c0);
		listaCaselle.add(c1);
		listaCaselle.add(c2);
		listaCaselle.add(c3);
		listaCaselle.add(c4);
		
		Mappa.creaMappa(listaCaselle);
		
		// ************ PROVE *************
		int scelta;
		/*
		scelta = Partita.menuScelte();
		System.out.println("scelta = "+scelta);
		System.out.println("Hai una vita di "+personaggio.getVita());
		*/
		Partita.menuPartita(listaCaselle, personaggio);
		
		ArrayList<Casella> listaCaselle2 = new ArrayList<Casella>();
		listaCaselle2 = Partita.leggiXML();
		//System.out.println(listaCaselle2);
		
	}

}
