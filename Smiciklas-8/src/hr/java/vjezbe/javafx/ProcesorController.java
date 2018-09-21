package hr.java.vjezbe.javafx;

import java.util.*;

import hr.java.vjezbe.datoteke.Datoteke;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ProcesorController {
	
	
	//List<String> maticnePloce = new ArrayList<>();
	String nazivProizvodacaProcesora = "ab";
	String tipProcesora;
	String tipSuceljaZaProcesor;
	String brzinaProcesora;
	String cijenaProcesora;
	
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
		brzinaProcesora = brzina.getText();
		cijenaProcesora = cijena.getText();
		
		
		procesori.addAll(nazivProizvodacaProcesora, tipProcesora, tipSuceljaZaProcesor, brzinaProcesora, cijenaProcesora);
		
		for(int i = 0; i < 5; i++)
		System.out.println(procesori.get(i));
		
		Datoteke datotekaProcesori = new Datoteke();
		datotekaProcesori.spremiProcesor(procesori);
		
	}	
}
