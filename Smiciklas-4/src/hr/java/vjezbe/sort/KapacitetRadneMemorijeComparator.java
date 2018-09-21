package hr.java.vjezbe.sort;

import java.util.*;

import hr.java.vjezbe.entitet.*;

/**
 * Komparator koji slu�i za sortiranje ra�unala po kapacitetu
 *
 * @author Smi�iklas
 */

public class KapacitetRadneMemorijeComparator implements Comparator<Racunalo>{

	@Override
	public int compare(Racunalo r1, Racunalo r2){
		if(r1.getRadnaMemorija().getKapacitet() < r2.getRadnaMemorija().getKapacitet())
			return 1;
		if(r1.getRadnaMemorija().getKapacitet() > r2.getRadnaMemorija().getKapacitet())
			return 1;
		return 0;
	}
	
}
