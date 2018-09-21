package hr.java.vjezbe.iznimke;

public class NekompatibilnoSuceljeZaProcesorException extends Exception{ // oznacena iznimka
	
	/**
	 *	Predstavlja informacije o oznaèenoj iznimci koja se dogaða kod nekompatibilnosti procesora i matiène ploèe
	 *
	 * @author Smièiklas
	 */
	
	private static final long serialVersionUID = -6410391273951030270L;
	
	/**
	 * Prima poruku o pogrešci
	 * 
	 * @param poruka poruka o pogrešci
	 */
	public NekompatibilnoSuceljeZaProcesorException(String poruka){
		super(poruka);
	}
	
	/**
	 * Prima razlog pojavljivanja iznimke i poruku o pogrešci
	 * 
	 * @param razlog razlog zbog koje se dogodila iznimka
	 */
	public NekompatibilnoSuceljeZaProcesorException(Throwable razlog){
		super(razlog);
	}
	
	/**
	 * Prima razlog pojavljivanja iznimke i poruku o pogrešci
	 * 
	 * @param poruka poruka o pogrešci
	 * @param razlog razlog zbog koje se dogodila iznimka
	 */
	public NekompatibilnoSuceljeZaProcesorException(String poruka, Throwable razlog){
		super(poruka, razlog);
	}
	
}
