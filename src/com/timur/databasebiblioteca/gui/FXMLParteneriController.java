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
import com.timur.databasebiblioteca.model.Partener;
import com.timur.databasebiblioteca.gui.FormIntF;
import com.timur.databasebiblioteca.service.PartenerIOIntF;
import com.timur.databasebiblioteca.service.PartenerMockIntF;
import com.timur.databasebiblioteca.service.impl.PartenerIOExcelImpl;
import com.timur.databasebiblioteca.service.impl.PartenerMockImpl;
import com.timur.databasebiblioteca.util.CSVUtilPartener;

/**
 * @author Timur
 */
public class FXMLParteneriController implements Initializable, FormIntF<Partener> {

    @FXML
    private TextField tfNrDeInregistrare;
    @FXML
    private TextField tfNumelePartenerului;
    @FXML
    private TextField tfDomeniulDeActivitate;
    @FXML
    private TextField tfNumarulSemnarii;
    @FXML
    private DatePicker dpDataSemnarii;
    @FXML
    private TextField tfScopulParteneriatului;
    @FXML
    private DatePicker dpValabilitateaContractului;
    @FXML
    private TableView<Partener> tableView;
    @FXML
    private TableColumn<Partener, Integer> twNrDeInregistrare;
    @FXML
    private TableColumn<Partener, String> twNumelePartenerului;
    @FXML
    private TableColumn<Partener, String> twDomeniulDeActivitate;
    @FXML
    private TableColumn<Partener, Integer> twNrContractului;
    @FXML
    private TableColumn<Partener, Date> twDataSemnarii;
    @FXML
    private TableColumn<Partener, Date> twValoareaContractului;
    @FXML
    private TableColumn<Partener, String> twScopulParteneriatului;
   
    Main aRefMain;

    private Stage stage;
    
    public void setApp(Main aRefMain) {
        this.aRefMain = aRefMain;
    }

