package com.timur.databasebiblioteca;

import com.timur.databasebiblioteca.gui.FXMLAngajatiController;
import com.timur.databasebiblioteca.gui.FXMLCatalogElectronicController;
import com.timur.databasebiblioteca.gui.FXMLFinantatoriDonatoriController;
import com.timur.databasebiblioteca.gui.FXMLPaginaInregistrareController;
import com.timur.databasebiblioteca.gui.FXMLPaginaLogareController;
import com.timur.databasebiblioteca.gui.FXMLParteneriController;
import com.timur.databasebiblioteca.gui.FXMLSelecteazaFormularulController;
import com.timur.databasebiblioteca.gui.FXMLUtilizatoriiBiblioteciiController;
import com.timur.databasebiblioteca.gui.FXMLVoluntariController;
import java.io.InputStream;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import com.timur.databasebiblioteca.security.Authenticator;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.timur.databasebiblioteca.model.User;

/**
 * @author Timur
 */
public class Main extends Application {
    private Stage stage;
    private User loggedUser;
    private final double MINIMUM_WINDOW_WIDTH = 800.0;
    private final double MINIMUM_WINDOW_HEIGHT = 645.0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(Main.class, (java.lang.String[]) null);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            stage = primaryStage;
            primaryStage.setTitle("App Biblioteca");
            primaryStage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            primaryStage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
            gotoPaginaLogare();
            primaryStage.show();
            } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public boolean userLogging(String userName, String password) {
        if (Authenticator.validate(userName, password)) {
            loggedUser = User.of(userName);
            gotoSelecteazaFormularul();
            return true;
        } else {
            return false;
        }
    }

    private Initializable replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
            System.out.println(page);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, 800, 645);
        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }

    public void gotoPaginaLogare() {
        try {
            FXMLPaginaLogareController selectWindow = (FXMLPaginaLogareController) replaceSceneContent("gui/FXMLPaginaLogare.fxml");
            selectWindow.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoPaginaInregistrare() {
        try {
            FXMLPaginaInregistrareController selectWindow = (FXMLPaginaInregistrareController) replaceSceneContent("gui/FXMLPaginaInregistrare.fxml");
            selectWindow.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoCatalogElectronic() {
        try {
            FXMLCatalogElectronicController selectWindow = (FXMLCatalogElectronicController) replaceSceneContent("gui/FXMLCatalogElectronic.fxml");
            selectWindow.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoUtilizatoriiBibliotecii() {
        try {
            FXMLUtilizatoriiBiblioteciiController selectWindow = (FXMLUtilizatoriiBiblioteciiController) replaceSceneContent("gui/FXMLUtilizatoriiBibliotecii.fxml");
            selectWindow.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoSelecteazaFormularul() {
        try {
            FXMLSelecteazaFormularulController selectWindow = (FXMLSelecteazaFormularulController) replaceSceneContent("gui/FXMLSelecteazaFormularul.fxml");
            selectWindow.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoAngajati() {
        try {
            FXMLAngajatiController selectWindow = (FXMLAngajatiController) replaceSceneContent("gui/FXMLAngajati.fxml");
            selectWindow.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoFinantatoriDonatori() {
        try {
            FXMLFinantatoriDonatoriController selectWindow = (FXMLFinantatoriDonatoriController) replaceSceneContent("gui/FXMLFinantatoriDonatori.fxml");
            selectWindow.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoParteneri() {
        try {
            FXMLParteneriController selectWindow = (FXMLParteneriController) replaceSceneContent("gui/FXMLParteneri.fxml");
            selectWindow.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void gotoVoluntari() {
        try {
            FXMLVoluntariController selectWindow = (FXMLVoluntariController) replaceSceneContent("gui/FXMLVoluntari.fxml");
            selectWindow.setApp(this);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
