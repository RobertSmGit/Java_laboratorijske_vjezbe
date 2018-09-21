package hr.java.vjezbe.entitet;

import java.util.*;

/**
 *	Predstavlja generi�ku klasu koja sprema komponente ra�unala i sortira ih po cijeni 
 *
 * @author Smi�iklas
 * 
 */

public class Trgovina <T extends Komponenta>{
	
	public List<T> komponente = new ArrayList<>();
	
	public void dodajKomponentu(T komponenta){
		
		komponente.add(komponenta);
	}
	
	/**
	 *  Uspore�uje komponente po cijeni i na prvo mjesto liste stavlja onu komponentu koja ima najni�u cijenu
	 * 
	 * @return komponentu sa najni�om cijenom
	 */
	public T najjeftinijaKomponenta(){
		
		Collections.sort(komponente, (T k1,T k2) -> (k1.getCijena().compareTo(k2.getCijena())));
		return komponente.get(0);
	}
	
	/**
	 *  Uspore�uje komponente po cijeni i na prvo mjesto liste stavlja onu komponentu koja ima najvi�u cijenu
	 * 
	 * @return komponentu sa najvi�om cijenom
	 */
	public T najskupljaKomponenta(){
		
		Collections.sort(komponente, (T k1,T k2) -> (k1.getCijena().compareTo(k2.getCijena())));
		return komponente.get(komponente.size()-1);
	}
	
}



