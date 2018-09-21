package hr.java.vjezbe.javafx;

import java.math.BigDecimal;

import hr.java.vjezbe.baza.podataka.BazaPodataka;

import hr.java.vjezbe.entitet.Procesor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ProcesorController {
	
	
	String nazivProizvodacaProcesora;
	String tipProcesora;
	String tipSuceljaZaProcesor;
	BigDecimal brzinaProcesora;
	BigDecimal cijenaProcesora;
	
	public ObservableList<String> procesori = FXCollections.observableArrayList();
	
	@FXML
	TextField proizvodac = new TextField();
	
	@FXML
	TextField tip = new TextField();
	
	@FXML
	TextField tipSucelja = new TextField();
	
	@FXML
	TextField brzina = new TextField();
	
	@FXML
	TextField cijena = new TextField();
	
	
	public void spremiProcesor(){
		
		nazivProizvodacaProcesora = proizvodac.getText();
		tipProcesora = tip.getText();
		tipSuceljaZaProcesor = tipSucelja.getText();
		brzinaProcesora = new BigDecimal(brzina.getText());
		cijenaProcesora =  new BigDecimal(cijena.getText());
		
		
		Procesor p = new Procesor(nazivProizvodacaProcesora, tipProcesora,brzinaProcesora, tipSuceljaZaProcesor, cijenaProcesora);
		
		try{
			BazaPodataka.spremiProcesor(p);
		}
		catch(Exception e){
			
		}

		System.out.print("Procesor spremljen");
		
	}	
	
}
