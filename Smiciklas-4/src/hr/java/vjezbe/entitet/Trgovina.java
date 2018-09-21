package hr.java.vjezbe.entitet;

import java.util.*;

/**
 *	Predstavlja generièku klasu koja sprema komponente raèunala i sortira ih po cijeni 
 *
 * @author Smièiklas
 * 
 */

public class Trgovina <T extends Komponenta>{
	
	public List<T> komponente = new ArrayList<>();
	
	public void dodajKomponentu(T komponenta){
		
		komponente.add(komponenta);
	}
	
	/**
	 *  Usporeðuje komponente po cijeni i na prvo mjesto liste stavlja onu komponentu koja ima najnižu cijenu
	 * 
	 * @return komponentu sa najnižom cijenom
	 */
	public T najjeftinijaKomponenta(){
		
		Collections.sort(komponente, (T k1,T k2) -> (k1.getCijena().compareTo(k2.getCijena())));
		return komponente.get(0);
	}
	
	/**
	 *  Usporeðuje komponente po cijeni i na prvo mjesto liste stavlja onu komponentu koja ima najvišu cijenu
	 * 
	 * @return komponentu sa najvišom cijenom
	 */
	public T najskupljaKomponenta(){
		
		Collections.sort(komponente, (T k1,T k2) -> (k1.getCijena().compareTo(k2.getCijena())));
		return komponente.get(komponente.size()-1);
	}
	
}



