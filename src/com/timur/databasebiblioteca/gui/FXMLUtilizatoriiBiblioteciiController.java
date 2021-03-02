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
import com.timur.databasebiblioteca.model.Utilizator;
import com.timur.databasebiblioteca.gui.FormIntF;
import com.timur.databasebiblioteca.service.UtilizatorIOIntF;
import com.timur.databasebiblioteca.service.UtilizatorMockIntF;
import com.timur.databasebiblioteca.service.impl.UtilizatorIOExcelImpl;
import com.timur.databasebiblioteca.service.impl.UtilizatorMockImpl;
import com.timur.databasebiblioteca.util.CSVUtilUtilizator;

/**
 * @author User
 */
public class FXMLUtilizatoriiBiblioteciiController implements Initializable, FormIntF<Utilizator> {

    Main aRefMain;
    @FXML
    private TableView<Utilizator> tableView;
    @FXML
    private TableColumn<Utilizator, Integer> twnrDeInregistrare;
    @FXML
    private TableColumn<Utilizator, String> twNumPrenumPatr;
    @FXML
    private TableColumn<Utilizator, Date> twAnulInregRein;
    @FXML
    private TableColumn<Utilizator, Long> twTelMob;
    @FXML
    private TableColumn<Utilizator, String> twEmail;
    @FXML
    private TableColumn<Utilizator, String> twAdresaDomiciliu;
    @FXML
    private TableColumn<Utilizator, Date> twAnulNasterii;
    @FXML
    private TableColumn<Utilizator, String> twSex;
    @FXML
    private TableColumn<Utilizator, String> twEtnie;
    @FXML
    private TableColumn<Utilizator, String> twOcupatia;
    @FXML
    private TableColumn<Utilizator, String> twOficiuUtilizat;
    @FXML
    private TableColumn<Utilizator, String> twImprumutCarte;

    public void setApp(Main aRefMain) {
        this.aRefMain = aRefMain;
    }

    @FXML
    private TextField tfNrDeInregistrare;
    @FXML
    private TextField tfNumPrenumPatr;
    @FXML
    private DatePicker dpAnInreg;
    @FXML
    private TextField tfTelMob;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfAdresaDomiciliu;
    @FXML
    private DatePicker dpAnulNasterii;
    @FXML
    private ComboBox<String> cbSex;
    @FXML
    private ComboBox<String> cbEtnie;
    @FXML
    private ComboBox<String> cbOcupatia;
    @FXML
    private ComboBox<String> cbOficiulUtilizat;
    @FXML
    private TextField tfImprumutDeCarte;

    public static final String SEX_M = "Masculin";
    public static final String SEX_F = "Feminin";

    public static final String ETNIE_MD = "Moldova";
    public static final String ETNIE_RU = "Rusia";
    public static final String ETNIE_UA = "Ucraina";
    public static final String ETNIE_RO = "România";
    public static final String ETNIE_ALT = "Alta";

    public static final String OCUP_FUNC = "Functionar";
    public static final String OCUP_FERM = "Fermier";
    public static final String OCUP_COMERC = "Comerciant";
    public static final String OCUP_PED = "Pedagog";
    public static final String OCUP_MED = "Lucrator medical";
    public static final String OCUP_ANTR = "Antrepenor";
    public static final String OCUP_JUR = "Jurist";
    public static final String OCUP_CAS = "Casnic";
    public static final String OCUP_STUD = "Student";
    public static final String OCUP_ELEV = "Elev";
    public static final String OCUP_PRESC = "Prescolar";
    public static final String OCUP_ALT = "Alte";

    public static final String OFICIU_CL_I_IV = "Imprumut la domiciliu prescolari si elevii cl. I-IV";
    public static final String OFICIU_CL_V_IX = "Imprumut la domiciliu prescolari si elevii cl. I-IX";
    public static final String OFICIU_LECT_COPII = "Sala de lectura copii";
    public static final String OFICIU_LECT_ADULT = "Sala de lectura adulti";
    public static final String OFICIU_IMPR_ADULT = "Imprumut la domiciliu adulti";
    public static final String OFICIU_LABTIC = "LabTIC";
    public static final String OFICIU_ASIST_SPEC = "Asistenta de specialitate";

