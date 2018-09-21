package hr.java.vjezbe.entitet;

/**
 *	Predstavlja informacije o mati�noj plo�i, 
 *  sadr�i podakte o nazivu, tipu, tipu su�elja procesora i maksimalnom broju memorijskih modula mati�ne plo�e
 *
 * @author Smi�iklas
 * 
 */

public class MaticnaPloca extends Komponenta{

	private String tip;
	private String tipSuceljaZaProcesor;
	private int maksimalanBrojMemorijskihModula;
	
	/**
	 * Inicijalizira podatke o nazivu, tipu, tipu su�elja za procesor i maksimalnom broju memorijskih modula mati�ne plo�e
	 * 
	 * @param naziv podatak o nazivu mati�ne plo�e
	 * @param tip podatak o tipu mati�ne plo�e
	 * @param tipSuceljaZaProcesor podatak o su�elju procesora kompatibilnim sa mati�nom plo�om
	 * @param maksimalanBrojMemorijskihModula podatak o maksimalnom broju memorijskih modula koji je mogu�e priklju�iti na mati�nu plo�u
	 */
	public MaticnaPloca(String naziv, String tip, String tipSuceljaZaProcesor, int maksimalanBrojMemorijskihModula) {
		super(naziv);
		this.tip = tip;
		this.tipSuceljaZaProcesor = tipSuceljaZaProcesor;
		this.maksimalanBrojMemorijskihModula = maksimalanBrojMemorijskihModula;
	}

	/**
	 * @return tip su�elja na mati�noj plo�i u koje se spaja procesor
	 */
	public String getTipSuceljaZaProcesor() {
		return tipSuceljaZaProcesor;
	}

	/**
	 * postavlja tip su�elja na mati�noj plo�i u koje se spaja procesor
	 * 
	 * @param tipSuceljaZaProcesor tip su�elja na mati�noj plo�i koje mora odgovoarati tipu su�elja procesora 
	 */
	public void setTipSuceljaZaProcesor(String tipSuceljaZaProcesor) {
		this.tipSuceljaZaProcesor = tipSuceljaZaProcesor;
	}
	
	/**
	 * @return maksimalan broj memorijskih modula koje je mogu�e priklju�iti na mati�nu plo�u
	 */
	public int getMaksimalanBrojMemorijskihModula() {
		return maksimalanBrojMemorijskihModula;
	}

	/**
	 * postavlja maksimalan broj memorijskih modula koje je mogu�e priklju�iti na mati�nu plo�u
	 * 
	 * @param maksimalanBrojMemorijskihModula maksimalan broj memorijskih modula koje je mogu�e priklju�iti na mati�nu plo�u
	 */
	public void setMaksimalanBrojMemorijskihModula(int maksimalanBrojMemorijskihModula) {
		this.maksimalanBrojMemorijskihModula = maksimalanBrojMemorijskihModula;
	}
	
	/**
	 *  @return tip mati�ne plo�e
	 */
	public String getTip() {
		return tip;
	}

	/**
	 * postavlja tip mati�ne plo�e
	 * 
	 * @param tip tip mati�ne plo�e
	 */
	public void setTip(String tip) {
		this.tip = tip;
	}

}
