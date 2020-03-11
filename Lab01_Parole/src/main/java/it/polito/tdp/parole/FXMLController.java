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
	
	Parole elenco ;

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
    	double start=System.nanoTime();
    	String str=txtResult.getSelectedText();
    	elenco.rimuoviParola(str);
    	LinkedList<String> parole=new LinkedList<String>(elenco.getElenco());
    	txtResult.clear();
    	for(String s:parole) {
    		txtResult.appendText(s+"\n");
    	}
    	double end=System.nanoTime();
    	double time=end-start;
    	String tempo=Double.toString(time);
    	txtTempi.appendText(tempo+"\n");
    }

    @FXML
    void doInsert(ActionEvent event) {
    	double start=System.nanoTime();
    	String parola=txtParola.getText();
    	elenco.addParola(parola);
    	LinkedList<String> parole=new LinkedList<String>(elenco.getElenco());
    	txtResult.clear();
    	for(String s:parole) {
    		txtResult.appendText(s+"\n");
    	}
    	txtParola.clear();
    	double end=System.nanoTime();
    	double time=end-start;
    	String tempo=Double.toString(time);
    	txtTempi.appendText(tempo+"\n");
    }

    @FXML
    void doReset(ActionEvent event) {
    	double start=System.nanoTime();
    	txtResult.clear();
    	elenco.reset();
    	double end=System.nanoTime();
    	double time=end-start;
    	String tempo=Double.toString(time);
    	txtTempi.appendText(tempo+"\n");
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