    UtilizatorMockIntF utilizatorMock;
    UtilizatorIOIntF utilizatorIOExcel;

    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        utilizatorMock = new UtilizatorMockImpl();
        utilizatorIOExcel = new UtilizatorIOExcelImpl();
        cbSex.getItems().addAll(SEX_M, SEX_F);
        cbSex.setValue("Selecteaza genul");
        cbEtnie.getItems().addAll(ETNIE_MD, ETNIE_RU, ETNIE_UA, ETNIE_RO, ETNIE_ALT);
        cbEtnie.setValue("Selecteaza etnie");
        cbOcupatia.getItems().addAll(OCUP_FUNC, OCUP_FERM, OCUP_COMERC, OCUP_PED, OCUP_MED,
                OCUP_ANTR, OCUP_JUR, OCUP_CAS, OCUP_STUD, OCUP_ELEV, OCUP_PRESC, OCUP_ALT);
        cbOcupatia.setValue("Alege ocupatia");
        cbOficiulUtilizat.getItems().addAll(OFICIU_CL_I_IV, OFICIU_CL_V_IX, OFICIU_LECT_COPII,
                OFICIU_LECT_ADULT, OFICIU_IMPR_ADULT, OFICIU_LABTIC, OFICIU_ASIST_SPEC);
        cbOficiulUtilizat.setValue("Selecteaza oficiul");
    }
    
    public void tableView() {
        initTable();
        loadDateForTableView();
    }

    @FXML
    private void handleButtonActionActualizeaza(ActionEvent event) {
        Utilizator utilizator = readForm();
        utilizatorMock.actualizeazaUtilizator(utilizator);
        clearForm();
        alertaMesaj("Profilul utilizatorului " + utilizator.getNumPrenumPatr() + " s-a actualizat cu succes", true);
        refreshListView();
    }

    @FXML
    private void handleButtonActionSalveaza(ActionEvent event) {
        Utilizator utilizatorNou = readForm();
        String numeUtilizator = tfNumPrenumPatr.getText();
        List<Utilizator> lista = utilizatorMock.cautaTot();
        if (!lista.contains(utilizatorMock.cautare(numeUtilizator))) {
            utilizatorMock.salveazaUtilizator(utilizatorNou);
            clearForm();
            tableView();
        } else {
            alertaMesaj("Utilizator cu asa nume deja exista: " + tfNumPrenumPatr.getText(), true);
        }
    }

    @FXML
    private void handleButtonActionSterge(ActionEvent event) {
        Utilizator utilizator = readForm();
        alertaMesaj("Sigur doriti sa stergeti?", true);
        utilizatorMock.stergeUtilizator(utilizator);
        refreshListView();
        clearForm();
    }

    @FXML
    private void handleButtonActionCurata(ActionEvent event) {
        clearForm();
    }

    @FXML
    private void handleButtonActionCautare(ActionEvent event) {
        String numeUtilizator = tfNumPrenumPatr.getText();
        Utilizator utilizator = utilizatorMock.cautare(numeUtilizator);
        try {
            fillForm(utilizator);
        } catch (Exception e) {
            alertaMesaj("Nu exista utilizator cu asa nume", true);
        }
    }

    @FXML
    private void handleButtonActionCautaTot(ActionEvent event) {
        List<Utilizator> list = utilizatorMock.cautaTot();
        tableView();
    }

    @FXML
    private void handleButtonActionImport(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        try {
            List<Utilizator> listaUtilizatori = utilizatorIOExcel.readFile(String.valueOf(file));
            utilizatorMock = new UtilizatorMockImpl(listaUtilizatori);
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
            List<Utilizator> listUtilizatori = utilizatorMock.cautaTot();
            utilizatorIOExcel.saveToFile(String.valueOf(file), listUtilizatori);
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
    public Utilizator readForm() {
        Utilizator utilizatorNou = new Utilizator();
        utilizatorNou.setNrDeInregistrare(Integer.parseInt(tfNrDeInregistrare.getText()));
        utilizatorNou.setNumPrenumPatr(tfNumPrenumPatr.getText());
        utilizatorNou.setAnInreg(Date.valueOf(dpAnInreg.getValue().toString()));
        utilizatorNou.setTelMob(Long.parseLong(tfTelMob.getText()));
        utilizatorNou.setEmail(tfEmail.getText());
        utilizatorNou.setAdresaDomiciliu(tfAdresaDomiciliu.getText());
        utilizatorNou.setAnulNasterii(Date.valueOf(dpAnulNasterii.getValue().toString()));
        utilizatorNou.setSex(cbSex.getValue());
        utilizatorNou.setEtnie(cbEtnie.getValue());
        utilizatorNou.setOcupatia(cbOcupatia.getValue());
        utilizatorNou.setOficiulUtilizat(cbOficiulUtilizat.getValue());
        utilizatorNou.setImprumutDeCarte(tfImprumutDeCarte.getText());
        return utilizatorNou;
    }

    @Override
    public void clearForm() {
        tfNrDeInregistrare.setText("");
        tfNumPrenumPatr.setText("");
        dpAnInreg.setValue(null);
        tfTelMob.setText("");
        tfEmail.setText("");
        tfAdresaDomiciliu.setText("");
        dpAnulNasterii.setValue(null);
        cbSex.setValue(null);
        cbEtnie.setValue(null);
        cbOcupatia.setValue(null);
        cbOficiulUtilizat.setValue(null);
        tfImprumutDeCarte.setText("");
    }

    @Override
    public void fillForm(Utilizator utilizator) {
        tfNrDeInregistrare.setText("" + utilizator.getNrDeInregistrare());
        tfNumPrenumPatr.setText("" + utilizator.getNumPrenumPatr());
        dpAnInreg.setValue(LocalDate.parse(utilizator.getAnInreg().toString()));
        tfTelMob.setText("" + utilizator.getTelMob());
        tfEmail.setText("" + utilizator.getEmail());
        tfAdresaDomiciliu.setText("" + utilizator.getAdresaDomiciliu());
        dpAnulNasterii.setValue(LocalDate.parse(utilizator.getAnulNasterii().toString()));
        cbSex.setValue("" + utilizator.getSex());
        cbEtnie.setValue("" + utilizator.getEtnie());
        cbOcupatia.setValue("" + utilizator.getOcupatia());
        cbOficiulUtilizat.setValue("" + utilizator.getOficiulUtilizat());
        tfImprumutDeCarte.setText("" + utilizator.getImprumutDeCarte());
    }

    public void refreshListView() {
        List<Utilizator> listaDeUtilizatori = utilizatorMock.cautaTot();
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
        twnrDeInregistrare.setCellValueFactory(new PropertyValueFactory<>("nrDeInregistrare"));
        twNumPrenumPatr.setCellValueFactory(new PropertyValueFactory<>("numPrenumPatr"));
        twAnulInregRein.setCellValueFactory(new PropertyValueFactory<>("anInreg"));
        twTelMob.setCellValueFactory(new PropertyValueFactory<>("telMob"));
        twEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        twAdresaDomiciliu.setCellValueFactory(new PropertyValueFactory<>("adresaDomiciliu"));
        twAnulNasterii.setCellValueFactory(new PropertyValueFactory<>("anulNasterii"));
        twSex.setCellValueFactory(new PropertyValueFactory<>("sex"));
        twEtnie.setCellValueFactory(new PropertyValueFactory<>("etnie"));
        twOcupatia.setCellValueFactory(new PropertyValueFactory<>("ocupatia"));
        twOficiuUtilizat.setCellValueFactory(new PropertyValueFactory<>("oficiulUtilizat"));
        twImprumutCarte.setCellValueFactory(new PropertyValueFactory<>("imprumutDeCarte"));
    }

    private void loadDateForTableView() {
        List<Utilizator> listaUtilizators = new ArrayList<>();
        listaUtilizators = utilizatorMock.cautaTot();
        
        String rind = null;
        while(rind != null) {
            Utilizator utilizator = CSVUtilUtilizator.rindToUtilizator(rind);
            listaUtilizators.add(utilizator);
        }
        ObservableList<Utilizator> tableDate = FXCollections.observableArrayList();
        for (Utilizator utilizator : listaUtilizators) {
            tableDate.add(new Utilizator(utilizator.getNrDeInregistrare(), utilizator.getNumPrenumPatr(),
            utilizator.getAnInreg(), utilizator.getTelMob(), utilizator.getEmail(), 
            utilizator.getAdresaDomiciliu(), utilizator.getAnulNasterii(), 
            utilizator.getSex(), utilizator.getEtnie(), utilizator.getOcupatia(),
            utilizator.getOficiulUtilizat(), utilizator.getImprumutDeCarte()));
        }
        tableView.setItems(tableDate);
    }
}
