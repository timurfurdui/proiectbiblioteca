package com.timur.databasebiblioteca.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.timur.databasebiblioteca.Main;

/**
 * @author Timur
 */
public class FXMLSelecteazaFormularulController implements Initializable {

    Main aRefMain;

    public void setApp(Main aRefMain) {
        this.aRefMain = aRefMain;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void handleButtonActionCatalogElectronic(ActionEvent event) {
        aRefMain.gotoCatalogElectronic();
    }

    @FXML
    private void handleButtonActionInregistrareUtilizator(ActionEvent event) {
        aRefMain.gotoUtilizatoriiBibliotecii();
    }

    @FXML
    private void handleButtonActionParteneri(ActionEvent event) {
        aRefMain.gotoParteneri();
    }

    @FXML
    private void handleButtonActionAngajati(ActionEvent event) {
        aRefMain.gotoAngajati();
    }

    @FXML
    private void handleButtonActionVoluntari(ActionEvent event) {
        aRefMain.gotoVoluntari();
    }

    @FXML
    private void handleButtonActionFinantatoriDonatori(ActionEvent event) {
        aRefMain.gotoFinantatoriDonatori();
    }

    @FXML
    private void handleButtonActionInapoi(ActionEvent event) {
        aRefMain.gotoPaginaLogare();
    }
}
