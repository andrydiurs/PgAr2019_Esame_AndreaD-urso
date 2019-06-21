package it.unibs.giocodiruolo;

import java.util.ArrayList;

public class Casella {
	private String descrizione;
	private int id;
	private ArrayList<Integer> collegamenti = new ArrayList<Integer>() ;
	
	public Casella (String _descrizione, int _id, ArrayList<Integer> _collegamenti) {
		this.descrizione = _descrizione;
		this.id = _id;
		this.collegamenti = _collegamenti;
	}
	
	public Casella() {
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	public int getId() {
		return id;
	}
	public ArrayList<Integer> getCollegamenti(){
		return collegamenti;
	}
	
	public void setDescrizione (String descrizione) {
		this.descrizione = descrizione;
	}
	public void setId (int id) {
		this.id = id;
	}
	public void setCollegamenti (int link) {
		collegamenti.add(link);
	}
	
	
	public int effetto (int modVita) {
		return modVita;
	}
	
}
