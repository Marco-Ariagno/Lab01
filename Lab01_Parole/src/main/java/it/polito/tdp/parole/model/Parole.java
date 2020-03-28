package it.polito.tdp.parole.model;

import java.util.List;

import java.util.*;

public class Parole {
	
	private LinkedList<String> parole;
		
	public Parole() {
		parole=new LinkedList<String>();
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public List<String> getElenco() {
		LinkedList<String> paroleOrdinate=new LinkedList<String>(parole);
		Collections.sort(paroleOrdinate, new ComparatoreParoleOrdineAlfabetico());
		return paroleOrdinate;
	}
	
	
	public void reset() {
		parole.clear();
	}
	
	public void rimuoviParola(String parola) {
		for(String s:parole) {
			if(s.equals(parola)) {
				parole.remove(parola);
			}
		}
	}

}
