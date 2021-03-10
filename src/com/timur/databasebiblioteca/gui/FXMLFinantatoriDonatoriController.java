package com.timur.databasebiblioteca.gui;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.timur.databasebiblioteca.Main;
import com.timur.databasebiblioteca.model.FinantatorDonator;
import com.timur.databasebiblioteca.service.FinantatorDonatorIOIntF;
import com.timur.databasebiblioteca.service.FinantatorDonatorMockIntF;
import com.timur.databasebiblioteca.gui.FormIntF;
import com.timur.databasebiblioteca.service.impl.FinantatorDonatorIOExcelImpl;
import com.timur.databasebiblioteca.service.impl.FinantatorDonatorMockImpl;
import com.timur.databasebiblioteca.util.CSVUtilFinantatorDonator;

/**
 * @author Timur
 */
public class FXMLFinantatoriDonatoriController implements Initializable, FormIntF<FinantatorDonator> {

    @FXML
    private TextField tfNrDeInregistrare;
    @FXML
    private TextField tfNumeOrgPers;
    @FXML
    private TextField tfAutotfAdresaJuridicar;
    @FXML
    private TextField tfDateDeContact;
    @FXML
    private TextField tfInfoFinatator;
    @FXML
    private TextField tfScopulFinatarii;
    @FXML
    private DatePicker dpAnulFinatarii;
    @FXML
    private TextField tfValoareaFinantarii;
    @FXML
    private TextField tfAlteMentiuni;
    @FXML
    private TableView<FinantatorDonator> tableView;
    @FXML
    private TableColumn<FinantatorDonator, Integer> twNrDeInregistrare;
    @FXML
    private TableColumn<FinantatorDonator, String> twNumeOrgPers;
    @FXML
    private TableColumn<FinantatorDonator, String> twAdrJurid;
    @FXML
    private TableColumn<FinantatorDonator, String> twDateConatct;
    @FXML
    private TableColumn<FinantatorDonator, String> twInfoFinatator;
    @FXML
    private TableColumn<FinantatorDonator, String> twScopulFinantarii;
    @FXML
    private TableColumn<FinantatorDonator, Date> twAnulFinantarii;
    @FXML
    private TableColumn<FinantatorDonator, Double> twValoareaFinantarii;
    @FXML
    private TableColumn<FinantatorDonator, String> twAlteMentiuni;

    Main aRefMain;

    private Stage stage;
   
    public void setApp(Main aRefMain) {
        this.aRefMain = aRefMain;
    }

