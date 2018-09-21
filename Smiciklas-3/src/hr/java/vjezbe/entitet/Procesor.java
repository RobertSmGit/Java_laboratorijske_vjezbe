package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 *	Predstavlja informacije o procesoru,
 *  sadrži podatke o nazivu, tipu, brzini i suèelju procesora
 *
 * @author Smièiklas
 */

public class Procesor extends Komponenta implements Frekvencijska {

	private String tip;
	private BigDecimal brzina;
	private int redniBrojSucelja;
	public final String sucelje1 = "SOCKET_AM2";
	public final String sucelje2 = "SOCKET_AM3";
	public final String sucelje3 = "SOCKET_LGA_1151";
	public final String sucelje4 = "SOCKET_G3";
	
	/**
	 * Inicijalizira podatke o nazivu, tipu, brzini i suèelju procesora
	 * 
	 * @param naziv   podatak o nazivu procesora
	 * @param tip   podatak o tipu procesora
	 * @param brzina   podatak o brzini procesora
	 * @param redniBrojSucelja   podatak o odabranom sucelju procesora (1, 2, 3, 4)
	 */

	public Procesor(String naziv, String tip, BigDecimal brzina, int redniBrojSucelja) {
		super(naziv);
		this.redniBrojSucelja = redniBrojSucelja;
		this.tip = tip;
		this.brzina = brzina;
	}

	/**
	 * @return redni broj sucelja procesora, svaki broj od 1 do 4 predstavlja jedno suèelje
	 */
	public int getRedniBrojSucelja() {
		return redniBrojSucelja;
	}
	
	/**
	 * postavlja suèelje procesora
	 * 
	 * @param redniBrojSucelja broj suèelja procesora, svaki broj od 1 do 4 predstavlja jedno suèelje
	 */
	public void setRedniBrojSucelja(int redniBrojSucelja) {
		this.redniBrojSucelja = redniBrojSucelja;
	}

	/**
	 * @return tip procesora
	 */
	public String getTip() {
		return tip;
	}

	/**
	 * postavlja tip procesora
	 * 
	 * @param tip predstavlja tip procesora
	 */
	public void setTip(String tip) {
		this.tip = tip;
	}

	/**
	 * @return frekvenciju procesora
	 */
	public BigDecimal getBrzina() {
		return brzina;
	}

	/**
	 * postavlja frekvenciju procesora
	 * 
	 * @param brzina frekvencija procesora
	 */
	public void setBrzina(BigDecimal brzina) {
		this.brzina = brzina;
	}

}
