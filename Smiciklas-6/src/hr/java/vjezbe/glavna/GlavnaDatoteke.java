package hr.java.vjezbe.glavna;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import hr.java.vjezbe.entitet.*;


public class GlavnaDatoteke {
	public List<MaticnaPloca> ucitajMaticnePloce(){
		List<MaticnaPloca> mPloca = new ArrayList<>();
		try(BufferedReader citac = new BufferedReader(new FileReader("dat\\maticnePloce.txt"))) {
			String lineProizvodac;
			while((lineProizvodac = citac.readLine()) != null) {		
				
				String lineTip = citac.readLine();
				String lineTipSucelja = citac.readLine();	
				Integer lineBrojModula = Integer.parseInt(citac.readLine()); 		
				BigDecimal lineCijena = new BigDecimal( citac.readLine());
				
				MaticnaPloca matPloca = new MaticnaPloca(lineProizvodac, lineTip, lineTipSucelja, lineBrojModula, lineCijena);
				
				mPloca.add(matPloca);	
			}
		} 
		catch(IOException e) {
			System.err.println(e);
		}
		return mPloca;
	}
	
	public List<Procesor> ucitajProcesore(){
		List<Procesor> procesor = new ArrayList<>();
		try(BufferedReader citac = new BufferedReader(new FileReader("dat\\procesori.txt"))) {
			String lineProizvodac;
			while((lineProizvodac = citac.readLine()) != null) {		
				
				String lineTip = citac.readLine();
				String sucelje = citac.readLine();		
				BigDecimal lineBrzina = new BigDecimal( citac.readLine()); 		
				BigDecimal lineCijena = new BigDecimal( citac.readLine());
				
				Procesor proc = new Procesor(lineProizvodac, lineTip, lineBrzina, sucelje, lineCijena);
				
				procesor.add(proc);	
			}
		} 
		catch(IOException e) {
			System.err.println(e);
		}
		return procesor;
	}
	
	
	public List<RadnaMemorija> ucitajRadneMemorije(){
		List<RadnaMemorija> radnaMemorija = new ArrayList<>();
		try(BufferedReader citac = new BufferedReader(new FileReader("dat\\radneMemorije.txt"))) {
			String lineProizvodac;
			while((lineProizvodac = citac.readLine()) != null) {		
				
				String lineTip = citac.readLine();		
				Integer lineKapacitet = Integer.parseInt(citac.readLine()); 		
				BigDecimal lineCijena = new BigDecimal( citac.readLine());
				
				RadnaMemorija rMemorija = new RadnaMemorija(lineProizvodac, lineTip, lineKapacitet, lineCijena);
				
				radnaMemorija.add(rMemorija);	
			}
		} 
		catch(IOException e) {
			System.err.println(e);
		}
		return radnaMemorija;
	}
	
	public List<TvrdiDisk> ucitajTvrdiDisk(){
		List<TvrdiDisk> tvrdiDisk = new ArrayList<>();
		try(BufferedReader citac = new BufferedReader(new FileReader("dat\\tvrdiDiskovi.txt"))) {
			String lineProizvodac;
			while((lineProizvodac = citac.readLine()) != null) {		
				
				String lineTip = citac.readLine();		
				BigDecimal lineKapacitet = new BigDecimal(citac.readLine()); 		
				BigDecimal lineCijena = new BigDecimal( citac.readLine());
				
				TvrdiDisk tDisk = new TvrdiDisk(lineProizvodac, lineTip, lineKapacitet, lineCijena);
				
				tvrdiDisk.add(tDisk);	
			}
		} 
		catch(IOException e) {
			System.err.println(e);
		}
		return tvrdiDisk;
	}
}

