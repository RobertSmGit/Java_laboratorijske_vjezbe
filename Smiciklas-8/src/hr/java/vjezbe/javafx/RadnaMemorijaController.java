package hr.java.vjezbe.javafx;

import java.util.Arrays;

import hr.java.vjezbe.datoteke.Datoteke;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RadnaMemorijaController {


	String nazivProizvodacaRadneMemorije;
	String tipRadneMemorije;
	String kapacitetRadneMemorije;
	String cijenaRadneMemorije;
	
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
		kapacitetRadneMemorije = kapacitet.getValue().toString();
		cijenaRadneMemorije = cijena.getText();
	
		
		radneMemorije.addAll(nazivProizvodacaRadneMemorije, tipRadneMemorije, kapacitetRadneMemorije, cijenaRadneMemorije);
		
		for(int i = 0; i < 4; i++)
		System.out.println(radneMemorije.get(i));
		
		Datoteke datotekaRadneMemorije = new Datoteke();
		datotekaRadneMemorije.spremiRadnuMemoriju(radneMemorije);
		
	}	
	
}
