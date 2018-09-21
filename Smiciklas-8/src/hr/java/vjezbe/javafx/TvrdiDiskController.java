package hr.java.vjezbe.javafx;

import java.util.Arrays;

import hr.java.vjezbe.datoteke.Datoteke;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class TvrdiDiskController {

	String nazivProizvodacaTvrdogDiska;
	String tipTvrdogDiska;
	String kapacitetTvrdogDiska;
	String cijenaTvrdogDiska;
	
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
		kapacitetTvrdogDiska = kapacitet.getValue().toString();
		cijenaTvrdogDiska = cijena.getText();
	
		tvrdiDiskovi.addAll(nazivProizvodacaTvrdogDiska, tipTvrdogDiska, kapacitetTvrdogDiska, cijenaTvrdogDiska);
		
		for(int i = 0; i < 4; i++)
		System.out.println(tvrdiDiskovi.get(i));
		
		Datoteke datotekaTvrdiDiskovi = new Datoteke();
		datotekaTvrdiDiskovi.spremiTvrdidisk(tvrdiDiskovi);
	}
}
