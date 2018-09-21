package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 *	Predstavlja informacije o matiènoj ploèi, 
 *  sadrži podakte o nazivu, tipu, tipu suèelja procesora i maksimalnom broju memorijskih modula matiène ploèe
 *
 * @author Smièiklas
 * 
 */

public class MaticnaPloca extends Komponenta{

	private String tip;
	private String tipSuceljaZaProcesor;
	private int maksimalanBrojMemorijskihModula;	


	/**
	 * Inicijalizira podatke o nazivu, tipu, tipu suèelja za procesor i maksimalnom broju memorijskih modula matiène ploèe
	 * 
	 * @param naziv podatak o nazivu matiène ploèe
	 * @param tip podatak o tipu matiène ploèe
	 * @param tipSuceljaZaProcesor podatak o suèelju procesora kompatibilnim sa matiènom ploèom
	 * @param maksimalanBrojMemorijskihModula podatak o maksimalnom broju memorijskih modula koji je moguæe prikljuèiti na matiènu ploèu
	 * @param cijena podatak o cijeni matiène ploèe
	 */
	public MaticnaPloca(String naziv, String tip, String tipSuceljaZaProcesor, int maksimalanBrojMemorijskihModula, BigDecimal cijena) {
		super(naziv, cijena);
		this.tip = tip;
		this.tipSuceljaZaProcesor = tipSuceljaZaProcesor;
		this.maksimalanBrojMemorijskihModula = maksimalanBrojMemorijskihModula;
	}

	/**
	 * @return tip suèelja na matiènoj ploèi u koje se spaja procesor
	 */
	public String getTipSuceljaZaProcesor() {
		return tipSuceljaZaProcesor;
	}

	/**
	 * postavlja tip suèelja na matiènoj ploèi u koje se spaja procesor
	 * 
	 * @param tipSuceljaZaProcesor tip suèelja na matiènoj ploèi koje mora odgovoarati tipu suèelja procesora 
	 */
	public void setTipSuceljaZaProcesor(String tipSuceljaZaProcesor) {
		this.tipSuceljaZaProcesor = tipSuceljaZaProcesor;
	}
	
	/**
	 * @return maksimalan broj memorijskih modula koje je moguæe prikljuèiti na matiènu ploèu
	 */
	public int getMaksimalanBrojMemorijskihModula() {
		return maksimalanBrojMemorijskihModula;
	}

	/**
	 * postavlja maksimalan broj memorijskih modula koje je moguæe prikljuèiti na matiènu ploèu
	 * 
	 * @param maksimalanBrojMemorijskihModula maksimalan broj memorijskih modula koje je moguæe prikljuèiti na matiènu ploèu
	 */
	public void setMaksimalanBrojMemorijskihModula(int maksimalanBrojMemorijskihModula) {
		this.maksimalanBrojMemorijskihModula = maksimalanBrojMemorijskihModula;
	}
	
	/**
	 *  @return tip matiène ploèe
	 */
	public String getTip() {
		return tip;
	}

	/**
	 * postavlja tip matiène ploèe
	 * 
	 * @param tip tip matiène ploèe
	 */
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	@Override
	public void bazaKomponenti(){
		
		System.out.println("Tip maticne ploce: " + tip);
		System.out.println("Maskimalan broj meorijskih modula: " + maksimalanBrojMemorijskihModula);
	}

	@Override
	public String toString() {
		return " MaticnaPloca [tip=" + tip + ", tipSuceljaZaProcesor=" + tipSuceljaZaProcesor + ", maksimalanBrojMemorijskihModula=" + maksimalanBrojMemorijskihModula + "]";
	}
	
	
}

