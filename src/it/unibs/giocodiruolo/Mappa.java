package it.unibs.giocodiruolo;

import java.util.ArrayList;
import java.util.HashMap;

public class Mappa {
	
	
	public static HashMap creaMappa (ArrayList<Casella> listaCaselle) {
		HashMap<Integer, String> mappa = new HashMap<Integer, String>();
		for (int i = 0; i < listaCaselle.size(); i++) {
			mappa.put(listaCaselle.get(i).getId(), listaCaselle.get(i).getDescrizione());
		}
		
		return mappa;
	}
	
	
	
	
	
	
}
