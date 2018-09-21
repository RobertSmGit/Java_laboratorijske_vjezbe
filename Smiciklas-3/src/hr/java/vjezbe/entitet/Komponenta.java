package hr.java.vjezbe.entitet;

/**
 *	Predstavlja entitet komponenti koji sadrži naziv proizvoðaèa tih komponenti,
 *  ovu klasu nasljeðuju sve 4 komponente raèunala 
 *
 * @author Smièiklas
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
	 * @param nazivProizvodaca podatak o nazivu proizvoðaèa komponente
	 */
	public void setNazivProizvodaca(String nazivProizvodaca) {
		this.nazivProizvodaca = nazivProizvodaca;
	}
	
}
