package hr.java.vjezbe.glavna;

import hr.java.vjezbe.entitet.*;

import java.util.Scanner;

import java.math.BigDecimal;

public class Glavna {

	public static void main(String[] args) {

		String maticnaPlocaProizvodac, maticnaPlocaTip;
		String procesorProizvodac, procesorTip, procesorTipSucelja;
		String radnaMemorijaProizvodac, radnaMemorijaTip;
		String tvrdiDiskProizvodac, tvrdiDiskTip;
		BigDecimal procesorBrzina;
		BigDecimal tvrdiDiskKapacitet;
		Integer radnaMemorijaKapacitet;

		Scanner unos = new Scanner(System.in);

		System.out.println("Unesite proizvodaca maticne ploce racunala: ");
		// unos teksta, jedan redak
		maticnaPlocaProizvodac = unos.nextLine();

		System.out.println("Unesite tip maticne ploce racunala: ");
		maticnaPlocaTip = unos.nextLine();

		System.out.println("Unesite proizvodaca procesora racunala: ");
		procesorProizvodac = unos.nextLine();

		System.out.println("Unesite tip procesora racunala: ");
		procesorTip = unos.nextLine();

		System.out.println("Unesite tip sucelja procesora racunala: ");
		procesorTipSucelja = unos.nextLine();

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

		unos.close();

		MaticnaPloca maticnaPloca = new MaticnaPloca(maticnaPlocaProizvodac, maticnaPlocaTip);

		Procesor procesor = new Procesor(procesorProizvodac, procesorTip, procesorTipSucelja, procesorBrzina);

		RadnaMemorija radnaMemorija = new RadnaMemorija(radnaMemorijaProizvodac, radnaMemorijaTip, radnaMemorijaKapacitet);

		TvrdiDisk tvrdiDisk = new TvrdiDisk(tvrdiDiskProizvodac, tvrdiDiskTip, tvrdiDiskKapacitet);

		Racunalo racunalo = new Racunalo(maticnaPloca, procesor, radnaMemorija, tvrdiDisk);

		System.out.println("Unesena konfiguracija racunala je sljedeca: ");
		System.out.println("Proizvodac maticne ploce: " + racunalo.getMaticnaPloca().getNazivProizvodaca());
		System.out.println("Tip maticne ploce: " + racunalo.getMaticnaPloca().getTip());
		System.out.println("Proizvodac procesora: " + racunalo.getProcesor().getNazivProizvodaca());
		System.out.println("Tip procesora: " + racunalo.getProcesor().getTip());
		System.out.println("Tip sucelja procesora: " + racunalo.getProcesor().getTipSucelja());
		System.out.println("Brzina procesora: " + racunalo.getProcesor().getBrzina() + " GHz");
		System.out.println("Proizvodac radne memorije: " + racunalo.getRadnaMemorija().getNazivProizvodaca());
		System.out.println("Tip Radne memorije: " + racunalo.getRadnaMemorija().getTip());
		System.out.println("Kapacitet radne memorije: " + racunalo.getRadnaMemorija().getKapacitet() + " GB");
		System.out.println("Proizvodac tvrdog diska: " + racunalo.getTvrdiDisk().getNazivProizvodaca());
		System.out.println("Tip tvrdog diska: " + racunalo.getTvrdiDisk().getTip());
		System.out.println("Kapacitet tvrdog diska: " + racunalo.getTvrdiDisk().getKapacitet() + " TB");

	}

}
