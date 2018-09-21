package hr.java.vjezbe.glavna;

import hr.java.vjezbe.entitet.*;

import hr.java.vjezbe.iznimke.*;

import java.util.Scanner;

import java.math.BigDecimal;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

/**
 *	Glavni program
 *
 * @author Smi�iklas
 * 
 */
public class Glavna {
	
	private static final Logger logger = LoggerFactory.getLogger(Glavna.class);

	public static void main(String[] args) {
		
		Scanner unos = new Scanner(System.in);

		Racunalo[] racunalo = new Racunalo[2];
		
		System.out.println("Unos podataka prvog racunala: ");
		racunalo[0] = racunalo(unos);

		System.out.println("Unos podataka drugog racunala: ");
		racunalo[1] = racunalo(unos);
	
		/**
		 * Prima adresu objekta klase Ra�unalo i izvr�ava ispis
		 */
		ispis(racunalo);

		unos.close();
		
	}
	
	/**
	 * Prima adresu objekta klase Scanner preko koje unosi podatke o ra�unalu
	 * Provjerava kompatibilnost su�elja izme�u procesora i mati�ne plo�e
	 * Provjerava je li uneseni broj modula radne memorije ve�i od dozvoljenog
	 * 	
	 * @param unos sadr�i adresu objekta klase Scanner
	 * @return adresu objekta klase Racunalo
	 */
	static public Racunalo racunalo(Scanner unos) {

		String maticnaPlocaProizvodac, maticnaPlocaTip;
		String procesorProizvodac, procesorTip, procesorTipSucelja = null;
		String radnaMemorijaProizvodac, radnaMemorijaTip;
		String tvrdiDiskProizvodac, tvrdiDiskTip;
		BigDecimal procesorBrzina;
		BigDecimal tvrdiDiskKapacitet;
		Integer radnaMemorijaKapacitet;
		int redniBrojSuceljaProcesor = 0, redniBrojSuceljaMaticnaPloca, maticnaPlocaBrojModula = 0, maksimalanBrojMemorijkihModula;
		boolean pogodio = false, brojModula = false;
			
		System.out.println("Unesite proizvodaca maticne ploce racunala: ");
		maticnaPlocaProizvodac = unos.nextLine();

		System.out.println("Unesite tip maticne ploce racunala: ");
		maticnaPlocaTip = unos.nextLine();
			
		do {
			System.out.println("Unesite tip sucelja procesora racunala (odaberite broj ispred zeljenog sucelja): ");
			System.out.println("1) SOCKET_AM2");
			System.out.println("2) SOCKET_AM3");
			System.out.println("3) SOCKET_LGA_1151");
			System.out.println("4) SOCKET_G3");
		
			redniBrojSuceljaProcesor = unos.nextInt();
				
			if (redniBrojSuceljaProcesor < 1 || redniBrojSuceljaProcesor > 4)
				System.out.println("Pogreska kod odabira, molimo pokusajte ponovno! ");	
		} while (redniBrojSuceljaProcesor < 1 || redniBrojSuceljaProcesor > 4);
			
		Procesor proc = new Procesor (null, null, null, 0);
		if (redniBrojSuceljaProcesor == 1)
			procesorTipSucelja = proc.sucelje1;
		if (redniBrojSuceljaProcesor == 2)
			procesorTipSucelja = proc.sucelje2;
		if (redniBrojSuceljaProcesor == 3)
			procesorTipSucelja = proc.sucelje3;
		if (redniBrojSuceljaProcesor == 4)
			procesorTipSucelja = proc.sucelje4;
			
		System.out.println("Unesite maksimalan broj memorijskih modula : ");
		maksimalanBrojMemorijkihModula = unos.nextInt();
		unos.nextLine();
			
		do{
			System.out.println("Unesite broj modula koji zelite ugraditi na maticnu plocu: ");
			maticnaPlocaBrojModula = unos.nextInt();
			logger.info("Unesen je broj " + maticnaPlocaBrojModula);
				
			try{
				/**
				 * Prima podatke o broju modula i maksimalnom broju modula mati�ne plo�e i provjerava je li broj modula ve�i od maksimalnog
				 * 
				 * @param maticnaPlocaBrojModula podatak o unesenom broju modula mati�ne plo�e
				 * @param maksimalanBrojMemorijkihModula podatak o maksimalnom broju modula mati�ne plo�e
				 */
				provjeriBrojModula(maticnaPlocaBrojModula, maksimalanBrojMemorijkihModula);
				brojModula = true;
			}
			catch(NeispravanBrojMemorijskihModulaException e){
				logger.info(e.getMessage(), e);
				System.out.println(e.getMessage());
			}
		}while(brojModula == false);
			
		unos.nextLine();

		System.out.println("Unesite proizvodaca procesora racunala: ");
		procesorProizvodac = unos.nextLine();
		System.out.println("Unesite tip procesora racunala: ");
		procesorTip = unos.nextLine();
		
		pogodio = false;
		do {
			System.out.println("1) SOCKET_AM2");
			System.out.println("2) SOCKET_AM3 ");
			System.out.println("3) SOCKET_LGA_1151 ");
			System.out.println("4) SOCKET_G3 ");
	
			redniBrojSuceljaMaticnaPloca = unos.nextInt();
			logger.info("Odabrano je sucelje: " + redniBrojSuceljaMaticnaPloca);
				
			if (redniBrojSuceljaMaticnaPloca < 1 || redniBrojSuceljaMaticnaPloca > 4)
				System.out.println("Pogreska kod odabira, molimo pokusajte ponovno! ");
					
			try{
				/**
				 * Prima podatke o rednom broju sucelja mati�ne plo�e i rednom broju su�elja procesora, te provjerava jesu li komaptibilni (jednaki), svaki od brojeva(1,2,3,4) ozna�ava jedno su�elje
				 * 
				 * @param redniBrojSuceljaProcesor podatak o rednom broju su�elja procesora, svaki od brojeva(1,2,3,4) ozna�ava jedno su�elje
				 * @param maksimalanBrojMemorijkihModula podatak o rednom broju su�elja procesora, svaki od brojeva(1,2,3,4) ozna�ava jedno su�elje
				 */
				provjera(redniBrojSuceljaProcesor, redniBrojSuceljaMaticnaPloca);
				pogodio = true;
			}
			catch(NekompatibilnoSuceljeZaProcesorException ex){
				logger.info(ex.getMessage(), ex);
				System.out.println(ex.getMessage());
			}
		} while (pogodio == false);
			
		System.out.println("Unesite brzinu procesora racunala (u GHz): ");
		procesorBrzina = unos.nextBigDecimal();
		unos.nextLine();

		System.out.println("Unesite proizvodaca radne memorije racunala: ");
		radnaMemorijaProizvodac = unos.nextLine();

		System.out.println("Unesite tip radne memorije racunala: ");
		radnaMemorijaTip = unos.nextLine();

		System.out.println("Unesite kapacitet radne memorije racunala (u GB): ");
		radnaMemorijaKapacitet = unos.nextInt();
		unos.nextLine();

		System.out.println("Unesite proizvodaca tvrdog diska racunala : ");
		tvrdiDiskProizvodac = unos.nextLine();

		System.out.println("Unesite tip tvrdog diska racunala : ");
		tvrdiDiskTip = unos.nextLine();

		System.out.println("Unesite kapacitet tvrdog diska racunala (u TB): ");
		tvrdiDiskKapacitet = unos.nextBigDecimal();
		unos.nextLine();

		MaticnaPloca maticnaPloca = new MaticnaPloca(maticnaPlocaProizvodac, maticnaPlocaTip, procesorTipSucelja, maticnaPlocaBrojModula );
		Procesor procesor = new Procesor(procesorProizvodac, procesorTip, procesorBrzina, redniBrojSuceljaProcesor);
		RadnaMemorija radnaMemorija = new RadnaMemorija(radnaMemorijaProizvodac, radnaMemorijaTip,radnaMemorijaKapacitet);
		TvrdiDisk tvrdiDisk = new TvrdiDisk(tvrdiDiskProizvodac, tvrdiDiskTip, tvrdiDiskKapacitet);
		Racunalo racunalo = new Racunalo(maticnaPloca, procesor, radnaMemorija, tvrdiDisk);
		
		return racunalo;	
	}
	
