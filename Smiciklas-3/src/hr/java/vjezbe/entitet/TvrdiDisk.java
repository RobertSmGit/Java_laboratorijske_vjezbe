package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 *	Predstavlja informacije o tvrdom disku koje sadr�e podatke o nazivu, tipu i kapacitetu tvrdok diska
 *
 * @author Smi�iklas
 */


public class TvrdiDisk extends Komponenta implements Memorijska{

	private String tip;
	private BigDecimal kapacitet;
	
	/**
	 * Inicijalizira podatke o nazivu, tipu i kapacitetu tvrdog diska
	 * 
	 * @param naziv   podatak o nazivu tvrdog diska
	 * @param tip   podatak o tipu tvrdog diska
	 * @param kapacitet   podatak o kapacitetu tvrdog diska
	 */
	public TvrdiDisk(String naziv, String tip, BigDecimal kapacitet) {
		super(naziv);
		this.tip = tip;
		this.kapacitet = kapacitet;
	}

	/**
	 * uve�ava kapacitet tvrdog diska dvostruko
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

}
