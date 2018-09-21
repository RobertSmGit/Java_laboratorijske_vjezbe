package hr.java.vjezbe.entitet;

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
	 * @param naziv   podatak o nazivu radne memorije
	 * @param tip   podatak o tipu radne memorije
	 * @param kapacitet   podatak o kapacitetu radne memorije
	 */


	public RadnaMemorija(String naziv, String tip, Integer kapacitet) {
		super(naziv);	
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

}
