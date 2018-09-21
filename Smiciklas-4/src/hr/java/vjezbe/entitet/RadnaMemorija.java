package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 *	Predstavlja informacije o radnoj memoriji koje sadrže podatke o nazivu, tipu i kapacitetu radne memorije
 *
 * @author Smièiklas
 */

public class RadnaMemorija extends Komponenta implements Memorijska{

	private String tip;
	private Integer kapacitet;


	/**
	 * Inicijalizira podatke o nazivu, tipu i kapacitetu radne memorije
	 * 
	 * @param naziv podatak o nazivu radne memorije
	 * @param tip podatak o tipu radne memorije
	 * @param kapacitet podatak o kapacitetu radne memorije
	 * @param cijena podatak o cijeni radne memorije
	 */
	public RadnaMemorija(String naziv, String tip, Integer kapacitet, BigDecimal cijena) {
		super(naziv, cijena);	
		this.tip = tip;
		this.kapacitet = kapacitet;
	}
	
	/**
	 * Uveæava kapacitet dvostruko
	 */
	@Override
	public void uvecajKapacitet(){
		kapacitet*=2;
	}

	/**  
	 * @return tip radne memorije
	 */
	public String getTip() {
		return tip;
	}

	/**
	 * postavlja tip radne memorije
	 * 
	 * @param tip predstavlja tip radne memorije
	 */
	public void setTip(String tip) {
		this.tip = tip;
	}

	/** 
	 * @return kapacitet radne memorije
	 */
	public Integer getKapacitet() {
		return kapacitet;
	}

	/**
	 * postavlja kapacitet radne memorije
	 * 
	 * @param kapacitet radne memorije
	 */
	public void setKapacitet(Integer kapacitet) {
		this.kapacitet = kapacitet;
	}
	
	@Override
	public void bazaKomponenti(){
		System.out.println("Tip radne memorije: " + tip);
		System.out.println("Kapacitet radne memorije: " + kapacitet);
	}

}
