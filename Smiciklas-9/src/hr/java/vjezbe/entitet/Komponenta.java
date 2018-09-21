package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 *	Predstavlja entitet komponenti koji sadr�i naziv proizvo�a�a tih komponenti,
 *  ovu klasu naslje�uju sve 4 komponente ra�unala 
 *
 * @author Smi�iklas
 * 
 */

public abstract class Komponenta {
	
	private String nazivProizvodaca;
	private BigDecimal cijena;
	/*protected BigDecimal brzina, kapacitetTvrdogDiska ;
	protected String tipRadneMemorije, tipSuceljaProcesora, tipTvrdogDiska, tipMaticnePloce;
	protected Integer kapacitetRadneMemorije, maksimalanBrojMemorijskihModula;*/
	
	private int[] id = new int[50];
	int i = 0;
	
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
	 * @param nazivProizvodaca podatak o nazivu proizvo�a�a komponente
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
	
	
	public int getId() {
		return id[i];
	}
	
	public void setId(int id) {
		this.id[i] = id;
		i++;
	}


	public abstract void bazaKomponenti();
	
}