    PartenerMockIntF partenerMock;
    PartenerIOIntF partenerIOExcel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        partenerMock = new PartenerMockImpl();
        partenerIOExcel = new PartenerIOExcelImpl();
    }
    
    public void tableView() {
        initTable();
        loadDateForTableView();
    }

    @FXML
    private void handleButtonActionActualizeaza(ActionEvent event) {
        Partener partener = readForm();
        partenerMock.actualizeazaPartener(partener);
        clearForm();
        alertaMesaj("Profilul partenerului " + partener.getNumelePartenerului() + " s-a actualizat cu succes", true);
        refreshListView();
    }

    @FXML
    private void handleButtonActionSalveaza(ActionEvent event) {
        Partener partenerNou = readForm();
        String numePartener = tfNumelePartenerului.getText();
        List<Partener> lista = partenerMock.cautaTot();
        if (!lista.contains(partenerMock.cautare(numePartener))) {
            partenerMock.salveazaPartener(partenerNou);
            clearForm();
//            listView.getItems().add(partenerNou.toString());
        tableView();
        } else {
            alertaMesaj("Partener cu asa nume deja exista: " + tfNumelePartenerului.getText(), true);
        }
    }

    @FXML
    private void handleButtonActionSterge(ActionEvent event) {
        Partener partener = readForm();
        alertaMesaj("Sigur doriti sa stergeti?", true);
        partenerMock.stergePartener(partener);
        refreshListView();
        clearForm();
    }

    @FXML
    private void handleButtonActionCurata(ActionEvent event) {
        clearForm();
    }

    @FXML
    private void handleButtonActionCautare(ActionEvent event) {
        String numePartener = tfNumelePartenerului.getText();
        Partener partener = partenerMock.cautare(numePartener);
       try {
            fillForm(partener);
        } catch (Exception e) {
            alertaMesaj("Nu exista partener cu asa nume", true);
        }
    }

    @FXML
    private void handleButtonActionCautaTot(ActionEvent event) {
        List<Partener> list = partenerMock.cautaTot();
//        listView.getItems();
        tableView();
    }

    @FXML
    private void handleButtonActionImport(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        try {
            List<Partener> listaParteneri = partenerIOExcel.readFile(String.valueOf(file));
            partenerMock = new PartenerMockImpl(listaParteneri);
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
            List<Partener> listParteneri = partenerMock.cautaTot();
            partenerIOExcel.saveToFile(String.valueOf(file), listParteneri);
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
    public Partener readForm() {
        Partener partenerNou = new Partener();
        partenerNou.setNrDeInregistrare(Integer.parseInt(tfNrDeInregistrare.getText()));
        partenerNou.setNumelePartenerului(tfNumelePartenerului.getText());
        partenerNou.setDomeniulDeActivitate(tfDomeniulDeActivitate.getText());
        partenerNou.setNumarulSemnarii(Integer.parseInt(tfNumarulSemnarii.getText()));
        partenerNou.setDataSemnarii(Date.valueOf(dpDataSemnarii.getValue().toString()));
        partenerNou.setValabilitateaContractului(Date.valueOf(dpValabilitateaContractului.getValue().toString()));
        partenerNou.setScopulParteneriatului(tfScopulParteneriatului.getText());
        return partenerNou;
    }

    @Override
    public void clearForm() {
        tfNrDeInregistrare.setText("");
        tfNumelePartenerului.setText("");
        tfDomeniulDeActivitate.setText("");
        tfNumarulSemnarii.setText("");
        dpDataSemnarii.setValue(null);
        dpValabilitateaContractului.setValue(null);
        tfScopulParteneriatului.setText("");

    }

    @Override
    public void fillForm(Partener partener) {
        tfNrDeInregistrare.setText("" + partener.getNrDeInregistrare());
        tfNumelePartenerului.setText("" + partener.getNumelePartenerului());
        tfDomeniulDeActivitate.setText("" + partener.getDomeniulDeActivitate());
        tfNumarulSemnarii.setText("" + partener.getNumarulSemnarii());
        dpDataSemnarii.setValue(LocalDate.parse(partener.getDataSemnarii().toString()));
        dpValabilitateaContractului.setValue(LocalDate.parse(partener.getValabilitateaContractului().toString()));
        tfScopulParteneriatului.setText("" + partener.getScopulParteneriatului());
    }

    public void refreshListView() {
        List<Partener> listaDeParteneri = partenerMock.cautaTot();
//        listView.getItems().clear();
//        listView.getItems().addAll(listaDeParteneri.toString());
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
        twNumelePartenerului.setCellValueFactory(new PropertyValueFactory<>("numelePartenerului"));
        twDomeniulDeActivitate.setCellValueFactory(new PropertyValueFactory<>("domeniulDeActivitate"));
        twNrContractului.setCellValueFactory(new PropertyValueFactory<>("numarulSemnarii"));
        twDataSemnarii.setCellValueFactory(new PropertyValueFactory<>("dataSemnarii"));
        twValoareaContractului.setCellValueFactory(new PropertyValueFactory<>("descriereaActivitatii"));
        twScopulParteneriatului.setCellValueFactory(new PropertyValueFactory<>("scopulParteneriatului"));
    }

    private void loadDateForTableView() {
        List<Partener> listaParteners = new ArrayList<>();
        listaParteners = partenerMock.cautaTot();
        
        String rind = null;
        while(rind != null) {
            Partener partener = CSVUtilPartener.rindToPartener(rind);
            listaParteners.add(partener);
        }
        ObservableList<Partener> tableDate = FXCollections.observableArrayList();
        for (Partener partener : listaParteners) {
            tableDate.add(new Partener(partener.getNrDeInregistrare(), partener.getNumelePartenerului(),
            partener.getDomeniulDeActivitate(), partener.getNumarulSemnarii(),
            partener.getDataSemnarii(), partener.getValabilitateaContractului(),
            partener.getScopulParteneriatului()));
        }
        tableView.setItems(tableDate);
    }
}
