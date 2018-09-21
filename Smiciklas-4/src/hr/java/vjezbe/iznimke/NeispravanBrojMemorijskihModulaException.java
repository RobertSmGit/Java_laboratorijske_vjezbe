package hr.java.vjezbe.iznimke;

public class NeispravanBrojMemorijskihModulaException extends RuntimeException{ 
	
	/**
	 *	Predstavlja informacije o neozna�enoj iznimci koja se doga�a kod krivo unesenog broja memorijskih modula
	 *
	 * @author Smi�iklas
	 */
	
	private static final long serialVersionUID = -3541756289766009309L;
	
	/**
	 * Prima poruku o pogre�ci
	 * 
	 * @param poruka poruka o pogre�ci
	 */
	public NeispravanBrojMemorijskihModulaException(String poruka){
		super(poruka);
	}
	
	/**
	 * Prima razlog zbog kojeg se dogodila iznimka i �alje ka u nadklasu RunTimeExcetion
	 * 
	 * @param razlog predstavlja razlok zbog kojeg se dogodila iznimka
	 */
	public NeispravanBrojMemorijskihModulaException(Throwable razlog){
		super(razlog);
	}
	
	/**
	 * Prima razlog pojavljivanja iznimke i poruku o pogre�ci
	 * 
	 * @param poruka poruka o pogre�ci
	 * @param razlog predstavlja razlok zbog kojeg se dogodila iznimka
	 */
	public NeispravanBrojMemorijskihModulaException(String poruka, Throwable razlog){
		super(poruka, razlog);
	}
	
}
