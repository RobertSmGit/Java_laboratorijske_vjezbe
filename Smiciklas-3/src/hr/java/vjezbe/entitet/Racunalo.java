package hr.java.vjezbe.entitet;

/**
 *	Predstavlja informacije o raèunalu,
 *  sadrži podatke o komponentama od kojih se raèunalo sastoji
 *  
 * @author Smièiklas
 */

public class Racunalo {

	private MaticnaPloca maticnaPloca;
	private Procesor procesor;
	private RadnaMemorija radnaMemorija;
	private TvrdiDisk tvrdiDisk;
	
	/**
	 * Inicijalizira podatke o matiènoj ploèi, procesoru, radnoj memoriji, i tvrdom disku
	 * 
	 * @param maticnaPloca   podatak o matiènoj ploèi
	 * @param procesor   podatak o procesoru
	 * @param radnaMemorija   podatak o radnoj memoriji
	 * @param tvrdiDisk   podatak o tvrdom disku
	 */
	public Racunalo(MaticnaPloca maticnaPloca, Procesor procesor, RadnaMemorija radnaMemorija, TvrdiDisk tvrdiDisk) {
		this.maticnaPloca = maticnaPloca;
		this.procesor = procesor;
		this.radnaMemorija = radnaMemorija;
		this.tvrdiDisk = tvrdiDisk;
	}

	/**
	 * @return matiènu ploèu raèunala
	 */
	public MaticnaPloca getMaticnaPloca() {
		return maticnaPloca;
	}

	/**
	 * postavlja matiènu ploèu raèunala
	 * 
	 * @param maticnaPloca objekt koji predstavlja matiènu ploèu raèunala
	 */
	public void setMaticnaPloca(MaticnaPloca maticnaPloca) {
		this.maticnaPloca = maticnaPloca;
	}

	/**
	 * @return procesor raèunala
	 */
	public Procesor getProcesor() {
		return procesor;
	}

	/**
	 * postavlja procesor raèunala
	 * 
	 * @param procesor objekt koji predstavlja procesor raèunala
	 */
	public void setProcesor(Procesor procesor) {
		this.procesor = procesor;
	}

	/**
	 * @return radnu memoriju raèunala
	 */
	public RadnaMemorija getRadnaMemorija() {
		return radnaMemorija;
	}

	/**
	 * postavlja radnu memoriju raèunala
	 * 
	 * @param radnaMemorija objekt koji predstavlja radnu memoriju 
	 */
	public void setRadnaMemorija(RadnaMemorija radnaMemorija) {
		this.radnaMemorija = radnaMemorija;
	}

	/**
	 * @return tvrdi disk raèunala
	 */
	public TvrdiDisk getTvrdiDisk() {
		return tvrdiDisk;
	}

	/**
	 * postavlja tvrdi disk raèunala
	 * 
	 * @param tvrdiDisk objekt koji predstavlja tvrdi disk raèunala
	 */
	public void setTvrdiDisk(TvrdiDisk tvrdiDisk) {
		this.tvrdiDisk = tvrdiDisk;
	}

}
