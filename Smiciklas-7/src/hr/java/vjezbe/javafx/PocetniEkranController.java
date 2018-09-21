package hr.java.vjezbe.javafx;


import hr.java.vjezbe.entitet.*;
import hr.java.vjezbe.glavna.GlavnaDatoteke;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;


public class PocetniEkranController implements Initializable {


	MaticnaPloca maticnaPloca1, maticnaPloca2, maticnaPloca3;
	Procesor procesor1, procesor2, procesor3;
	RadnaMemorija radnaMemorija1, radnaMemorija2, radnaMemorija3;
	TvrdiDisk tvrdiDisk1, tvrdiDisk2, tvrdiDisk3;
	
	@FXML
	private ListView<String> lijevaLista;

	@FXML
	private ListView<String> desnaLista;


	public PocetniEkranController() {

		GlavnaDatoteke glavnaDatoteke = new GlavnaDatoteke();
		glavnaDatoteke.ucitajMaticnePloce();
		glavnaDatoteke.ucitajProcesore();
		glavnaDatoteke.ucitajRadneMemorije();
		glavnaDatoteke.ucitajTvrdiDisk();
	
		
		maticnaPloca1 = glavnaDatoteke.ucitajMaticnePloce().get(0);
		maticnaPloca2 = glavnaDatoteke.ucitajMaticnePloce().get(1);
		maticnaPloca3 = glavnaDatoteke.ucitajMaticnePloce().get(2);
		
		procesor1 = glavnaDatoteke.ucitajProcesore().get(0);
		procesor2 = glavnaDatoteke.ucitajProcesore().get(1);
		procesor3 = glavnaDatoteke.ucitajProcesore().get(2);
		
		radnaMemorija1 = glavnaDatoteke.ucitajRadneMemorije().get(0);
		radnaMemorija2 = glavnaDatoteke.ucitajRadneMemorije().get(1);
		radnaMemorija3 = glavnaDatoteke.ucitajRadneMemorije().get(2);
		
		tvrdiDisk1 = glavnaDatoteke.ucitajTvrdiDisk().get(0);
		tvrdiDisk2 = glavnaDatoteke.ucitajTvrdiDisk().get(1);
		tvrdiDisk3 = glavnaDatoteke.ucitajTvrdiDisk().get(2);

	}
	
	ObservableList<String> lLista = FXCollections.observableArrayList();
	
	public void initialize(URL url, ResourceBundle rb) {
		
		lLista = FXCollections.observableArrayList(maticnaPloca1.toString(), maticnaPloca2.toString(), maticnaPloca3.toString(),
				procesor1.toString(), procesor2.toString(), procesor3.toString(),
				radnaMemorija1.toString(), radnaMemorija2.toString(), radnaMemorija3.toString(),
				tvrdiDisk1.toString(), tvrdiDisk2.toString(), tvrdiDisk3.toString());
		lijevaLista.setItems(lLista);
	}
	
	ObservableList<String> dLista = FXCollections.observableArrayList();
	

	@FXML
	private void dodaj(ActionEvent action) {
		
		int elementLijeveListe = lijevaLista.getSelectionModel().getSelectedIndex();
		int brojMaticnihPloca = 0, brojProcesora = 0;
		
		dLista.add(lLista.get(elementLijeveListe));
		desnaLista.setItems(dLista);
		
		if(lLista.get(elementLijeveListe).equals(maticnaPloca1.toString()) || lLista.get(elementLijeveListe).equals(maticnaPloca2.toString()) || lLista.get(elementLijeveListe).equals(maticnaPloca3.toString()) ){
			brojMaticnihPloca ++;
		}
		
		if(lLista.get(elementLijeveListe).equals(procesor1.toString()) || lLista.get(elementLijeveListe).equals(procesor2.toString()) || lLista.get(elementLijeveListe).equals(procesor3.toString()) ){
			brojProcesora ++;
		}
	}
	
	@FXML
	private void spremi(ActionEvent action){
		
		try{
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
		
}
