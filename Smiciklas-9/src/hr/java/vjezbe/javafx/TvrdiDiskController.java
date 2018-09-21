package hr.java.vjezbe.javafx;

import java.math.BigDecimal;
import java.util.Arrays;

import hr.java.vjezbe.baza.podataka.BazaPodataka;
import hr.java.vjezbe.entitet.TvrdiDisk;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class TvrdiDiskController {

	String nazivProizvodacaTvrdogDiska;
	String tipTvrdogDiska;
	BigDecimal kapacitetTvrdogDiska;
	BigDecimal cijenaTvrdogDiska;
	
	public ObservableList<String> tvrdiDiskovi = FXCollections.observableArrayList();
	
	@FXML
	TextField proizvodac = new TextField();
	
	@FXML
	TextField tip = new TextField();
	
	@FXML
	ComboBox<Integer> kapacitet;
	
	@FXML
	TextField cijena = new TextField();
	
	
	@FXML public void initialize() {
		kapacitet.getItems().addAll(Arrays.asList(1, 2, 4, 8));
	}
	
	
	public void spremiTvrdiDisk(){
		
		nazivProizvodacaTvrdogDiska = proizvodac.getText();
		tipTvrdogDiska = tip.getText();
		kapacitetTvrdogDiska = new BigDecimal(kapacitet.getValue());
		cijenaTvrdogDiska = new BigDecimal(cijena.getText());
		
		
		TvrdiDisk td = new TvrdiDisk(nazivProizvodacaTvrdogDiska, tipTvrdogDiska, kapacitetTvrdogDiska, cijenaTvrdogDiska);
		
		try{
			BazaPodataka.spremiTvrdiDisk(td);
		}
		catch(Exception e){
			
		}
		
		System.out.print("Tvrdi disk spremljen");
		
	}	
	
	
}
