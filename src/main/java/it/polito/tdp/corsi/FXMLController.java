package it.polito.tdp.corsi;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.Model;
import it.polito.tdp.corsi.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtPeriodo;

    @FXML
    private TextField txtCorso;

    @FXML
    private Button btnCorsiPerPeriodo;

    @FXML
    private Button btnNumeroStudenti;

    @FXML
    private Button btnStudenti;

    @FXML
    private Button btnDivisioneStudenti;

    @FXML
    private TextArea txtResult;

    @FXML
    void corsiPerPeriodo(ActionEvent event) {
    	txtResult.clear();
    	String pdString =txtPeriodo.getText();
    	Integer pd;
    	try {
    		 pd=Integer.parseInt(pdString);
    	}catch(NumberFormatException e) {
    		txtResult.setText("Inserisci periodo didattico 1 o 2");
    		return;
    	}
    	if(!pd.equals(1) && !pd.equals(2)) {
    		txtResult.setText("Inserisci periodo didattico 1 o 2");
    		return;
    	}
    	
    	List<Corso>corsi=this.model.getCorsiByPeriodo(pd);
    	for(Corso c: corsi) {
    		txtResult.appendText(c.toString()+"\n");
    	}
    	
    }

    @FXML
    void stampaDivisione(ActionEvent event) {
    	txtResult.clear();
    	
    	String codins = txtCorso.getText();
    	
    	//controllo se il codice corrisponde a un corso esistente
    	if(!this.model.esisteCorso(codins)) {
    		txtResult.appendText("Il corso non esiste!\n");
    		return ;
    	}
    	
    	//OUTPUT dato un corso, ci aspettiamo una divisione del genere 
    	// Informatica 12
    	// Gestionali 28
    	
    	Map<String, Integer> statistiche = this.model.getDivisioneCDS(new Corso(codins, null, null, null));
    	
    	for(String cds : statistiche.keySet()) {
    		txtResult.appendText(cds + " " + statistiche.get(cds) + "\n");
    	}
    	

    }

    @FXML
    void stampaNumeroStudenti(ActionEvent event) {
    	txtResult.clear();
    	String pdString =txtPeriodo.getText();
    	Integer pd;
    	try {
    		 pd=Integer.parseInt(pdString);
    	}catch(NumberFormatException e) {
    		txtResult.setText("Inserisci periodo didattico 1 o 2");
    		return;
    	}
    	if(!pd.equals(1) && !pd.equals(2)) {
    		txtResult.setText("Inserisci periodo didattico 1 o 2");
    		return;
    	}
    	
    	Map<Corso,Integer>statistiche=this.model.getIscrittiByPeriodoInteger(pd);
    	for(Corso c: statistiche.keySet()) {
    		txtResult.appendText(c.getNome()+" "+ statistiche.get(c)+"\n");
    	}
    }

    @FXML
    void stampaStudenti(ActionEvent event) {
    	txtResult.clear();
    	
    	String codins = txtCorso.getText();
    	
    	//controllo se il codice corrisponde a un corso esistente
    	if(!this.model.esisteCorso(codins)) {
    		txtResult.appendText("Il corso non esiste!\n");
    		return ;
    	}
    	
    	
    	List<Studente> studenti = this.model.getStudentiByCorso(new Corso(codins, null,null,null));
    	
    	if(studenti.size() == 0) {
    		txtResult.appendText("Il corso non ha studenti iscritti");
    		return;
    	} 
    	
    	for(Studente s : studenti) {
    		txtResult.appendText(s.toString() + "\n");
    	}
    	
    }

    @FXML
    void initialize() {
        assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCorsiPerPeriodo != null : "fx:id=\"btnCorsiPerPeriodo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnNumeroStudenti != null : "fx:id=\"btnNumeroStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnStudenti != null : "fx:id=\"btnStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnDivisioneStudenti != null : "fx:id=\"btnDivisioneStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
  	  this.model=model;
    }

}

  