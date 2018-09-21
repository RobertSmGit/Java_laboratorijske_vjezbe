package hr.java.vjezbe.iznimke;

public class NekompatibilnoSuceljeZaProcesorException extends Exception{ // oznacena iznimka
	
	/**
	 *	Predstavlja informacije o ozna�enoj iznimci koja se doga�a kod nekompatibilnosti procesora i mati�ne plo�e
	 *
	 * @author Smi�iklas
	 */
	
	private static final long serialVersionUID = -6410391273951030270L;
	
	/**
	 * Prima poruku o pogre�ci
	 * 
	 * @param poruka poruka o pogre�ci
	 */
	public NekompatibilnoSuceljeZaProcesorException(String poruka){
		super(poruka);
	}
	
	/**
	 * Prima razlog pojavljivanja iznimke i poruku o pogre�ci
	 * 
	 * @param razlog razlog zbog koje se dogodila iznimka
	 */
	public NekompatibilnoSuceljeZaProcesorException(Throwable razlog){
		super(razlog);
	}
	
	/**
	 * Prima razlog pojavljivanja iznimke i poruku o pogre�ci
	 * 
	 * @param poruka poruka o pogre�ci
	 * @param razlog razlog zbog koje se dogodila iznimka
	 */
	public NekompatibilnoSuceljeZaProcesorException(String poruka, Throwable razlog){
		super(poruka, razlog);
	}
	
}
