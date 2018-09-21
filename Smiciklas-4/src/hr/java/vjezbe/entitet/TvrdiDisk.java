package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 *	Predstavlja informacije o tvrdom disku koje sadrže podatke o nazivu, tipu i kapacitetu tvrdok diska
 *
 * @author Smièiklas
 */

public class TvrdiDisk extends Komponenta implements Memorijska{

	private String tip;
	private BigDecimal kapacitet;
	
	/**
	 * Inicijalizira podatke o nazivu, tipu i kapacitetu tvrdog diska
	 * 
	 * @param naziv podatak o nazivu tvrdog diska
	 * @param tip podatak o tipu tvrdog diska
	 * @param kapacitet podatak o kapacitetu tvrdog diska
	 * @param cijena podatak o cijeni tvrdog diska
	 */
	public TvrdiDisk(String naziv, String tip, BigDecimal kapacitet, BigDecimal cijena) {
		super(naziv, cijena);
		this.tip = tip;
		this.kapacitet = kapacitet;
	}

	/**
	 * uveèava kapacitet tvrdog diska dvostruko
	 */
	public void uvecajKapacitet(){
		
	}

	/**
	 * @return tip tvrdok diska
	 */
	public String getTip() {
		return tip;
	}

	/**
	 * postavlja tip tvrdog diska
	 * 
	 * @param tip predstavlja tip tvrdog diska
	 */
	public void setTip(String tip) {
		this.tip = tip;
	}

	/**
	 * @return kapacitet tvrdog diska
	 */
	public BigDecimal getKapacitet() {
		return kapacitet;
	}

	/**
	 * postavlja kapacitet tvrdok diska
	 * 
	 * @param kapacitet kapacitet tvrdog diska
	 */
	public void setKapacitet(BigDecimal kapacitet) {
		this.kapacitet = kapacitet;
	}
	
	@Override
	public void bazaKomponenti(){
		
		System.out.println("Tip tvrdog diska: " + tip);
		System.out.println("Kapacitet tvrdog diska: " + kapacitet);
	}

}