    FinantatorDonatorMockIntF finantatorDonatorMock;
    FinantatorDonatorIOIntF finantatorDonatorIOExcel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        finantatorDonatorMock = new FinantatorDonatorMockImpl();
        finantatorDonatorIOExcel = new FinantatorDonatorIOExcelImpl();
    }
    
    public void tableView() {
        initTable();
        loadDateForTableView();
    }

    @FXML
    private void handleButtonActionActualizeaza(ActionEvent event) {
        FinantatorDonator finantatorDonator = readForm();
        finantatorDonatorMock.actualizeazaFinantatorDonator(finantatorDonator);
        clearForm();
        alertaMesaj("Profilul finantatorului " + finantatorDonator.getNumeOrgPers() + " s-a actualizat cu succes", true);
        refreshListView();
    }

    @FXML
    private void handleButtonActionSalveaza(ActionEvent event) {
        FinantatorDonator finantatorDonatorNou = readForm();
        String numeFinantatorDonator = tfNumeOrgPers.getText();
        List<FinantatorDonator> lista = finantatorDonatorMock.cautaTot();
        if (!lista.contains(finantatorDonatorMock.cautare(numeFinantatorDonator))) {
            finantatorDonatorMock.salveazaFinantatorDonator(finantatorDonatorNou);
            clearForm();
            //listView.getItems().add(finantatorDonatorNou.toString());
            tableView();
        } else {
            alertaMesaj("Finantator cu asa nume deja exista: " + tfNumeOrgPers.getText(), true);
        }
    }

    @FXML
    private void handleButtonActionSterge(ActionEvent event) {
        FinantatorDonator finantatorDonator = readForm();
        alertaMesaj("Sigur doriti sa stergeti?", true);
        finantatorDonatorMock.stergeFinantatorDonator(finantatorDonator);
        refreshListView();
        clearForm();
    }

    @FXML
    private void handleButtonActionCurata(ActionEvent event) {
        clearForm();
    }

    @FXML
    private void handleButtonActionCautare(ActionEvent event) {
        String numeFinantatorDonator = tfNumeOrgPers.getText();
        FinantatorDonator finantatorDonator = finantatorDonatorMock.cautare(numeFinantatorDonator);
       try {
            fillForm(finantatorDonator);
        } catch (Exception e) {
            alertaMesaj("Nu exista finantator cu asa nume", true);
        }
    }

    @FXML
    private void handleButtonActionCautaTot(ActionEvent event) {
        List<FinantatorDonator> list = finantatorDonatorMock.cautaTot();
//        listView.getItems();
        tableView();
    }

    @FXML
    private void handleButtonActionImport(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        try {
            List<FinantatorDonator> listaFinantatoriDonatori = finantatorDonatorIOExcel.readFile(String.valueOf(file));
            finantatorDonatorMock = new FinantatorDonatorMockImpl(listaFinantatoriDonatori);
        } catch (Exception e) {
            alertaMesaj("M-ai incercati odata", true);
        }
        refreshListView();
    }

    @FXML
    private void handleButtonActionExport(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterXLS = new FileChooser.ExtensionFilter("Excel files (*.xls)", "*.xls");
        FileChooser.ExtensionFilter extFilterXLSX = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx");
        FileChooser.ExtensionFilter extFilterCSV = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().addAll(extFilterXLS, extFilterXLSX, extFilterCSV);
        File file = fileChooser.showSaveDialog(stage);
        try {
            List<FinantatorDonator> listFinantatoriDonatori = finantatorDonatorMock.cautaTot();
            finantatorDonatorIOExcel.saveToFile(String.valueOf(file), listFinantatoriDonatori);
        } catch (Exception e) {
            alertaMesaj("M-ai incercati odata", true);
        }
        alertaMesaj("S-a exportat cu succes in Excel", true);
    }

    @FXML
    private void handleButtonActionInapoi(ActionEvent event) {
        aRefMain.gotoSelecteazaFormularul();
    }

    @Override
    public FinantatorDonator readForm() {
        FinantatorDonator finantatorDonatorNou = new FinantatorDonator();
        finantatorDonatorNou.setNrDeInregistrare(Integer.parseInt(tfNrDeInregistrare.getText()));
        finantatorDonatorNou.setNumeOrgPers(tfNumeOrgPers.getText());
        finantatorDonatorNou.setAdresaJuridicar(tfAutotfAdresaJuridicar.getText());
        finantatorDonatorNou.setDateDeContact(tfDateDeContact.getText());
        finantatorDonatorNou.setInfoFinatator(tfInfoFinatator.getText());
        finantatorDonatorNou.setScopulFinatarii(tfScopulFinatarii.getText());
        finantatorDonatorNou.setAnulFinatarii(Date.valueOf(dpAnulFinatarii.getValue().toString()));
        finantatorDonatorNou.setValoareaFinantarii(Double.parseDouble(tfValoareaFinantarii.getText()));
        finantatorDonatorNou.setAlteMentiuni(tfAlteMentiuni.getText());
        return finantatorDonatorNou;
    }

    @Override
    public void clearForm() {
        tfNrDeInregistrare.setText("");
        tfNumeOrgPers.setText("");
        tfAutotfAdresaJuridicar.setText("");
        tfDateDeContact.setText("");
        tfInfoFinatator.setText("");
        tfScopulFinatarii.setText("");
        dpAnulFinatarii.setValue(null);
        tfValoareaFinantarii.setText("");
        tfAlteMentiuni.setText("");
    }

    @Override
    public void fillForm(FinantatorDonator finantatorDonator) {
        tfNrDeInregistrare.setText("" + finantatorDonator.getNrDeInregistrare());
        tfNumeOrgPers.setText("" + finantatorDonator.getNumeOrgPers());
        tfAutotfAdresaJuridicar.setText("" + finantatorDonator.getAdresaJuridicar());
        tfDateDeContact.setText("" + finantatorDonator.getDateDeContact());
        tfInfoFinatator.setText("" + finantatorDonator.getInfoFinatator());
        tfScopulFinatarii.setText("" + finantatorDonator.getScopulFinatarii());
        dpAnulFinatarii.setValue(LocalDate.parse(finantatorDonator.getAnulFinatarii().toString()));
        tfValoareaFinantarii.setText("" + finantatorDonator.getValoareaFinantarii());
        tfAlteMentiuni.setText("" + finantatorDonator.getAlteMentiuni());
    }

    public void refreshListView() {
        List<FinantatorDonator> listaDeFinantatoriDonatori = finantatorDonatorMock.cautaTot();
//        listView.getItems().clear();
//        listView.getItems().addAll(listaDeFinantatoriDonatori.toString());
        tableView();
    }

    public void alertaMesaj(String mesaj, boolean b) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Urmeaza modificari");
        alert.setHeaderText("Atentie!");
        alert.setContentText(mesaj);

        alert.showAndWait();
    }

    private void initTable() {
        twNrDeInregistrare.setCellValueFactory(new PropertyValueFactory<>("nrDeInregistrare"));
        twNumeOrgPers.setCellValueFactory(new PropertyValueFactory<>("numeOrgPers"));
        twAdrJurid.setCellValueFactory(new PropertyValueFactory<>("adresaJuridicar"));
        twDateConatct.setCellValueFactory(new PropertyValueFactory<>("dateDeContact"));
        twInfoFinatator.setCellValueFactory(new PropertyValueFactory<>("infoFinatator"));
        twScopulFinantarii.setCellValueFactory(new PropertyValueFactory<>("scopulFinatarii"));
        twAnulFinantarii.setCellValueFactory(new PropertyValueFactory<>("anulFinatarii"));
        twValoareaFinantarii.setCellValueFactory(new PropertyValueFactory<>("valoareaFinantarii"));
        twAlteMentiuni.setCellValueFactory(new PropertyValueFactory<>("alteMentiuni"));
    }

    private void loadDateForTableView() {
        List<FinantatorDonator> listaFinantatorDonators = new ArrayList<>();
        listaFinantatorDonators = finantatorDonatorMock.cautaTot();
        
        String rind = null;
        while(rind != null) {
            FinantatorDonator finantatorDonator = CSVUtilFinantatorDonator.rindToFinantatorDonator(rind);
            listaFinantatorDonators.add(finantatorDonator);
        }
        ObservableList<FinantatorDonator> tableDate = FXCollections.observableArrayList();
        for (FinantatorDonator finantatorDonator : listaFinantatorDonators) {
            tableDate.add(new FinantatorDonator(finantatorDonator.getNrDeInregistrare(), 
                    finantatorDonator.getNumeOrgPers(), finantatorDonator.getAdresaJuridicar(), 
                    finantatorDonator.getDateDeContact(), finantatorDonator.getInfoFinatator(), 
                    finantatorDonator.getScopulFinatarii(), finantatorDonator.getAnulFinatarii(), 
                    finantatorDonator.getValoareaFinantarii(), finantatorDonator.getAlteMentiuni()));
        }
        tableView.setItems(tableDate);
    }
}
