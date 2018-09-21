package hr.java.vjezbe.javafx;

import java.util.*;

import hr.java.vjezbe.datoteke.Datoteke;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class MaticnaPlocaController {

	String nazivProizvodacaPloce;
	String tipPloce;
	String tipSuceljaZaProcesorPloce;
	String brojMemorijskihModulaPloce;
	String cijenaPloce;
	
	public ObservableList<String> maticnePloce = FXCollections.observableArrayList();
	
	@FXML
	TextField proizvodac = new TextField();
	
	@FXML
	TextField tip = new TextField();
	
	@FXML
	TextField tipSucelja = new TextField();
	
	@FXML 
	ComboBox<Integer> brojModula;
	
	@FXML
	TextField cijena = new TextField();
	

	
	@FXML public void initialize() { 
		brojModula.getItems().addAll(Arrays.asList(2, 3, 4));
	}
	
	public void spremiMaticnuPlocu(){
		nazivProizvodacaPloce = proizvodac.getText();
		tipPloce = tip.getText();
		tipSuceljaZaProcesorPloce = tipSucelja.getText();
		brojMemorijskihModulaPloce = brojModula.getValue().toString();
		cijenaPloce = cijena.getText();

		maticnePloce.addAll(nazivProizvodacaPloce, tipPloce, tipSuceljaZaProcesorPloce, brojMemorijskihModulaPloce, cijenaPloce);
		
		for(int i = 0; i < 5; i++)
		System.out.println(maticnePloce.get(i));
		
		Datoteke datotekaMaticnePloce = new Datoteke();
		datotekaMaticnePloce.spremiMaticnuPlocu(maticnePloce);
		
	}	
}
