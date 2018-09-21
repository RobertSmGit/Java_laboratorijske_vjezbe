package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 *	Predstavlja entitet komponenti koji sadrži naziv proizvoðaèa tih komponenti,
 *  ovu klasu nasljeðuju sve 4 komponente raèunala 
 *
 * @author Smièiklas
 * 
 */

public abstract class Komponenta {
	
	private String nazivProizvodaca;
	private BigDecimal cijena;
	/*protected BigDecimal brzina, kapacitetTvrdogDiska ;
	protected String tipRadneMemorije, tipSuceljaProcesora, tipTvrdogDiska, tipMaticnePloce;
	protected Integer kapacitetRadneMemorije, maksimalanBrojMemorijskihModula;*/
	
	/**
	 * Inicijalizira podatak o nazivu komponente
	 * 
	 * @param naziv podatak o nazivu komponente
	 * @param cijena podatak o cijeni komponente
	 */
	public Komponenta(String naziv, BigDecimal cijena) {
		nazivProizvodaca = naziv;
		this.cijena = cijena;
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

	public BigDecimal getCijena() {
		return cijena;
	}

	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}
	
	public abstract void bazaKomponenti();
	
}
