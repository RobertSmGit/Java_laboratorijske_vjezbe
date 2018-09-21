package hr.java.vjezbe.entitet;

/**
 *	Su�elje sadr�i dvije metode,
 *  jedna pretvara gigabajte u terabajte, a druga apstrakta metoda pove�ava kapacitet radne memorije.
 *	Ovo su�elje implementiraju klase za radnu memoriju i tvrdi disk
 *
 * @author Smi�iklas
 * 
 */

public interface Memorijska {
	
	/**
	 * Dvostruko uve�ava kapacitet radne memorije
	 */
	void uvecajKapacitet();
	
	/**
	 * Pretvara iz gigabajta u terabajte
	 * 
	 * @param iznos pretstavlja iznos u gigabajtima koji �elimo pretvoriti u terabajte
	 * @return iznos u terabajtima
	 */
	static double pretvoriUTB(Integer iznos){
		return (double)iznos/1024;
	}
}
