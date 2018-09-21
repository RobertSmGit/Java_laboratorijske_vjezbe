package hr.java.vjezbe.glavna;

import hr.java.vjezbe.baza.podataka.BazaPodataka;
import hr.java.vjezbe.entitet.*;
import hr.java.vjezbe.iznimke.*;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;


import java.util.Properties;

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
		
		System.out.println("U�itavanje mati�nih plo�a...");
		System.out.println("U�itavanje procesora...");
		System.out.println("U�itavanje radnih memorija...");
		System.out.println("U�itavanje tvrdih diskova...");
		
		System.out.println("Koliko konfiguracija ra�unala �elite unijeti? Odgovor: ");
		brojRacunala = unos.nextInt();
		unos.nextLine();	
		
		for(int i = 0; i < brojRacunala; i++){
			System.out.println("Unos konfiguracije " + (i+1) + ". racunala: ");
			racunalo.add(racunalo(unos));
		}
		
		Collections.sort(racunalo, (Racunalo r1, Racunalo r2) -> (r1.izracunajCijenuRacunala().compareTo(r2.izracunajCijenuRacunala())));
				
		System.out.println("Najskuplja konfiguracija ra�unala je:");
		
		System.out.println("Ra�unalo: " + racunalo.get(brojRacunala - 1).getMaticnaPloca().toString() + racunalo.get(brojRacunala - 1).getProcesor().toString() + 
				racunalo.get(brojRacunala - 1).getRadnaMemorija().toString() + racunalo.get(brojRacunala - 1).getTvrdiDisk().toString());

		System.out.println("Cijena: " + racunalo.get(brojRacunala - 1).izracunajCijenuRacunala() + " KN");
		
		unos.close();
		
		try{
			connectToDatabase();
		}
		catch(Exception e){
			
		}		
		
	}
	
	
	/**
	 * Prima adresu objekta klase Scanner preko koje unosi podatke o ra�unalu
	 * 	
	 * @param unos sadr�i adresu objekta klase Scanner
	 * @return adresu objekta klase Racunalo
	 */
	static public Racunalo racunalo(Scanner unos) {

		String maticnaPlocaProizvodac, maticnaPlocaTip, maticnaPlocaTipSucelja;
		String procesorProizvodac, procesorTip;
		String radnaMemorijaProizvodac, radnaMemorijaTip;
		String tvrdiDiskProizvodac, tvrdiDiskTip;
		BigDecimal procesorBrzina, tvrdiDiskKapacitet, maticnaPlocaCijena = null, procesorCijena = null, radnaMemorijaCijena = null, tvrdiDiskCijena = null;
		Integer radnaMemorijaKapacitet;
		int maticnaPlocaBrojModula = 0;
		boolean brojModula = false;
		
		int odabirMaticnePloce = 0, odabirProcesora = 0, odabirRadneMemorije = 0, odabirTvrdogDiska = 0;		
		
		GlavnaDatoteke glavnaDatoteke = new GlavnaDatoteke();
		glavnaDatoteke.ucitajMaticnePloce();
		glavnaDatoteke.ucitajProcesore();
		glavnaDatoteke.ucitajRadneMemorije();
		glavnaDatoteke.ucitajTvrdiDisk();

		System.out.println("Odaberite mati�nu plo�u: ");
		System.out.println("1) " + glavnaDatoteke.ucitajMaticnePloce().get(0).toString());
		System.out.println("2) " + glavnaDatoteke.ucitajMaticnePloce().get(1).toString());
		System.out.println("3) " + glavnaDatoteke.ucitajMaticnePloce().get(2).toString());
		odabirMaticnePloce = unos.nextInt();
		System.out.println("Odabir >> " + odabirMaticnePloce);
		
		
		System.out.println("Odaberite procesor: ");
		System.out.println("1) " + glavnaDatoteke.ucitajProcesore().get(0).toString());
		System.out.println("2) " + glavnaDatoteke.ucitajProcesore().get(1).toString());
		System.out.println("3) " + glavnaDatoteke.ucitajProcesore().get(2).toString());
		
		do{
			odabirProcesora = unos.nextInt();
			System.out.println("Odabir >> " + odabirProcesora);
			if(!(glavnaDatoteke.ucitajProcesore().get(odabirProcesora - 1).getSucelje().equals(glavnaDatoteke.ucitajMaticnePloce().get(odabirMaticnePloce - 1).getTipSuceljaZaProcesor())))
					System.out.println("Odabrani su nekompatibilni mati�na plo�a i procesor. Molimo odaberite drugi procesor. ");
		}while(!(glavnaDatoteke.ucitajProcesore().get(odabirProcesora - 1).getSucelje().equals(glavnaDatoteke.ucitajMaticnePloce().get(odabirMaticnePloce - 1).getTipSuceljaZaProcesor())));
		
		System.out.println("Odaberite radnu memoriju: ");
		System.out.println("1) " + glavnaDatoteke.ucitajRadneMemorije().get(0).toString());
		System.out.println("2) " + glavnaDatoteke.ucitajRadneMemorije().get(1).toString());
		System.out.println("3) " + glavnaDatoteke.ucitajRadneMemorije().get(2).toString());
		odabirRadneMemorije = unos.nextInt();
		System.out.println("Odabir >> " + odabirRadneMemorije);
		
		do{
			System.out.println("Odaberite broja modula radne memorije >> ");
			maticnaPlocaBrojModula = unos.nextInt();
			logger.info("Unesen je broj " + maticnaPlocaBrojModula);
				
			try{
				provjeriBrojModula(maticnaPlocaBrojModula, glavnaDatoteke.ucitajMaticnePloce().get(odabirMaticnePloce-1).getMaksimalanBrojMemorijskihModula());
				brojModula = true;
			}
			catch(NeispravanBrojMemorijskihModulaException e){
				logger.info(e.getMessage(), e);
				System.out.println(e.getMessage());
			}
		}while(brojModula == false);
		
		System.out.println("Odaberite tvrdi disk: ");
		System.out.println("1) " + glavnaDatoteke.ucitajTvrdiDisk().get(0).toString());
		System.out.println("2) " + glavnaDatoteke.ucitajTvrdiDisk().get(1).toString());
		System.out.println("3) " + glavnaDatoteke.ucitajTvrdiDisk().get(2).toString());
		odabirTvrdogDiska = unos.nextInt();
		System.out.println("Odabir >> " + odabirTvrdogDiska);
	
		
		maticnaPlocaProizvodac = glavnaDatoteke.ucitajMaticnePloce().get(odabirMaticnePloce - 1).getNazivProizvodaca();
		maticnaPlocaTip = glavnaDatoteke.ucitajMaticnePloce().get(odabirMaticnePloce - 1).getTip();
		maticnaPlocaTipSucelja = glavnaDatoteke.ucitajMaticnePloce().get(odabirMaticnePloce - 1).getTipSuceljaZaProcesor();
		maticnaPlocaCijena = glavnaDatoteke.ucitajMaticnePloce().get(odabirMaticnePloce - 1).getCijena();
		
		procesorProizvodac = glavnaDatoteke.ucitajProcesore().get(odabirProcesora - 1).getNazivProizvodaca();
		procesorTip = glavnaDatoteke.ucitajProcesore().get(odabirProcesora - 1).getTip();
		procesorBrzina = glavnaDatoteke.ucitajProcesore().get(odabirProcesora - 1).getBrzina();
		procesorCijena = glavnaDatoteke.ucitajProcesore().get(odabirProcesora - 1).getCijena();
		
		radnaMemorijaProizvodac = glavnaDatoteke.ucitajRadneMemorije().get(odabirRadneMemorije - 1).getNazivProizvodaca();
		radnaMemorijaTip = glavnaDatoteke.ucitajRadneMemorije().get(odabirRadneMemorije - 1).getTip();
		radnaMemorijaKapacitet = glavnaDatoteke.ucitajRadneMemorije().get(odabirRadneMemorije - 1).getKapacitet();
		radnaMemorijaCijena = glavnaDatoteke.ucitajRadneMemorije().get(odabirRadneMemorije - 1).getCijena();
		
		tvrdiDiskProizvodac = glavnaDatoteke.ucitajTvrdiDisk().get(odabirTvrdogDiska - 1).getNazivProizvodaca();
		tvrdiDiskTip = glavnaDatoteke.ucitajTvrdiDisk().get(odabirTvrdogDiska - 1).getTip();
		tvrdiDiskKapacitet = glavnaDatoteke.ucitajTvrdiDisk().get(odabirTvrdogDiska - 1).getKapacitet();
		tvrdiDiskCijena = glavnaDatoteke.ucitajTvrdiDisk().get(odabirTvrdogDiska - 1).getCijena();
			

		MaticnaPloca maticnaPloca = new MaticnaPloca(maticnaPlocaProizvodac, maticnaPlocaTip, maticnaPlocaTipSucelja, maticnaPlocaBrojModula, maticnaPlocaCijena);
		Procesor procesor = new Procesor(procesorProizvodac, procesorTip, procesorBrzina, maticnaPlocaTipSucelja, procesorCijena);
		RadnaMemorija radnaMemorija = new RadnaMemorija(radnaMemorijaProizvodac, radnaMemorijaTip,radnaMemorijaKapacitet, radnaMemorijaCijena);
		TvrdiDisk tvrdiDisk = new TvrdiDisk(tvrdiDiskProizvodac, tvrdiDiskTip, tvrdiDiskKapacitet, tvrdiDiskCijena);
		Racunalo racunalo = new Racunalo(maticnaPloca, procesor, radnaMemorija, tvrdiDisk, maticnaPlocaBrojModula);
	
		return racunalo;
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
	public static void provjeriBrojModula(int brojModula, int maksimalanBrojModula) throws NeispravanBrojMemorijskihModulaException{
		if(brojModula < 1 || brojModula > maksimalanBrojModula)
			throw new NeispravanBrojMemorijskihModulaException("Pogre�ka! Unijeli ste neispravan broj memorijskih modula. Mati�na plo�a podr�ava izme�u 1 i " + maksimalanBrojModula + " memorijskih modula!");
	}
	
	
	public static void connectToDatabase() throws SQLException, IOException{
		Properties svojstva = new Properties();
		
		svojstva.setProperty("bazaPodatakaUrl", "jdbc:h2:tcp://localhost/~/JavaFX-2015");
		svojstva.setProperty("korisnickoIme", "student");
		svojstva.setProperty("lozinka", "student");
		
		FileWriter writer = new FileWriter ("bazaPodataka.properties");
		svojstva.store(writer, " ");
		writer.close();
	}
	
	
}