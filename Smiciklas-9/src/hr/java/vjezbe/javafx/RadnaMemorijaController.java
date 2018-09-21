package hr.java.vjezbe.javafx;

import java.math.BigDecimal;
import java.util.Arrays;

import hr.java.vjezbe.baza.podataka.BazaPodataka;
import hr.java.vjezbe.entitet.RadnaMemorija;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RadnaMemorijaController {


	String nazivProizvodacaRadneMemorije;
	String tipRadneMemorije;
	int kapacitetRadneMemorije;
	BigDecimal cijenaRadneMemorije;
	
	public ObservableList<String> radneMemorije = FXCollections.observableArrayList();
	
	@FXML
	TextField proizvodac = new TextField();
	
	@FXML
	TextField tip = new TextField();
	
	@FXML 
	ComboBox<Integer> kapacitet;
	
	@FXML
	TextField cijena = new TextField();
	
	
	@FXML public void initialize() { 
		kapacitet.getItems().addAll(Arrays.asList(2, 4, 8));
	}
	
	
	public void spremiRadnuMemoriju(){
		
		nazivProizvodacaRadneMemorije = proizvodac.getText();
		tipRadneMemorije = tip.getText();
		kapacitetRadneMemorije = kapacitet.getValue();
		cijenaRadneMemorije = new BigDecimal(cijena.getText());
		
		
		RadnaMemorija rm = new RadnaMemorija(nazivProizvodacaRadneMemorije, tipRadneMemorije, kapacitetRadneMemorije, cijenaRadneMemorije);
		
		try{
			BazaPodataka.spremiRadnuMemoriju(rm);
		}
		catch(Exception e){
			
		}
		
		System.out.print("Radna memorija spremljena");
		
	}	
	
	
}
