package hr.java.vjezbe.entitet;

/**
 *	Suèelje sadrži dvije metode,
 *  jedna pretvara gigabajte u terabajte, a druga apstrakta metoda poveæava kapacitet radne memorije.
 *	Ovo suèelje implementiraju klase za radnu memoriju i tvrdi disk
 *
 * @author Smièiklas
 * 
 */

public interface Memorijska {
	
	/**
	 * Dvostruko uveèava kapacitet radne memorije
	 */
	void uvecajKapacitet();
	
	/**
	 * Pretvara iz gigabajta u terabajte
	 * 
	 * @param iznos pretstavlja iznos u gigabajtima koji želimo pretvoriti u terabajte
	 * @return iznos u terabajtima
	 */
	static double pretvoriUTB(Integer iznos){
		return (double)iznos/1024;
	}
}
