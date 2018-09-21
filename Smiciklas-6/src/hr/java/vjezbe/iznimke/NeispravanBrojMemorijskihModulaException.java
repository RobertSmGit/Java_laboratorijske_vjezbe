package hr.java.vjezbe.iznimke;

public class NeispravanBrojMemorijskihModulaException extends RuntimeException{ 
	
	/**
	 *	Predstavlja informacije o neoznaèenoj iznimci koja se dogaða kod krivo unesenog broja memorijskih modula
	 *
	 * @author Smièiklas
	 */
	
	private static final long serialVersionUID = -3541756289766009309L;
	
	/**
	 * Prima poruku o pogrešci
	 * 
	 * @param poruka poruka o pogrešci
	 */
	public NeispravanBrojMemorijskihModulaException(String poruka){
		super(poruka);
	}
	
	/**
	 * Prima razlog zbog kojeg se dogodila iznimka i šalje ka u nadklasu RunTimeExcetion
	 * 
	 * @param razlog predstavlja razlok zbog kojeg se dogodila iznimka
	 */
	public NeispravanBrojMemorijskihModulaException(Throwable razlog){
		super(razlog);
	}
	
	/**
	 * Prima razlog pojavljivanja iznimke i poruku o pogrešci
	 * 
	 * @param poruka poruka o pogrešci
	 * @param razlog predstavlja razlok zbog kojeg se dogodila iznimka
	 */
	public NeispravanBrojMemorijskihModulaException(String poruka, Throwable razlog){
		super(poruka, razlog);
	}
	
}
