package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 *	Predstavlja informacije o procesoru,
 *  sadr�i podatke o nazivu, tipu, brzini i su�elju procesora
 *
 * @author Smi�iklas
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
	 * Inicijalizira podatke o nazivu, tipu, brzini i su�elju procesora
	 * 
	 * @param naziv podatak o nazivu procesora
	 * @param tip podatak o tipu procesora
	 * @param brzina podatak o brzini procesora
	 * @param redniBrojSucelja podatak o odabranom sucelju procesora (1, 2, 3, 4)
	 * @param cijena podatak o cijeni procesora
	 */
	public Procesor(String naziv, String tip, BigDecimal brzina, int redniBrojSucelja, BigDecimal cijena) {
		super(naziv, cijena);
		this.redniBrojSucelja = redniBrojSucelja;
		this.tip = tip;
		this.brzina = brzina;
	}
	

	/**
	 * @return redni broj sucelja procesora, svaki broj od 1 do 4 predstavlja jedno su�elje
	 */
	public int getRedniBrojSucelja() {
		return redniBrojSucelja;
	}
	
	/**
	 * postavlja su�elje procesora
	 * 
	 * @param redniBrojSucelja broj su�elja procesora, svaki broj od 1 do 4 predstavlja jedno su�elje
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
	
	@Override
	public void bazaKomponenti(){
		System.out.println("Tip procesora: " + tip);
		
		 if(redniBrojSucelja == 1){
			 SuceljeProcesora suceljeProcesora = SuceljeProcesora.SOCKET_AM2;
			 System.out.println("Tip sucelja procesora: " + suceljeProcesora.name() );
		 }
		 if(redniBrojSucelja == 2){
			 SuceljeProcesora suceljeProcesora = SuceljeProcesora.SOCKET_AM3;
			 System.out.println("Tip sucelja procesora: " + suceljeProcesora.name() );
		 }
		 if(redniBrojSucelja == 3){
			 SuceljeProcesora suceljeProcesora = SuceljeProcesora.SOCKET_LGA_1151;
			 System.out.println("Tip sucelja procesora: " + suceljeProcesora.name() );
		 }
		 if(redniBrojSucelja == 4){
			 SuceljeProcesora suceljeProcesora = SuceljeProcesora.SOCKET_G3;
			 System.out.println("Tip sucelja procesora: " + suceljeProcesora.name() );
		 }
		 
		 System.out.println("Brzina procesora: " + brzina + " GHz");
		
	}
	
	@Override
	public String toString(){
		return "Naziv proizvodaca procesora: " + super.nazivProizvodaca+"\n Cijena procesora: "+ super.cijena;
	}

}
