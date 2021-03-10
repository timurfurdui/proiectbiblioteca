package com.timur.databasebiblioteca.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.timur.databasebiblioteca.Main;

/**
 * @author Timur
 */
public class FXMLPaginaInregistrareController implements Initializable {

    Main aRefMain;
    @FXML
    private TextField tfUtilizator;
    @FXML
    private TextField tfConfirmaParola;
    @FXML
    private TextField tfSeteazaParola;
    @FXML
    private Button btnInregistrare;

    public void setApp(Main aRefMain) {
        this.aRefMain = aRefMain;
    }

    private String utilizator;
    private String parola;
    private String confirmParola;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void handleButtonActionInapoi(ActionEvent event) {
        aRefMain.gotoPaginaLogare();
    }

    @FXML
    private void handleButtonActionInregistrare(ActionEvent event) {
        utilizator = tfUtilizator.getText();
        parola = tfSeteazaParola.getText();
        confirmParola = tfConfirmaParola.getText();
    }

    public String getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(String utilizator) {
        this.utilizator = utilizator;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getConfirmParola() {
        return confirmParola;
    }

    public void setConfirmParola(String confirmParola) {
        this.confirmParola = confirmParola;
    }
}
