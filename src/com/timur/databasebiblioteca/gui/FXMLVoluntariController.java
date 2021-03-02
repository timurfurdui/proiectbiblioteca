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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.timur.databasebiblioteca.Main;
import com.timur.databasebiblioteca.model.Voluntar;
import com.timur.databasebiblioteca.gui.FormIntF;
import com.timur.databasebiblioteca.service.VoluntarIOIntF;
import com.timur.databasebiblioteca.service.VoluntarMockIntF;
import com.timur.databasebiblioteca.service.impl.VoluntarIOExcelImpl;
import com.timur.databasebiblioteca.service.impl.VoluntarMockImpl;
import com.timur.databasebiblioteca.util.CSVUtilVoluntar;

/**
 * @author User
 */
public class FXMLVoluntariController implements Initializable, FormIntF<Voluntar> {

    @FXML
    private TextField tfNrDeInregistrare;
    @FXML
    private TextField tfNumeleVoluntarului;
    @FXML
    private DatePicker dpVirstaVoluntarului;
    @FXML
    private TextField tfPerioadaDeActivitate;
    @FXML
    private ComboBox<String> cbDomeniulDeActivitate;
    @FXML
    private TextField tfDescriereaActivitatii;
    @FXML
    private TableView<Voluntar> tableView;
    @FXML
    private TableColumn<Voluntar, Integer> twNrOrd;
    @FXML
    private TableColumn<Voluntar, String> twNumeVoluntar;
    @FXML
    private TableColumn<Voluntar, Date> twVirstaVoluntar;
    @FXML
    private TableColumn<Voluntar, Integer> twPerioadaActivitate;
    @FXML
    private TableColumn<Voluntar, String> twDomeniulActivitate;
    @FXML
    private TableColumn<Voluntar, String> twDescriereaActivitatii;

    public static final String ACT_INCLDIGI = "Incluziune digitala";
    public static final String ACT_AGR = "Activitati de agrement";
    public static final String ACT_CULTART = "Activitati de cultural-artistice";
    public static final String ACT_EDU = "Activitati educative";
    public static final String ACT_INSTR = "Activitati de instruire";
    public static final String ACT_SUST = "Activitati de sustinere organizationala";
    public static final String ACT_COM = "Activitati comunitare";
    public static final String ACT_ALT = "Alte";

    private Stage stage;

    Main aRefMain;

    public void setApp(Main aRefMain) {
        this.aRefMain = aRefMain;
    }