	/**
	 * Pove�ava radnu memoriju kod ra�unala koje ima manju radnu memoriju
	 * Pove�ava frekvenciju procesora kod ra�unala koje ima slabiji procesor
	 * Ako oba ra�unala imaju isti iznos radne memorije ili istu brzinu procesora ne radi ni�ta
	 * Prije i nakon promjena na ra�unalima ispisuje njihove konfiguracije
	 * 
	 * @param racunalo sadr�i adresu prvog objekta u polju objekata klase Ra�unalo
	 */
	static public void ispis(Racunalo[] racunalo) {
		
		BigDecimal privremenaBrzina = null;
		Integer privremeniKapacitet = 0;
		
		for (int j = 0; j < 2; j++) {
			
			if(j == 1){				
				privremenaBrzina = racunalo[1].getProcesor().getBrzina();
				if (racunalo[0].getProcesor().getBrzina().compareTo(racunalo[1].getProcesor().getBrzina()) == 1)	
					racunalo[1].getProcesor().setBrzina(racunalo[1].getProcesor().overclock(racunalo[1].getProcesor().getBrzina()));
			
				if (privremenaBrzina.compareTo(racunalo[0].getProcesor().getBrzina()) == 1)
					racunalo[0].getProcesor().setBrzina(racunalo[0].getProcesor().overclock(racunalo[0].getProcesor().getBrzina()));
				
				privremeniKapacitet = racunalo[1].getRadnaMemorija().getKapacitet();
				if (racunalo[0].getRadnaMemorija().getKapacitet() > racunalo[1].getRadnaMemorija().getKapacitet())
					racunalo[1].getRadnaMemorija().uvecajKapacitet();
			
				if (privremeniKapacitet > racunalo[0].getRadnaMemorija().getKapacitet())
					racunalo[0].getRadnaMemorija().uvecajKapacitet();				
			}
			
			for (int i = 0; i < 2; i++) {
				
				if (j == 1 && i == 0) {
					System.out.println("Nakon promjena, konfiguracije racunala su sljedeca: ");
					System.out.println(" ");
				}

				if (i == 0)
					System.out.println("Prvo Racunalo: ");
				if (i == 1)
					System.out.println("Drugo Racunalo: ");
				
				System.out.println("Proizvodac maticne ploce: " + racunalo[i].getMaticnaPloca().getNazivProizvodaca());
				System.out.println("Tip maticne ploce: " + racunalo[i].getMaticnaPloca().getTip());
				System.out.println("Proizvodac procesora: " + racunalo[i].getProcesor().getNazivProizvodaca());
				System.out.println("Tip procesora: " + racunalo[i].getProcesor().getTip());
				System.out.println("Tip sucelja procesora: " + racunalo[i].getMaticnaPloca().getTipSuceljaZaProcesor());
				System.out.println("Brzina procesora: " + racunalo[i].getProcesor().getBrzina() + " GHz");
				System.out.println("Proizvodac radne memorije: " + racunalo[i].getRadnaMemorija().getNazivProizvodaca());
				System.out.println("Tip radne memorije: " + racunalo[i].getRadnaMemorija().getTip());
				System.out.println("Kapacitet radne memorije: "	+ Memorijska.pretvoriUTB(racunalo[i].getRadnaMemorija().getKapacitet()) + " TB");
				System.out.println("Proizvodac tvrdog diska: " + racunalo[i].getTvrdiDisk().getNazivProizvodaca());
				System.out.println("Tip tvrdog diska: " + racunalo[i].getTvrdiDisk().getTip());
				System.out.println("Kapacitet tvrdog diska: " + racunalo[i].getTvrdiDisk().getKapacitet() + " GB \n");
			}
		}
	}
	
	
	/**
	 * Prima podatke o rednom broju sucelja mati�ne plo�e i rednom broju su�elja procesora, 
	 * te provjerava jesu li komaptibilni (jednaki), svaki od brojeva(1,2,3,4) ozna�ava jedno su�elje
	 * 
	 * @param redniBrojSuceljaProcesor podatak o rednom broju sucelja procesora, svaki od brojeva(1,2,3,4) ozna�ava jedno su�elje
	 * @param redniBrojSuceljaMaticnaPloca podatak o rednom broju sucelja procesora, svaki od brojeva(1,2,3,4) ozna�ava jedno su�elje
	 * 
	 * @exception NekompatibilnoSuceljeZaProcesorException javlja ako je odabrani broj su�elja za procesor i su�elja mati�ne plo�e nisu jednaki
	 */
	public static void provjera(int redniBrojSuceljaProcesor, int redniBrojSuceljaMaticnaPloca) throws NekompatibilnoSuceljeZaProcesorException{
		boolean kompatibilnost = false;
		if(redniBrojSuceljaProcesor==redniBrojSuceljaMaticnaPloca)
			kompatibilnost = true;
		if(kompatibilnost == false)
			throw new NekompatibilnoSuceljeZaProcesorException("Pogre�ka! Tip su�elja procesora mora se podudarati s tipom su�elja za procesor na mati�noj plo�i!");		
	}
	
	
	/**
	 * Prima podatke o broju modula i maksimalnom broju modula mati�ne plo�e i provjerava je li broj modula ve�i od maksimalnog broja
	 * @param brojModula podatak o unesenom broju modula mati�ne plo�e
	 * @param maksimalanBrojModula podatak o maksimalnom broju modula mati�ne plo�e
	 * 
	 * @exception NeispravanBrojMemorijskihModulaException Iznimka se javlja ako je uneseni broj modula manji od 1 i ve�i od maksimalnog
	 */
	public static void provjeriBrojModula(int brojModula, int maksimalanBrojModula){
		if(brojModula < 1 || brojModula > maksimalanBrojModula)
			throw new NeispravanBrojMemorijskihModulaException("Pogre�ka! Unijeli ste neispravan broj memorijskih modula. Mati�na plo�a podr�ava izme�u 1 i " + maksimalanBrojModula + " memorijskih modula!");
	}
}