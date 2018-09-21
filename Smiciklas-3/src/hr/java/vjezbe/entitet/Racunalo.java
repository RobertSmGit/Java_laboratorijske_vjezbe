package hr.java.vjezbe.entitet;

/**
 *	Predstavlja informacije o ra�unalu,
 *  sadr�i podatke o komponentama od kojih se ra�unalo sastoji
 *  
 * @author Smi�iklas
 */

public class Racunalo {

	private MaticnaPloca maticnaPloca;
	private Procesor procesor;
	private RadnaMemorija radnaMemorija;
	private TvrdiDisk tvrdiDisk;
	
	/**
	 * Inicijalizira podatke o mati�noj plo�i, procesoru, radnoj memoriji, i tvrdom disku
	 * 
	 * @param maticnaPloca   podatak o mati�noj plo�i
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
	 * @return mati�nu plo�u ra�unala
	 */
	public MaticnaPloca getMaticnaPloca() {
		return maticnaPloca;
	}

	/**
	 * postavlja mati�nu plo�u ra�unala
	 * 
	 * @param maticnaPloca objekt koji predstavlja mati�nu plo�u ra�unala
	 */
	public void setMaticnaPloca(MaticnaPloca maticnaPloca) {
		this.maticnaPloca = maticnaPloca;
	}

	/**
	 * @return procesor ra�unala
	 */
	public Procesor getProcesor() {
		return procesor;
	}

	/**
	 * postavlja procesor ra�unala
	 * 
	 * @param procesor objekt koji predstavlja procesor ra�unala
	 */
	public void setProcesor(Procesor procesor) {
		this.procesor = procesor;
	}

	/**
	 * @return radnu memoriju ra�unala
	 */
	public RadnaMemorija getRadnaMemorija() {
		return radnaMemorija;
	}

	/**
	 * postavlja radnu memoriju ra�unala
	 * 
	 * @param radnaMemorija objekt koji predstavlja radnu memoriju 
	 */
	public void setRadnaMemorija(RadnaMemorija radnaMemorija) {
		this.radnaMemorija = radnaMemorija;
	}

	/**
	 * @return tvrdi disk ra�unala
	 */
	public TvrdiDisk getTvrdiDisk() {
		return tvrdiDisk;
	}

	/**
	 * postavlja tvrdi disk ra�unala
	 * 
	 * @param tvrdiDisk objekt koji predstavlja tvrdi disk ra�unala
	 */
	public void setTvrdiDisk(TvrdiDisk tvrdiDisk) {
		this.tvrdiDisk = tvrdiDisk;
	}

}