    VoluntarMockIntF voluntarMock;
    VoluntarIOIntF voluntarIOExcel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        voluntarMock = new VoluntarMockImpl();
        voluntarIOExcel = new VoluntarIOExcelImpl();
        cbDomeniulDeActivitate.getItems().addAll(ACT_INCLDIGI, ACT_AGR, ACT_CULTART,
                ACT_EDU, ACT_INSTR, ACT_SUST, ACT_COM, ACT_ALT);
        cbDomeniulDeActivitate.setValue("Selecteaza activitate");
    }

    public void tableView() {
        initTable();
        loadDateForTableView();
    }

    @FXML
    private void handleButtonActionActualizeaza(ActionEvent event) {
        Voluntar voluntar = readForm();
        voluntarMock.actualizeazaVoluntar(voluntar);
        clearForm();
        alertaMesaj("Voluntarul cu numele " + voluntar.getNumeleVoluntarului() + " s-a actualizat cu succes", true);
        refreshListView();
    }

    @FXML
    private void handleButtonActionSalveaza(ActionEvent event) {
        Voluntar voluntarNou = readForm();
        String numeVoluntar = tfNumeleVoluntarului.getText();
        List<Voluntar> lista = voluntarMock.cautaTot();
        if (!lista.contains(voluntarMock.cautare(numeVoluntar))) {
            voluntarMock.salveazaVoluntar(voluntarNou);
            clearForm();
            tableView();
        } else {
            alertaMesaj("Voluntar cu asa nume deja exista: " + tfNumeleVoluntarului.getText(), true);
        }
    }

    @FXML
    private void handleButtonActionSterge(ActionEvent event) {
        Voluntar voluntar = readForm();
        alertaMesaj("Sigur doriti sa stergeti?", true);
        voluntarMock.stergeVoluntar(voluntar);
        refreshListView();
        clearForm();
    }

    @FXML
    private void handleButtonActionCurata(ActionEvent event) {
        clearForm();
    }

    @FXML
    private void handleButtonActionCautare(ActionEvent event) {
        String numeVoluntar = tfNumeleVoluntarului.getText();
        Voluntar voluntar = voluntarMock.cautare(numeVoluntar);
        try {
            fillForm(voluntar);
        } catch (Exception e) {
            alertaMesaj("Nu exista voluntar cu asa nume", true);
        }
    }

    @FXML
    private void handleButtonActionCautaTot(ActionEvent event) {
        List<Voluntar> list = voluntarMock.cautaTot();
        tableView();
    }

    @FXML
    private void handleButtonActionImport(ActionEvent event) throws Exception {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        try {
            List<Voluntar> listaVoluntari = voluntarIOExcel.readFile(String.valueOf(file));
            voluntarMock = new VoluntarMockImpl(listaVoluntari);
        } catch (Exception e) {
            alertaMesaj("M-ai incercati odata", true);
        }
        refreshListView();
    }

    @FXML
    private void handleButtonActionExport(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterXLS = new FileChooser.ExtensionFilter("Excel files (*.xls)", "*.xls");
        FileChooser.ExtensionFilter extFilterXLSX = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx");
        FileChooser.ExtensionFilter extFilterCSV = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().addAll(extFilterXLS, extFilterXLSX, extFilterCSV);
        File file = fileChooser.showSaveDialog(stage);
        try {
            List<Voluntar> listVoluntari = voluntarMock.cautaTot();
            voluntarIOExcel.saveToFile(String.valueOf(file), listVoluntari);
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
    public Voluntar readForm() {
        Voluntar voluntarNou = new Voluntar();
        voluntarNou.setNrDeInregistrare(Integer.parseInt(tfNrDeInregistrare.getText()));
        voluntarNou.setNumeleVoluntarului(tfNumeleVoluntarului.getText());
        voluntarNou.setVirstaVoluntarului(Date.valueOf(dpVirstaVoluntarului.getValue().toString()));
        voluntarNou.setPerioadaDeActivitate(Integer.parseInt(tfPerioadaDeActivitate.getText()));
        voluntarNou.setDomeniulDeActivitate(cbDomeniulDeActivitate.getValue());
        voluntarNou.setDescriereaActivitatii(tfDescriereaActivitatii.getText());
        return voluntarNou;
    }

    @Override
    public void clearForm() {
        tfNrDeInregistrare.setText("");
        tfNumeleVoluntarului.setText("");
        dpVirstaVoluntarului.setValue(null);
        tfPerioadaDeActivitate.setText("");
        cbDomeniulDeActivitate.setValue(null);
        tfDescriereaActivitatii.setText("");
    }

    @Override
    public void fillForm(Voluntar voluntar) {
        tfNrDeInregistrare.setText("" + voluntar.getNrDeInregistrare());
        tfNumeleVoluntarului.setText("" + voluntar.getNumeleVoluntarului());
        dpVirstaVoluntarului.setValue(LocalDate.parse(voluntar.getVirstaVoluntarului().toString()));
        tfPerioadaDeActivitate.setText("" + voluntar.getPerioadaDeActivitate());
        cbDomeniulDeActivitate.setValue("" + voluntar.getDomeniulDeActivitate());
        tfDescriereaActivitatii.setText("" + voluntar.getDescriereaActivitatii());
    }

    public void refreshListView() {
        List<Voluntar> listaDeVoluntari = voluntarMock.cautaTot();
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
        twNrOrd.setCellValueFactory(new PropertyValueFactory<>("nrDeInregistrare"));
        twNumeVoluntar.setCellValueFactory(new PropertyValueFactory<>("numeleVoluntarului"));
        twVirstaVoluntar.setCellValueFactory(new PropertyValueFactory<>("virstaVoluntarului"));
        twPerioadaActivitate.setCellValueFactory(new PropertyValueFactory<>("perioadaDeActivitate"));
        twDomeniulActivitate.setCellValueFactory(new PropertyValueFactory<>("domeniulDeActivitate"));
        twDescriereaActivitatii.setCellValueFactory(new PropertyValueFactory<>("descriereaActivitatii"));
    }

    private void loadDateForTableView() {
        List<Voluntar> listaVoluntari = new ArrayList<>();
        listaVoluntari = voluntarMock.cautaTot();

        String rind = null;
        while (rind != null) {
            Voluntar voluntar = CSVUtilVoluntar.rindToVoluntar(rind);
            listaVoluntari.add(voluntar);
        }
        ObservableList<Voluntar> tableDate = FXCollections.observableArrayList();
        for (Voluntar voluntar : listaVoluntari) {
            tableDate.add(new Voluntar(voluntar.getNrDeInregistrare(), voluntar.getNumeleVoluntarului(),
                    voluntar.getVirstaVoluntarului(), voluntar.getPerioadaDeActivitate(),
                    voluntar.getDomeniulDeActivitate(), voluntar.getDescriereaActivitatii()));
        }
        tableView.setItems(tableDate);
    }
}
