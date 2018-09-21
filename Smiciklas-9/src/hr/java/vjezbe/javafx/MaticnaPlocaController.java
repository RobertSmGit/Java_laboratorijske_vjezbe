package hr.java.vjezbe.javafx;

import java.math.BigDecimal;
import java.util.*;

import hr.java.vjezbe.baza.podataka.BazaPodataka;
import hr.java.vjezbe.entitet.*;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class MaticnaPlocaController {

	String nazivProizvodacaPloce;
	String tipPloce;
	String tipSuceljaZaProcesorPloce;
	public int brojMemorijskihModulaPloce;
	int id = 0;
	BigDecimal cijenaPloce;
		
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
		brojMemorijskihModulaPloce = brojModula.getValue();
		cijenaPloce = new BigDecimal(cijena.getText());
		
		
		MaticnaPloca mp = new MaticnaPloca(nazivProizvodacaPloce, tipPloce, tipSuceljaZaProcesorPloce, brojMemorijskihModulaPloce, cijenaPloce);
		
		try{
			BazaPodataka.spremiMaticnuPlocu(mp);
		}
		catch(Exception e){
			
		}
		
		System.out.print("Matièna ploèa spremljena");
		
	}	
}
