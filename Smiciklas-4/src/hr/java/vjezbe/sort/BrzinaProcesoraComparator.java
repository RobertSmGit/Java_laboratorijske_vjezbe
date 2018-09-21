package hr.java.vjezbe.sort;

import java.util.*;

import hr.java.vjezbe.entitet.*;

/**
 * Komparator koji služi za sortiranje raèunala po brzini procesora
 *
 * @author Smièiklas
 */

public class BrzinaProcesoraComparator implements Comparator<Racunalo>{

	@Override
	public int compare(Racunalo r1, Racunalo r2){
		if(r1.getProcesor().getBrzina().compareTo(r2.getProcesor().getBrzina()) == 1)
			return 1;
		if(r1.getProcesor().getBrzina().compareTo(r2.getProcesor().getBrzina()) == -1)
			return -1;
		return 0;
	}
	
}



