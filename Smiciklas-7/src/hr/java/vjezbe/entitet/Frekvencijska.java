package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 *  Predstavlja suèelje koje sadrži podrazumjevanu metodu za overclockanje procesora,
 *  ta medoda poveæava frekveciju procesora za 50%
 *  
 *  @author Smièiklas
 */

public interface Frekvencijska {

	/**
	 * overclock podrazumjevana metoda koja overclock-a procesor
	 * @param brzina frekvencija procesora prije overclockanja
	 * @return frekvenciju procesora poveæanu za 50% 
	 */
	default BigDecimal overclock(BigDecimal brzina) {
		BigDecimal novaBrzina = brzina.multiply(new BigDecimal(1.5));
		return novaBrzina;
	}
}

