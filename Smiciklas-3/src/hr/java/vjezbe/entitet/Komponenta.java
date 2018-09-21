package hr.java.vjezbe.entitet;

/**
 *	Predstavlja entitet komponenti koji sadr�i naziv proizvo�a�a tih komponenti,
 *  ovu klasu naslje�uju sve 4 komponente ra�unala 
 *
 * @author Smi�iklas
 * 
 */

public abstract class Komponenta {
	
	String nazivProizvodaca;
	
	/**
	 * Inicijalizira podatak o nazivu komponente
	 * 
	 * @param naziv podatak o nazivu komponente
	 */
	public Komponenta(String naziv) {
		nazivProizvodaca = naziv;
	}

	/**
	 * @return naziv kompenente
	 */
	public String getNazivProizvodaca() {
		return nazivProizvodaca;
	}

	/**
	 * @param nazivProizvodaca podatak o nazivu proizvo�a�a komponente
	 */
	public void setNazivProizvodaca(String nazivProizvodaca) {
		this.nazivProizvodaca = nazivProizvodaca;
	}
	
}
