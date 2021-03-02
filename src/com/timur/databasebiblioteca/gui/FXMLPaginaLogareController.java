package com.timur.databasebiblioteca.gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.timur.databasebiblioteca.Main;

/**
 * @author User
 */
public class FXMLPaginaLogareController implements Initializable {

    @FXML
    private TextField tfUtilizator;
    @FXML
    private PasswordField tfParola;
    @FXML
    private Label errorMesageLabel;

    Main aRefMain;

    public void setApp(Main aRefMain) {
        this.aRefMain = aRefMain;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void handleButtonActionInregistrare(ActionEvent event) {
        aRefMain.gotoPaginaInregistrare();
    }

    @FXML
    private void handleButtonActionReset(ActionEvent event) {
        tfUtilizator.setText("");
        tfParola.setText("");
    }

    public void processLogin(ActionEvent event) {
        if (aRefMain == null) {
            // We are running in isolated FXML, possibly in Scene Builder.
            // NO-OP.
            errorMesageLabel.setText("Hello " + tfUtilizator.getText());
        } else {
            if (!aRefMain.userLogging(tfUtilizator.getText(), tfParola.getText())) {
                errorMesageLabel.setText("Username/Password is incorrect");
            }
        }
        if(tfUtilizator.getText().isEmpty() && tfParola.getText().isEmpty()) {
            errorMesageLabel.setText("Nu ai introdus loginul sau parola");
        }
    }

    @FXML
    private void handleButtonActionLogare(ActionEvent event) {
        processLogin(event);
        aRefMain.gotoSelecteazaFormularul();
    }
}
