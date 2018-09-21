package hr.java.vjezbe.baza.podataka;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hr.java.vjezbe.entitet.MaticnaPloca;
import hr.java.vjezbe.entitet.Procesor;
import hr.java.vjezbe.entitet.RadnaMemorija;
import hr.java.vjezbe.entitet.TvrdiDisk;


public class BazaPodataka {
		
	private static Connection spajanjeNaBazuPodataka(){
			
		Connection veza = null;
		
		try{
			veza= DriverManager.getConnection("jdbc:h2:tcp://localhost/~/JavaFX-2015","student","student");
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.err.println("Pogreška kod spajanja na bazu");
		}
		return veza;
	}
	
	
	private static void zatvaranjeVezeNaBazuPodataka(Connection veza) {
			
		try{
			veza.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.err.println("Pogreška kod odspajanja od baze");
		}
		
	}
	
	public static void spremiMaticnuPlocu(MaticnaPloca maticnaPloca) throws Exception {
		
		Connection veza = spajanjeNaBazuPodataka();  
		veza.setAutoCommit(false); 
		
		try {
			if (veza.isClosed())
			    System.out.println("konekcija je zatvorena");
			else
				 System.out.println("konekcija je otvorena");
		
			PreparedStatement insertMaticnaKomponenta = veza.prepareStatement("INSERT INTO RACUNALA.KOMPONENTA (ID, NAZIV_PROIZVODJACA, CIJENA) VALUES (?, ?, ?)"); 
			
			insertMaticnaKomponenta.setInt(1, 1);
			insertMaticnaKomponenta.setString(2, maticnaPloca.getNazivProizvodaca());
			insertMaticnaKomponenta.setBigDecimal(3, maticnaPloca.getCijena());
			insertMaticnaKomponenta.executeUpdate();
			
			ResultSet generatedKeys = insertMaticnaKomponenta.getGeneratedKeys();// Send an array of column indexes to execute or executeUpdate. This array is an index of columns for the target table.
			
			if (generatedKeys.next()) {
				maticnaPloca.setId(generatedKeys.getInt(1));
			}
		
			PreparedStatement insertMaticnaPloca = veza.prepareStatement("INSERT INTO RACUNALA.MATICNA_PLOCA (ID, TIP, TIP_SUCELJA_ZA_PROCESOR, MAX_MEMORIJSKIH_MODULA) VALUES (?, ?, ?, ?)");
			insertMaticnaPloca.setInt(1, 1);
			insertMaticnaPloca.setString(2, maticnaPloca.getTip());
			insertMaticnaPloca.setString(3, maticnaPloca.getTipSuceljaZaProcesor()); 
			insertMaticnaPloca.setInt(4, maticnaPloca.getMaksimalanBrojMemorijskihModula());
			insertMaticnaPloca.executeUpdate();
			veza.commit(); 
		}
		catch(Throwable ex) {
			veza.rollback(); 
			throw ex; 
		}
		
		zatvaranjeVezeNaBazuPodataka(veza);
	}
	
	

	
	public static List<MaticnaPloca> dohvatiMaticnePloce() throws Exception {
		Connection veza = spajanjeNaBazuPodataka();
		Statement statementKomponenta = veza.createStatement();
		ResultSet resultSetKomponenta = statementKomponenta.executeQuery("SELECT * FROM RACUNALA.KOMPONENTA");
		PreparedStatement statementMaticnaPloca = veza.prepareStatement("SELECT * FROM RACUNALA.MATICNA_PLOCA WHERE ID = ?");
		List<MaticnaPloca> listaMaticnihPloca = new ArrayList<>(); 
		while(resultSetKomponenta.next()) {
			Integer id = resultSetKomponenta.getInt("ID"); 
			String nazivProizvodjaca = resultSetKomponenta.getString("NAZIV_PROIZVODJACA");
			BigDecimal cijena = resultSetKomponenta.getBigDecimal("CIJENA"); 
			statementMaticnaPloca.setInt(1, id);
			ResultSet resultSetMaticnaPloca = statementMaticnaPloca.executeQuery(); 
			while(resultSetMaticnaPloca.next()) {
				String tip = resultSetMaticnaPloca.getString("TIP");
				String tipSucelja = resultSetMaticnaPloca.getString("TIP_SUCELJA_ZA_PROCESOR");
				Integer maxModula = resultSetMaticnaPloca.getInt("MAX_MEMORIJSKIH_MODULA");
				MaticnaPloca maticnaPloca = new MaticnaPloca(nazivProizvodjaca, tip, tipSucelja, maxModula, cijena);
				maticnaPloca.setId(id); 
				listaMaticnihPloca.add(maticnaPloca);
			}
		}
		zatvaranjeVezeNaBazuPodataka(veza); 
		return listaMaticnihPloca; 
	}
	
	
	public static void spremiProcesor(Procesor procesor) throws Exception {
		
		Connection veza = spajanjeNaBazuPodataka();  
		veza.setAutoCommit(false); 
		
		try {
			if (veza.isClosed())
			    System.out.println("konekcija je zatvorena");
			else
				 System.out.println("konekcija je otvorena");
		
			PreparedStatement insertProcesorKomponenta = veza.prepareStatement("INSERT INTO RACUNALA.KOMPONENTA (ID, NAZIV_PROIZVODJACA, CIJENA) VALUES (?, ?, ?)"); 
			
			insertProcesorKomponenta.setInt(1, 2);
			insertProcesorKomponenta.setString(2, procesor.getNazivProizvodaca());
			insertProcesorKomponenta.setBigDecimal(3, procesor.getCijena());
			insertProcesorKomponenta.executeUpdate();
			
			ResultSet generatedKeys = insertProcesorKomponenta.getGeneratedKeys();// Send an array of column indexes to execute or executeUpdate. This array is an index of columns for the target table.
			
			if (generatedKeys.next()) {
				procesor.setId(generatedKeys.getInt(1));
			}
		
			PreparedStatement insertProcesor = veza.prepareStatement("INSERT INTO RACUNALA.PROCESOR (ID, TIP, TIP_SUCELJA, BRZINA) VALUES (?, ?, ?, ?)");
			insertProcesor.setInt(1, 2);
			insertProcesor.setString(2, procesor.getTip());
			insertProcesor.setString(3, procesor.getSucelje()); 
			insertProcesor.setBigDecimal(4, procesor.getBrzina());
			insertProcesor.executeUpdate();
			veza.commit(); 
		}
		catch(Throwable ex) {
			veza.rollback(); 
			throw ex; 
		}
		
		zatvaranjeVezeNaBazuPodataka(veza);
	}
	
	

	
	public static List<Procesor> dohvatiProcesore() throws Exception {
		Connection veza = spajanjeNaBazuPodataka();
		Statement statementKomponenta = veza.createStatement();
		ResultSet resultSetKomponenta = statementKomponenta.executeQuery("SELECT * FROM RACUNALA.KOMPONENTA");
		PreparedStatement statementProcesor = veza.prepareStatement("SELECT * FROM RACUNALA.PROCESOR WHERE ID = ?");
		List<Procesor> listaProcesora = new ArrayList<>(); 
		while(resultSetKomponenta.next()) {
			Integer id = resultSetKomponenta.getInt("ID"); 
			String nazivProizvodjaca = resultSetKomponenta.getString("NAZIV_PROIZVODJACA");
			BigDecimal cijena = resultSetKomponenta.getBigDecimal("CIJENA"); 
			statementProcesor.setInt(1, id);
			ResultSet resultSetProcesor = statementProcesor.executeQuery(); 
			while(resultSetProcesor.next()) {
				String tip = resultSetProcesor.getString("TIP");
				String tipSucelja = resultSetProcesor.getString("TIP_SUCELJA");
				BigDecimal brzina = resultSetProcesor.getBigDecimal("BRZINA");
				Procesor procesor = new Procesor(nazivProizvodjaca, tip, brzina, tipSucelja, cijena);
				procesor.setId(id); 
				listaProcesora.add(procesor);
			}
		}
		zatvaranjeVezeNaBazuPodataka(veza); 
		return listaProcesora; 
	}
	
	
	
	
	public static void spremiRadnuMemoriju(RadnaMemorija radnaMemorija) throws Exception {
		
		Connection veza = spajanjeNaBazuPodataka();  
		veza.setAutoCommit(false); 
		
		try {
			if (veza.isClosed())
			    System.out.println("konekcija je zatvorena");
			else
				 System.out.println("konekcija je otvorena");
		
			PreparedStatement insertRadnaMemorijaKomponenta = veza.prepareStatement("INSERT INTO RACUNALA.KOMPONENTA (ID, NAZIV_PROIZVODJACA, CIJENA) VALUES (?, ?, ?)"); 
			
			insertRadnaMemorijaKomponenta.setInt(1, 3);
			insertRadnaMemorijaKomponenta.setString(2, radnaMemorija.getNazivProizvodaca());
			insertRadnaMemorijaKomponenta.setBigDecimal(3, radnaMemorija.getCijena());
			insertRadnaMemorijaKomponenta.executeUpdate();
			
			ResultSet generatedKeys = insertRadnaMemorijaKomponenta.getGeneratedKeys();// Send an array of column indexes to execute or executeUpdate. This array is an index of columns for the target table.
			
			if (generatedKeys.next()) {
				radnaMemorija.setId(generatedKeys.getInt(1));
			}
		
			PreparedStatement insertRadnaMemorija = veza.prepareStatement("INSERT INTO RACUNALA.RADNA_MEMORIJA (ID, TIP, KAPACITET) VALUES (?, ?, ?)");
			insertRadnaMemorija	.setInt(1, 3);
			insertRadnaMemorija.setString(2, radnaMemorija.getTip());
			insertRadnaMemorija.setInt(3, radnaMemorija.getKapacitet()); 
			insertRadnaMemorija.executeUpdate();
			veza.commit(); 
		}
		catch(Throwable ex) {
			veza.rollback(); 
			throw ex; 
		}
		
		zatvaranjeVezeNaBazuPodataka(veza);
	}
	
	

	
	public static List<RadnaMemorija> dohvatiRadneMemorije() throws Exception {
		Connection veza = spajanjeNaBazuPodataka();
		Statement statementKomponenta = veza.createStatement();
		ResultSet resultSetKomponenta = statementKomponenta.executeQuery("SELECT * FROM RACUNALA.KOMPONENTA");
		PreparedStatement statementRadnaMemorija = veza.prepareStatement("SELECT * FROM RACUNALA.RADNA_MEMORIJA WHERE ID = ?");
		List<RadnaMemorija> listaRadnihMemorija = new ArrayList<>(); 
		while(resultSetKomponenta.next()) {
			Integer id = resultSetKomponenta.getInt("ID"); 
			String nazivProizvodjaca = resultSetKomponenta.getString("NAZIV_PROIZVODJACA");
			BigDecimal cijena = resultSetKomponenta.getBigDecimal("CIJENA"); 
			statementRadnaMemorija.setInt(1, id);
			ResultSet resultSetRadnaMemorija = statementRadnaMemorija.executeQuery(); 
			while(resultSetRadnaMemorija.next()) {
				String tip = resultSetRadnaMemorija.getString("TIP");
				Integer kapacitet = resultSetRadnaMemorija.getInt("KAPACITET");
				RadnaMemorija radnaMemorija = new RadnaMemorija(nazivProizvodjaca, tip, kapacitet, cijena);
				radnaMemorija.setId(id); 
				listaRadnihMemorija.add(radnaMemorija);
			}
		}
		zatvaranjeVezeNaBazuPodataka(veza); 
		return listaRadnihMemorija; 
	}
	

	
	public static void spremiTvrdiDisk(TvrdiDisk tvrdiDisk) throws Exception {
		
		Connection veza = spajanjeNaBazuPodataka();  
		veza.setAutoCommit(false); 
		
		try {
			if (veza.isClosed())
			    System.out.println("konekcija je zatvorena");
			else
				 System.out.println("konekcija je otvorena");
		
			PreparedStatement insertTvrdiDiskKomponenta = veza.prepareStatement("INSERT INTO RACUNALA.KOMPONENTA (ID, NAZIV_PROIZVODJACA, CIJENA) VALUES (?, ?, ?)"); 
			
			insertTvrdiDiskKomponenta.setInt(1, 4);
			insertTvrdiDiskKomponenta.setString(2, tvrdiDisk.getNazivProizvodaca());
			insertTvrdiDiskKomponenta.setBigDecimal(3, tvrdiDisk.getCijena());
			insertTvrdiDiskKomponenta.executeUpdate();
			
			ResultSet generatedKeys = insertTvrdiDiskKomponenta.getGeneratedKeys();// Send an array of column indexes to execute or executeUpdate. This array is an index of columns for the target table.
			
			if (generatedKeys.next()) {
				tvrdiDisk.setId(generatedKeys.getInt(1));
			}
		
			PreparedStatement insertTvrdiDisk = veza.prepareStatement("INSERT INTO RACUNALA.TVRDI_DISK (ID, TIP, KAPACITET) VALUES (?, ?, ?)");
			insertTvrdiDisk	.setInt(1, 4);
			insertTvrdiDisk.setString(2, tvrdiDisk.getTip());
			insertTvrdiDisk.setBigDecimal(3, tvrdiDisk.getKapacitet()); 
			insertTvrdiDisk.executeUpdate();
			veza.commit(); 
		}
		catch(Throwable ex) {
			veza.rollback(); 
			throw ex; 
		}
		
		zatvaranjeVezeNaBazuPodataka(veza);
	}
	
	
	public static List<TvrdiDisk> dohvatiTvrdeDiskove() throws Exception {
		Connection veza = spajanjeNaBazuPodataka();
		Statement statementKomponenta = veza.createStatement();
		ResultSet resultSetKomponenta = statementKomponenta.executeQuery("SELECT * FROM RACUNALA.KOMPONENTA");
		PreparedStatement statementTvrdiDisk = veza.prepareStatement("SELECT * FROM RACUNALA.TVRDI_DISK WHERE ID = ?");
		List<TvrdiDisk> listaTvrdihDiskova = new ArrayList<>(); 
		while(resultSetKomponenta.next()) {
			Integer id = resultSetKomponenta.getInt("ID"); 
			String nazivProizvodjaca = resultSetKomponenta.getString("NAZIV_PROIZVODJACA");
			BigDecimal cijena = resultSetKomponenta.getBigDecimal("CIJENA"); 
			statementTvrdiDisk.setInt(1, id);
			ResultSet resultSetTvrdiDisk = statementTvrdiDisk.executeQuery(); 
			while(resultSetTvrdiDisk.next()) {
				String tip = resultSetTvrdiDisk.getString("TIP");
				BigDecimal kapacitet = resultSetTvrdiDisk.getBigDecimal("KAPACITET");
				TvrdiDisk tvrdiDisk = new TvrdiDisk(nazivProizvodjaca, tip, kapacitet, cijena);
				tvrdiDisk.setId(id); 
				listaTvrdihDiskova.add(tvrdiDisk);
			}
		}
		zatvaranjeVezeNaBazuPodataka(veza); 
		return listaTvrdihDiskova; 
	}

}
