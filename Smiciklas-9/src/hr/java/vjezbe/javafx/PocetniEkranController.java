package hr.java.vjezbe.javafx;

import hr.java.vjezbe.entitet.*;
import hr.java.vjezbe.baza.podataka.BazaPodataka;


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
			
	ObservableList<Komponenta> ll = FXCollections.observableArrayList();	
	
	public void initialize(URL url, ResourceBundle rb) {
		
		
		try{
		
			ll.addAll(FXCollections.observableArrayList(BazaPodataka.dohvatiMaticnePloce()));
			ll.addAll(FXCollections.observableArrayList(BazaPodataka.dohvatiProcesore()));			
			ll.addAll(FXCollections.observableArrayList(BazaPodataka.dohvatiRadneMemorije()));	
			ll.addAll(FXCollections.observableArrayList(BazaPodataka.dohvatiTvrdeDiskove()));	

		}
		catch(Exception e){
			System.err.println("Greška kod dohvaèanja komponenti");
		}
		
		lijevaLista.setItems(ll);
		
	}
	
	ObservableList<Komponenta> dLista = FXCollections.observableArrayList();
	
	
	@FXML
	private void dodaj(ActionEvent action) {
		
		int elementLijeveListe = lijevaLista.getSelectionModel().getSelectedIndex();
	//	int brojMaticnihPloca = 0, brojProcesora = 0;
		
		dLista.add(ll.get(elementLijeveListe));
		desnaLista.setItems(dLista);
	}
	
	
	@FXML
	private void spremi(ActionEvent action){
			
		System.out.println("Raèunalo je spremljeno ");
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
	public static ObservableList<Racunalo> racunalo;
	
}
