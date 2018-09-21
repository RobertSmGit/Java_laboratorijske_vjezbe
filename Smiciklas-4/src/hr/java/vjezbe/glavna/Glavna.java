package hr.java.vjezbe.glavna;

import hr.java.vjezbe.entitet.*;

import hr.java.vjezbe.iznimke.*;

import hr.java.vjezbe.sort.*;

import java.util.Scanner;

import java.math.BigDecimal;

import java.util.*;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

/**
 * @author Smi�iklas
 * 
 */
public class Glavna {
	
	private static final Logger logger = LoggerFactory.getLogger(Glavna.class);

	public static void main(String[] args) {
		
		int brojRacunala = 0;
		Scanner unos = new Scanner(System.in);
		
		List<Racunalo> racunalo = new ArrayList<>();
		
		System.out.println("Koliko konfiguracija ra�unala �elite unijeti? Odgovor: ");
		brojRacunala = unos.nextInt();
		unos.nextLine();

		for(int i = 0; i < brojRacunala; i++){
			System.out.println("Unos podataka " + (i+1) + ". racunala: ");
			racunalo.add(racunalo(unos));
		}
		
		sortIspisKonfiguracija(racunalo);
		
		sortIspisKonfiguracijaLambda(racunalo);
		
		Trgovina<Komponenta> trgovina = new Trgovina<>();
		
		for(int i = 0; i < brojRacunala; i++){
			trgovina.dodajKomponentu(racunalo.get(i).getMaticnaPloca());
			trgovina.dodajKomponentu(racunalo.get(i).getProcesor());
			trgovina.dodajKomponentu(racunalo.get(i).getRadnaMemorija());
			trgovina.dodajKomponentu(racunalo.get(i).getTvrdiDisk());
		}

		System.out.println("Najjeftinija komponenta: ");
		System.out.println("Cijena komponente: " + trgovina.najjeftinijaKomponenta().getCijena());
		System.out.println("Naziv proizvodaca komponente: " + trgovina.najjeftinijaKomponenta().getNazivProizvodaca());
		trgovina.najjeftinijaKomponenta().bazaKomponenti();
		System.out.println(" ");
		
		System.out.println("Najskuplja komponenta: ");
		System.out.println("Cijena komponente: " + trgovina.najskupljaKomponenta().getCijena());
		System.out.println("Naziv proizvodaca komponente: " + trgovina.najskupljaKomponenta().getNazivProizvodaca());
		trgovina.najskupljaKomponenta().bazaKomponenti();
		
		unos.close();
	}
	
	
	/**
	 * Prima adresu objekta klase Scanner preko koje unosi podatke o ra�unalu
	 * 	
	 * @param unos sadr�i adresu objekta klase Scanner
	 * @return adresu objekta klase Racunalo
	 */
	static public Racunalo racunalo(Scanner unos) {

		String maticnaPlocaProizvodac, maticnaPlocaTip;
		String procesorProizvodac, procesorTip, procesorTipSucelja = null;
		String radnaMemorijaProizvodac, radnaMemorijaTip;
		String tvrdiDiskProizvodac, tvrdiDiskTip;
		BigDecimal procesorBrzina, tvrdiDiskKapacitet, maticnaPlocaCijena = null, procesorCijena = null, radnaMemorijaCijena = null, tvrdiDiskCijena = null;
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
			
		if (redniBrojSuceljaProcesor == 1){
			SuceljeProcesora suceljeProcesora = SuceljeProcesora.SOCKET_AM2;
			procesorTipSucelja = suceljeProcesora.name();
		}
		if (redniBrojSuceljaProcesor == 2){
			SuceljeProcesora suceljeProcesora = SuceljeProcesora.SOCKET_AM3;
			procesorTipSucelja = suceljeProcesora.name();
		}
		if (redniBrojSuceljaProcesor == 3){
			SuceljeProcesora suceljeProcesora = SuceljeProcesora.SOCKET_LGA_1151;
			procesorTipSucelja = suceljeProcesora.name();
		}
		if (redniBrojSuceljaProcesor == 4){
			SuceljeProcesora suceljeProcesora = SuceljeProcesora.SOCKET_G3;
			procesorTipSucelja = suceljeProcesora.name();
		}
		
		System.out.println("Unesite maksimalan broj memorijskih modula : ");
		maksimalanBrojMemorijkihModula = unos.nextInt();
		unos.nextLine();
			
		do{
			System.out.println("Unesite broj modula koji zelite ugraditi na maticnu plocu: ");
			maticnaPlocaBrojModula = unos.nextInt();
			logger.info("Unesen je broj " + maticnaPlocaBrojModula);
				
			try{
				provjeriBrojModula(maticnaPlocaBrojModula, maksimalanBrojMemorijkihModula);
				brojModula = true;
			}
			catch(NeispravanBrojMemorijskihModulaException e){
				logger.info(e.getMessage(), e);
				System.out.println(e.getMessage());
			}
		}while(brojModula == false);
			
		unos.nextLine();
		
		System.out.println("Unesite cijenu maticne ploce: ");
		maticnaPlocaCijena = unos.nextBigDecimal();
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
		System.out.println("Unesite cijenu procesora racunala: ");
		procesorCijena = unos.nextBigDecimal();
		unos.nextLine();

		System.out.println("Unesite proizvodaca radne memorije racunala: ");
		radnaMemorijaProizvodac = unos.nextLine();
		System.out.println("Unesite tip radne memorije racunala: ");
		radnaMemorijaTip = unos.nextLine();
		System.out.println("Unesite kapacitet radne memorije racunala (u GB): ");
		radnaMemorijaKapacitet = unos.nextInt();
		unos.nextLine();
		System.out.println("Unesite cijenu radne memorije racunala: ");
		radnaMemorijaCijena = unos.nextBigDecimal();
		unos.nextLine();

		System.out.println("Unesite proizvodaca tvrdog diska racunala : ");
		tvrdiDiskProizvodac = unos.nextLine();
		System.out.println("Unesite tip tvrdog diska racunala : ");
		tvrdiDiskTip = unos.nextLine();
		System.out.println("Unesite kapacitet tvrdog diska racunala (u TB): ");
		tvrdiDiskKapacitet = unos.nextBigDecimal();
		unos.nextLine();
		System.out.println("Unesite cijenu tvrdog diska racunala: ");
		tvrdiDiskCijena = unos.nextBigDecimal();
		unos.nextLine();

		MaticnaPloca maticnaPloca = new MaticnaPloca(maticnaPlocaProizvodac, maticnaPlocaTip, procesorTipSucelja, maticnaPlocaBrojModula, maticnaPlocaCijena);
		Procesor procesor = new Procesor(procesorProizvodac, procesorTip, procesorBrzina, redniBrojSuceljaProcesor, procesorCijena);
		RadnaMemorija radnaMemorija = new RadnaMemorija(radnaMemorijaProizvodac, radnaMemorijaTip,radnaMemorijaKapacitet, radnaMemorijaCijena);
		TvrdiDisk tvrdiDisk = new TvrdiDisk(tvrdiDiskProizvodac, tvrdiDiskTip, tvrdiDiskKapacitet, tvrdiDiskCijena);
		Racunalo racunalo = new Racunalo(maticnaPloca, procesor, radnaMemorija, tvrdiDisk);
	
		return racunalo;
	}
	
	
	/**
	 * Ispisuje konfiguraciju ra�unala prije promjena,
	 * nakon �ega sortira listu ra�unala, pove�ava radnu memoriju i procesor kod najslabijeg ra�unala, te vr�i ispis tih ra�unala
	 * 
	 * @param racunalo sadr�i adresu prvog objekta u polju objekata klase Ra�unalo
	 */
	static public void sortIspisKonfiguracija(List<Racunalo> racunalo) {
		
		int duljinaListe = racunalo.size();
		
		for (int i = 0; i < 2; i++) {	
			
			for (int j = 0; j < duljinaListe; j++) {
				
				if(i == 0 && j == 0)
					System.out.println("Unesene konfiguracije ra�unala su sljede�e: \n");
				if(i == 1 && j == 0){
					System.out.println("Nakon prvih promjena, konfiguracije ra�unala su sljede�e: \n");
					Collections.sort(racunalo, new KapacitetRadneMemorijeComparator());
					racunalo.get(0).getRadnaMemorija().uvecajKapacitet();
					Collections.sort(racunalo, new BrzinaProcesoraComparator());
					racunalo.get(0).getProcesor().setBrzina(racunalo.get(0).getProcesor().overclock(racunalo.get(0).getProcesor().getBrzina()));
				}
			
				System.out.println((j+1) + ". racunalo: ");
				System.out.println("Proizvodac maticne ploce: " + racunalo.get(j).getMaticnaPloca().getNazivProizvodaca());
				System.out.println("Tip maticne ploce: " + racunalo.get(j).getMaticnaPloca().getTip());
				System.out.println("Proizvodac procesora: " + racunalo.get(j).getProcesor().getNazivProizvodaca());
				System.out.println("Tip procesora: " + racunalo.get(j).getProcesor().getTip());
				System.out.println("Tip sucelja procesora: " + racunalo.get(j).getMaticnaPloca().getTipSuceljaZaProcesor());
				System.out.println("Brzina procesora: " + racunalo.get(j).getProcesor().getBrzina() + " GHz");
				System.out.println("Proizvodac radne memorije: " + racunalo.get(j).getRadnaMemorija().getNazivProizvodaca());
				System.out.println("Tip radne memorije: " + racunalo.get(j).getRadnaMemorija().getTip());
				System.out.println("Kapacitet radne memorije: "	+ Memorijska.pretvoriUTB(racunalo.get(j).getRadnaMemorija().getKapacitet()) + " TB");
				System.out.println("Proizvodac tvrdog diska: " + racunalo.get(j).getTvrdiDisk().getNazivProizvodaca());
				System.out.println("Tip tvrdog diska: " + racunalo.get(j).getTvrdiDisk().getTip());
				System.out.println("Kapacitet tvrdog diska: " + racunalo.get(j).getTvrdiDisk().getKapacitet() + " GB \n");
			}
			
		}
				
	}
	
	
	/**
	 * Sortira listu ra�unala koriste�i lambda sort, pove�ava radnu memoriju i procesor kod najslabijeg ra�unala, te vr�i ispis tih ra�unala
	 * 
	 * @param racunalo sadr�i adresu prvog objekta u listi objekata klase Ra�unalo
	 */
	static public void sortIspisKonfiguracijaLambda(List<Racunalo> racunalo) {
		
		int duljinaListe = racunalo.size();
			
			for (int j = 0; j < duljinaListe; j++) {
				
				if(j == 0){
					System.out.println("Nakon drugih promjena, konfiguracije ra�unala su sljede�e: \n");
					Collections.sort(racunalo, (Racunalo r1, Racunalo r2) -> (r1.getRadnaMemorija().getKapacitet().compareTo(r2.getRadnaMemorija().getKapacitet())));
					racunalo.get(0).getRadnaMemorija().uvecajKapacitet();
					Collections.sort(racunalo, (Racunalo r1, Racunalo r2) -> (r1.getProcesor().getBrzina().compareTo(r2.getProcesor().getBrzina())));
					racunalo.get(0).getProcesor().setBrzina(racunalo.get(0).getProcesor().overclock(racunalo.get(0).getProcesor().getBrzina()));
				}
				
				System.out.println((j+1) + ". racunalo: ");
				System.out.println("Proizvodac maticne ploce: " + racunalo.get(j).getMaticnaPloca().getNazivProizvodaca());
				System.out.println("Tip maticne ploce: " + racunalo.get(j).getMaticnaPloca().getTip());
				System.out.println("Proizvodac procesora: " + racunalo.get(j).getProcesor().getNazivProizvodaca());
				System.out.println("Tip procesora: " + racunalo.get(j).getProcesor().getTip());
				System.out.println("Tip sucelja procesora: " + racunalo.get(j).getMaticnaPloca().getTipSuceljaZaProcesor());
				System.out.println("Brzina procesora: " + racunalo.get(j).getProcesor().getBrzina() + " GHz");
				System.out.println("Proizvodac radne memorije: " + racunalo.get(j).getRadnaMemorija().getNazivProizvodaca());
				System.out.println("Tip radne memorije: " + racunalo.get(j).getRadnaMemorija().getTip());
				System.out.println("Kapacitet radne memorije: "	+ Memorijska.pretvoriUTB(racunalo.get(j).getRadnaMemorija().getKapacitet()) + " TB");
				System.out.println("Proizvodac tvrdog diska: " + racunalo.get(j).getTvrdiDisk().getNazivProizvodaca());
				System.out.println("Tip tvrdog diska: " + racunalo.get(j).getTvrdiDisk().getTip());
				System.out.println("Kapacitet tvrdog diska: " + racunalo.get(j).getTvrdiDisk().getKapacitet() + " GB \n");
			}
			
		}
	
	
	/**
	 * Prima podatke o rednom broju sucelja mati�ne plo�e i rednom broju su�elja procesora, te provjerava jesu li komaptibilni (jednaki)
	 *
	 * @param redniBrojSuceljaProcesor podatak o rednom broju sucelja procesora, svaki od brojeva(1,2,3,4) ozna�ava jedno su�elje
	 * @param redniBrojSuceljaMaticnaPloca podatak o rednom broju sucelja procesora, svaki od brojeva(1,2,3,4) ozna�ava jedno su�elje
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
	 * 
	 * @param brojModula podatak o unesenom broju modula mati�ne plo�e
	 * @param maksimalanBrojModula podatak o maksimalnom broju modula mati�ne plo�e
	 * @exception NeispravanBrojMemorijskihModulaException Iznimka se javlja ako je uneseni broj modula manji od 1 i ve�i od maksimalnog
	 */
	public static void provjeriBrojModula(int brojModula, int maksimalanBrojModula){
		if(brojModula < 1 || brojModula > maksimalanBrojModula)
			throw new NeispravanBrojMemorijskihModulaException("Pogre�ka! Unijeli ste neispravan broj memorijskih modula. Mati�na plo�a podr�ava izme�u 1 i " + maksimalanBrojModula + " memorijskih modula!");
	}
	
}