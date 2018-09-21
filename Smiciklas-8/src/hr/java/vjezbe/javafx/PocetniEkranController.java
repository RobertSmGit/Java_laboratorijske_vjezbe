package hr.java.vjezbe.javafx;

import hr.java.vjezbe.entitet.*;
import hr.java.vjezbe.glavna.GlavnaDatoteke;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


public class PocetniEkranController implements Initializable {

	@FXML
	private ListView<Komponenta> lijevaLista;

	@FXML
	private ListView<Komponenta> desnaLista;
	
	ArrayList<Komponenta> listaKomponenti = new ArrayList<>();
	
	public PocetniEkranController() {

		GlavnaDatoteke glavnaDatoteke = new GlavnaDatoteke();
		glavnaDatoteke.ucitajMaticnePloce();
		glavnaDatoteke.ucitajProcesore();
		glavnaDatoteke.ucitajRadneMemorije();
		glavnaDatoteke.ucitajTvrdiDisk();
		
		for(int i = 0; i < glavnaDatoteke.ucitajMaticnePloce().size(); i++)
			listaKomponenti.add(glavnaDatoteke.ucitajMaticnePloce().get(i));
			
		for(int i = 0; i < glavnaDatoteke.ucitajProcesore().size(); i++)
			listaKomponenti.add(glavnaDatoteke.ucitajProcesore().get(i));
		
		for(int i = 0; i < glavnaDatoteke.ucitajRadneMemorije().size(); i++)
			listaKomponenti.add(glavnaDatoteke.ucitajRadneMemorije().get(i));
		
		for(int i = 0; i < glavnaDatoteke.ucitajTvrdiDisk().size(); i++)
			listaKomponenti.add(glavnaDatoteke.ucitajTvrdiDisk().get(i));
	}
	
	ObservableList<Komponenta> lLista = FXCollections.observableArrayList(listaKomponenti); // vraæa ArrayList èije promjene mogu biti prouèavane
	
	
	public void initialize(URL url, ResourceBundle rb) {

		for(Komponenta komponenta : listaKomponenti)
			lLista.add(komponenta);

		lijevaLista.setItems(lLista);
	}
	
	ObservableList<Komponenta> dLista = FXCollections.observableArrayList();
	
	
	@FXML
	private void dodaj(ActionEvent action) {
		
		int elementLijeveListe = lijevaLista.getSelectionModel().getSelectedIndex();
	//	int brojMaticnihPloca = 0, brojProcesora = 0;
		
		dLista.add(lLista.get(elementLijeveListe));
		desnaLista.setItems(dLista);
	}
	
	
	@FXML
	private void spremi(ActionEvent action){
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("dat\\konfiguracija.txt"));
			
			for(int i = 0; i < dLista.size(); i++)
				writer.write(dLista.get(i) + "\r\n"); //  \r\n - novi red u stringu kod windowsa
            writer.close();
		}
		catch(IOException e) {
			System.err.println(e);
		}
	}
	
	
	@FXML
	private void obrisi(ActionEvent action){
		
		int elementDesneListe = desnaLista.getSelectionModel().getSelectedIndex();
		dLista.remove(elementDesneListe);
	}
	
	
	@FXML
	public void prikaziEkranZaNovuMaticnuPlocu() throws IOException { 
		FXMLLoader loader = new FXMLLoader(getClass().getResource("NovaMaticnaPloca.fxml"));
		Scene scene = new Scene((Parent) loader.load());
		Stage stage = new Stage(); 
		stage.setTitle("Unos nove matiène ploèe"); 
		stage.setScene(scene); 
		stage.show(); 
	}
	
	
	@FXML
	public void prikaziEkranZaNoviProcesor() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("NoviProcesor.fxml"));
		Scene scene = new Scene((Parent) loader.load());
		Stage stage = new Stage(); 
		stage.setTitle("Unos novog procesora"); 
		stage.setScene(scene); 
		stage.show(); 
	}
	
	
	@FXML
	public void prikaziEkranZaNovuRadnuMemoriju() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("NovaRadnaMemorija.fxml"));
		Scene scene = new Scene((Parent) loader.load());
		Stage stage = new Stage(); 
		stage.setTitle("Unos nove radne memorije"); 
		stage.setScene(scene); 
		stage.show(); 
	}
	
	
	@FXML
	public void prikaziEkranZaNoviTvrdiDisk() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("NoviTvrdiDisk.fxml"));
		Scene scene = new Scene((Parent) loader.load());
		Stage stage = new Stage(); 
		stage.setTitle("Unos novog tvrdog diska"); 
		stage.setScene(scene); 
		stage.show(); 
	}
	
	public static ObservableList<Komponenta> komponente;
	
}
