package it.unibs.giocodiruolo;

public class GiocoDiRuoloMain {

	public static void main(String[] args) {
		Giocatore personaggio = new Giocatore();
		
		
		
		
		
		// ************ PROVE *************
		int scelta;
		scelta = Partita.menuScelte();
		System.out.println("scelta = "+scelta);
		System.out.println("Hai una vita di "+personaggio.getVita());
	}

}
