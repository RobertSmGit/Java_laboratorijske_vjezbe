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
 * @author Smièiklas
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
		 * Prima adresu objekta klase Raèunalo i izvršava ispis
		 */
		ispis(racunalo);

		unos.close();
		
	}
	
	/**
	 * Prima adresu objekta klase Scanner preko koje unosi podatke o raèunalu
	 * Provjerava kompatibilnost suèelja izmeðu procesora i matiène ploèe
	 * Provjerava je li uneseni broj modula radne memorije veæi od dozvoljenog
	 * 	
	 * @param unos sadrži adresu objekta klase Scanner
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
				 * Prima podatke o broju modula i maksimalnom broju modula matiène ploèe i provjerava je li broj modula veæi od maksimalnog
				 * 
				 * @param maticnaPlocaBrojModula podatak o unesenom broju modula matiène ploèe
				 * @param maksimalanBrojMemorijkihModula podatak o maksimalnom broju modula matiène ploèe
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
				 * Prima podatke o rednom broju sucelja matiène ploèe i rednom broju suèelja procesora, te provjerava jesu li komaptibilni (jednaki), svaki od brojeva(1,2,3,4) oznaèava jedno suèelje
				 * 
				 * @param redniBrojSuceljaProcesor podatak o rednom broju suèelja procesora, svaki od brojeva(1,2,3,4) oznaèava jedno suèelje
				 * @param maksimalanBrojMemorijkihModula podatak o rednom broju suèelja procesora, svaki od brojeva(1,2,3,4) oznaèava jedno suèelje
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
	 * Poveæava radnu memoriju kod raèunala koje ima manju radnu memoriju
	 * Poveæava frekvenciju procesora kod raèunala koje ima slabiji procesor
	 * Ako oba raèunala imaju isti iznos radne memorije ili istu brzinu procesora ne radi ništa
	 * Prije i nakon promjena na raèunalima ispisuje njihove konfiguracije
	 * 
	 * @param racunalo sadrži adresu prvog objekta u polju objekata klase Raèunalo
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
	 * Prima podatke o rednom broju sucelja matiène ploèe i rednom broju suèelja procesora, 
	 * te provjerava jesu li komaptibilni (jednaki), svaki od brojeva(1,2,3,4) oznaèava jedno suèelje
	 * 
	 * @param redniBrojSuceljaProcesor podatak o rednom broju sucelja procesora, svaki od brojeva(1,2,3,4) oznaèava jedno suèelje
	 * @param redniBrojSuceljaMaticnaPloca podatak o rednom broju sucelja procesora, svaki od brojeva(1,2,3,4) oznaèava jedno suèelje
	 * 
	 * @exception NekompatibilnoSuceljeZaProcesorException javlja ako je odabrani broj suèelja za procesor i suèelja matiène ploèe nisu jednaki
	 */
	public static void provjera(int redniBrojSuceljaProcesor, int redniBrojSuceljaMaticnaPloca) throws NekompatibilnoSuceljeZaProcesorException{
		boolean kompatibilnost = false;
		if(redniBrojSuceljaProcesor==redniBrojSuceljaMaticnaPloca)
			kompatibilnost = true;
		if(kompatibilnost == false)
			throw new NekompatibilnoSuceljeZaProcesorException("Pogreška! Tip suèelja procesora mora se podudarati s tipom suèelja za procesor na matiènoj ploèi!");		
	}
	
	
	/**
	 * Prima podatke o broju modula i maksimalnom broju modula matiène ploèe i provjerava je li broj modula veæi od maksimalnog broja
	 * @param brojModula podatak o unesenom broju modula matiène ploèe
	 * @param maksimalanBrojModula podatak o maksimalnom broju modula matiène ploèe
	 * 
	 * @exception NeispravanBrojMemorijskihModulaException Iznimka se javlja ako je uneseni broj modula manji od 1 i veæi od maksimalnog
	 */
	public static void provjeriBrojModula(int brojModula, int maksimalanBrojModula){
		if(brojModula < 1 || brojModula > maksimalanBrojModula)
			throw new NeispravanBrojMemorijskihModulaException("Pogreška! Unijeli ste neispravan broj memorijskih modula. Matièna ploèa podržava izmeðu 1 i " + maksimalanBrojModula + " memorijskih modula!");
	}
}