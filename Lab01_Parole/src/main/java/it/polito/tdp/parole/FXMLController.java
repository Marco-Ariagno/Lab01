package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.*;

public class FXMLController {

	Parole elenco;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtParola;

	@FXML
	private Button btnInserisci;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnReset;

	@FXML
	private Button btnCancella;

	@FXML
	private TextArea txtTempi;

	@FXML
	void doCancella(ActionEvent event) {
		String str = txtResult.getSelectedText();
		double start = System.nanoTime();
		elenco.rimuoviParola(str);
		double end = System.nanoTime();
		LinkedList<String> parole = new LinkedList<String>(elenco.getElenco());
		txtResult.clear();
		for (String s : parole) {
			txtResult.appendText(s + "\n");
		}
		double time = end - start;
		String tempo = Double.toString(time);
		txtTempi.clear();
		txtTempi.appendText(tempo + "\n");
		
	}

	@FXML
	void doInsert(ActionEvent event) {
		String parola = txtParola.getText();
		double start = System.nanoTime();
		elenco.addParola(parola);
		double end = System.nanoTime();
		LinkedList<String> parole = new LinkedList<String>(elenco.getElenco());
		txtResult.clear();
		for (String s : parole) {
			txtResult.appendText(s + "\n");
		}
		txtParola.clear();
		double time = end - start;
		String tempo = Double.toString(time);
		txtTempi.appendText(tempo + "\n");
	}

	@FXML
	void doReset(ActionEvent event) {
		txtResult.clear();
		elenco.reset();
		txtTempi.clear();
	}

	@FXML
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

		elenco = new Parole();
	}
}
