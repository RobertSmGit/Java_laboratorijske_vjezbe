package hr.java.vjezbe.entitet;

import java.math.BigDecimal;

/**
 *  Predstavlja su�elje koje sadr�i podrazumjevanu metodu za overclockanje procesora,
 *  ta medoda pove�ava frekveciju procesora za 50%
 *  
 *  @author Smi�iklas
 */

public interface Frekvencijska {

	/**
	 * overclock podrazumjevana metoda koja overclock-a procesor
	 * @param brzina frekvencija procesora prije overclockanja
	 * @return frekvenciju procesora pove�anu za 50% 
	 */
	default BigDecimal overclock(BigDecimal brzina) {
		BigDecimal novaBrzina = brzina.multiply(new BigDecimal(1.5));
		return novaBrzina;
	}
}

