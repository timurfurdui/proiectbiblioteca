package com.timur.databasebiblioteca.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.timur.databasebiblioteca.Main;
import com.timur.databasebiblioteca.model.Angajat;
import com.timur.databasebiblioteca.service.AngajatMockIntF;
import com.timur.databasebiblioteca.service.AngajatOIntF;
import com.timur.databasebiblioteca.gui.FormIntF;
import com.timur.databasebiblioteca.service.impl.AngajatMockImpl;
import com.timur.databasebiblioteca.service.impl.AngajatOExcelImpl;

import java.io.File;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import com.timur.databasebiblioteca.util.CSVUtilAngajat;

/**
 * @author Timur
 */
public class FXMLAngajatiController implements Initializable, FormIntF<Angajat> {

    @FXML
    private TextField tfSeriaBI;
    @FXML
    private TextField tfCNP;
    @FXML
    private TextField tfAdresaDomiciliu;
    @FXML
    private ComboBox<String> cbSpecializarea;
    @FXML
    private TextField tfNrDeInregistrare;
    @FXML
    private TextField tfNumelePrenumele;
    @FXML
    private DatePicker spDataDeNastere;
    @FXML
    private ComboBox<String> cbApartenentaEtnica;
    @FXML
    private ComboBox<String> cbSexul;
    @FXML
    private ComboBox<String> cbStudiile;
    @FXML
    private DatePicker dpDemisionare;
    @FXML
    private DatePicker dpEliberatBI;
    @FXML
    private TextField tfEmail;
    @FXML
    private ComboBox<String> cbFunctiaDetinuta;
    @FXML
    private TextField tfTel;
    @FXML
    private TextField tfScopulPremiului;
    @FXML
    private DatePicker dpAnulConferirei;
    @FXML
    private DatePicker dpDataAngajarii;
    @FXML
    private TextField tfPremiiDistinctii;
    @FXML
    private TableView<Angajat> tableView;
    @FXML
    private TableColumn<Angajat, Integer> twNrDeInregistrare;
    @FXML
    private TableColumn<Angajat, String> twNumelePrenumele;
    @FXML
    private TableColumn<Angajat, Date> twDataNastere;
    @FXML
    private TableColumn<Angajat, String> twSeriaBI;
    @FXML
    private TableColumn<Angajat, Date> twEliberatBI;
    @FXML
    private TableColumn<Angajat, Long> twCNP;
    @FXML
    private TableColumn<Angajat, String> twAdresaDomiciliu;
    @FXML
    private TableColumn<Angajat, Long> twTelMob;
    @FXML
    private TableColumn<Angajat, String> twEmail;
    @FXML
    private TableColumn<Angajat, String> twApartenentaEtnica;
    @FXML
    private TableColumn<Angajat, String> twSexul;
    @FXML
    private TableColumn<Angajat, String> twStudiile;
    @FXML
    private TableColumn<Angajat, String> twSpecializarea;
    @FXML
    private TableColumn<Angajat, String> twFunctiaDetinuta;
    @FXML
    private TableColumn<Angajat, Date> twDataAngajarii;
    @FXML
    private TableColumn<Angajat, String> twPremiiDistinctii;
    @FXML
    private TableColumn<Angajat, Date> twAnulConferirii;
    @FXML
    private TableColumn<Angajat, String> twScopul;
    @FXML
    private TableColumn<Angajat, Date> twDataEliberarii;
    
    Main aRefMain;

    public void setApp(Main aRefMain) {
        this.aRefMain = aRefMain;
    }

    public static final String ETNIE_MD = "Moldoveana";
    public static final String ETNIE_RO = "Româna";
    public static final String ETNIE_RU = "Rusa";
    public static final String ETNIE_UA = "Ucraineana";
    public static final String ETNIE_BG = "Bulgara";
    public static final String ETNIE_GA = "Gagauza";
    public static final String ETNIE_ALT = "Altele";

    public static final String SEX_M = "Masculin";
    public static final String SEX_F = "Feminin";

    public static final String STUD_SCDUR = "Cursuri de scurta durata";
    public static final String STUD_GIMN = "Gimnaziale";
    public static final String STUD_LIC = "Liceale";
    public static final String STUD_MEDS = "Medii speciale";
    public static final String STUD_SUP = "Superioare";
    public static final String STUD_MAST = "Master";

    public static final String SPEC_BIBL = "Biblioteconomie si bibliografie";
    public static final String SPEC_JURN = "Jurnalism";
    public static final String SPEC_PED = "Pedagogie";
    public static final String SPEC_MED = "Medicina";
    public static final String SPEC_CONT = "Contabilitate";
    public static final String SPEC_FIN = "Finante";
    public static final String SPEC_JUR = "Juridica";
    public static final String SPEC_ADMN = "Administratie publica";
    public static final String SPEC_AGRO = "Agronomie";
    public static final String SPEC_ALT = "Altele";

    public static final String FUNC_BIBL = "Bibliotecar(a)";
    public static final String FUNC_I_IV = "Sef sector Imprumut la domiciliu cl I-IV";
    public static final String FUNC_V_IX = "Sef sector Imprumut la domiciliu cl V-IX";
    public static final String FUNC_ADULT = "Sef sector Imprumut la domiciliu adulti";
    public static final String FUNC_LECTCOP = "Sef sector Sala de lectura copii";
    public static final String FUNC_LECTADULT = "Sef sector Sala de lectura adulti";
    public static final String FUNC_LABTIC = "Sef sector LabTIC";
    public static final String FUNC_BIBPRIN = "Bibliotecar principal";
    public static final String FUNC_BIBLPRIN = "Bibliograf principal";
    public static final String FUNC_ADMIN = "Administrator de retea";
    public static final String FUNC_FORMASIST = "Sef serviciu Formare si asistenta de specialitate";
    public static final String FUNC_ORGDEZV = "Sef serviciu Organizarea si dezvoltarea colectiilor";
    public static final String FUNC_RELPUB = "Sef serviciu Relatii cu publicul";
    public static final String FUNC_DIRADM = "Director administrativ";
    public static final String FUNC_DIRADJ = "Director adjunct";
    public static final String FUNC_DIR = "Director";
    public static final String FUNC_DER = "Deritecator(e)";
    public static final String FUNC_PAZ = "Paznic";
    public static final String FUNC_SOF = "Sofer";
    public static final String FUNC_MUN = "Muncitor";

    AngajatMockIntF angajatMock;
    AngajatOIntF angajatIOExcel;

    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        angajatMock = new AngajatMockImpl();
        angajatIOExcel = new AngajatOExcelImpl();
        cbApartenentaEtnica.getItems().addAll(ETNIE_MD, ETNIE_RO, ETNIE_RU,
                ETNIE_UA, ETNIE_BG, ETNIE_GA, ETNIE_ALT);
        cbApartenentaEtnica.setValue("Alege etnia");
        cbSexul.getItems().addAll(SEX_M, SEX_F);
        cbSexul.setValue("Selecteaza genul");
        cbStudiile.getItems().addAll(STUD_SCDUR, STUD_GIMN, STUD_LIC, STUD_MEDS, STUD_SUP, STUD_MAST);
        cbStudiile.setValue("Alege studiile");
        cbSpecializarea.getItems().addAll(SPEC_BIBL, SPEC_JURN, SPEC_PED, SPEC_MED,
                SPEC_CONT, SPEC_FIN, SPEC_JUR, SPEC_ADMN, SPEC_AGRO, SPEC_ALT);
        cbSpecializarea.setValue("Alege specializarea");
        cbFunctiaDetinuta.getItems().addAll(FUNC_BIBL, FUNC_I_IV, FUNC_V_IX, FUNC_ADULT,
                FUNC_LECTCOP, FUNC_LECTADULT, FUNC_LABTIC, FUNC_BIBPRIN, FUNC_ADMIN,
                FUNC_FORMASIST, FUNC_ORGDEZV, FUNC_RELPUB, FUNC_DIRADM, FUNC_DIRADJ,
                FUNC_DIR, FUNC_DER, FUNC_PAZ, FUNC_SOF, FUNC_MUN);
        cbFunctiaDetinuta.setValue("Alege functia");
    }
    
    public void tableView() {
        initTable();
        loadDateForTableView();
    }

    @FXML
    private void handleButtonActionActualizeaza(ActionEvent event) {
        Angajat angajat = readForm();
        angajatMock.actualizeazaAngajat(angajat);
        clearForm();
        alertaMesaj("Detaliile angajatului " + angajat.getNumelePrenumele() + " au fost actualizate cu succes", true);
        refreshListView();

    }

    @FXML
    private void handleButtonActionSalveaza(ActionEvent event) {
        Angajat angajatNou = readForm();
        String numeAngajat = tfNumelePrenumele.getText();
        List<Angajat> lista = angajatMock.cautaTot();
        if (!lista.contains(angajatMock.cautare(numeAngajat))) {
            angajatMock.salveazaAngajat(angajatNou);
            clearForm();
            tableView();
        } else {
            alertaMesaj("Angajat cu asa nume deja exista: " + tfNumelePrenumele.getText(), true);
        }
    }

    @FXML
    private void handleButtonActionSterge(ActionEvent event) {
        Angajat angajat = readForm();
        alertaMesaj("Sigur doriti sa stergeti?", true);
        angajatMock.stergeAngajat(angajat);
        refreshListView();
        clearForm();
    }

    @FXML
    private void handleButtonActionCurata(ActionEvent event) {
        clearForm();
    }

    @FXML
    private void handleButtonActionCautare(ActionEvent event) {
        String numeAngajat = tfNumelePrenumele.getText();
        Angajat angajat = angajatMock.cautare(numeAngajat);
        try {
            fillForm(angajat);
        } catch (Exception e){
            alertaMesaj("Nu exista angajat cu asa nume", true);
        }
    }

    @FXML
    private void handleButtonActionCautaTot(ActionEvent event) {
        List<Angajat> list = angajatMock.cautaTot();
        tableView();
    }

    @FXML
    private void handleButtonActionImport(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        try {
            List<Angajat> listaAngajati = angajatIOExcel.readFile(String.valueOf(file));
            angajatMock = new AngajatMockImpl(listaAngajati);
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
            List<Angajat> listAngajati = angajatMock.cautaTot();
           angajatIOExcel.saveToFile(String.valueOf(file), listAngajati);
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
    public Angajat readForm() {
        Angajat carteNoua = new Angajat();
        carteNoua.setNrDeInregistrare(Integer.parseInt(tfNrDeInregistrare.getText()));
        carteNoua.setNumelePrenumele(tfNumelePrenumele.getText());
        carteNoua.setDataDeNastere(Date.valueOf(spDataDeNastere.getValue().toString()));
        carteNoua.setSeriaBI(tfSeriaBI.getText());
        carteNoua.setEliberatBI(Date.valueOf(dpEliberatBI.getValue().toString()));
        carteNoua.setCNP(Long.parseLong(tfCNP.getText()));
        carteNoua.setAdresaDomiciliu(tfAdresaDomiciliu.getText());
        carteNoua.setTel(Long.parseLong(tfTel.getText()));
        carteNoua.setEmail(tfEmail.getText());
        carteNoua.setApartenentaEtnica(cbApartenentaEtnica.getValue());
        carteNoua.setSexul(cbSexul.getValue());
        carteNoua.setStudiile(cbStudiile.getValue());
        carteNoua.setSpecializarea(cbSpecializarea.getValue());
        carteNoua.setFunctiaDetinuta(cbFunctiaDetinuta.getValue());
        carteNoua.setDataAngajarii(Date.valueOf(dpDataAngajarii.getValue().toString()));
        carteNoua.setPremiiDistinctii(tfPremiiDistinctii.getText());
        carteNoua.setAnulConferirei(Date.valueOf(dpAnulConferirei.getValue().toString()));
        carteNoua.setScopulPremiului(tfScopulPremiului.getText());
        carteNoua.setDemisionare(Date.valueOf(dpDemisionare.getValue().toString()));
        return carteNoua;
    }

    @Override
    public void clearForm() {
        tfNrDeInregistrare.setText("");
        tfNumelePrenumele.setText("");
        spDataDeNastere.setValue(null);
        tfSeriaBI.setText("");
        dpEliberatBI.setValue(null);
        tfCNP.setText("");
        tfAdresaDomiciliu.setText("");
        tfTel.setText("");
        tfEmail.setText("");
        cbApartenentaEtnica.setValue(null);
        cbSexul.setValue(null);
        cbStudiile.setValue(null);
        cbSpecializarea.setValue(null);
        cbFunctiaDetinuta.setValue(null);
        dpDataAngajarii.setValue(null);
        tfPremiiDistinctii.setText("");
        dpAnulConferirei.setValue(null);
        tfScopulPremiului.setText("");
        dpDemisionare.setValue(null);
    }

    @Override
    public void fillForm(Angajat angajat) {
        tfNrDeInregistrare.setText("" + angajat.getNrDeInregistrare());
        tfNumelePrenumele.setText(angajat.getNumelePrenumele());
        spDataDeNastere.setValue(LocalDate.parse(angajat.getDataDeNastere().toString()));
        tfSeriaBI.setText("" + angajat.getSeriaBI());
        dpEliberatBI.setValue(LocalDate.parse(angajat.getEliberatBI().toString()));
        tfCNP.setText("" + angajat.getCNP());
        tfAdresaDomiciliu.setText(angajat.getAdresaDomiciliu());
        tfTel.setText("" + angajat.getTel());
        tfEmail.setText("" + angajat.getEmail());
        cbApartenentaEtnica.setValue("" + angajat.getApartenentaEtnica());
        cbSexul.setValue("" + angajat.getSexul());
        cbStudiile.setValue("" + angajat.getStudiile());
        cbSpecializarea.setValue("" + angajat.getSpecializarea());
        cbFunctiaDetinuta.setValue("" + angajat.getFunctiaDetinuta());
        dpDataAngajarii.setValue(LocalDate.parse(angajat.getDataAngajarii().toString()));
        tfPremiiDistinctii.setText("" + angajat.getPremiiDistinctii());
        dpAnulConferirei.setValue(LocalDate.parse(angajat.getAnulConferirei().toString()));
        tfScopulPremiului.setText("" + angajat.getScopulPremiului());
        dpDemisionare.setValue(LocalDate.parse(angajat.getDemisionare().toString()));
    }

    public void refreshListView() {
        List<Angajat> listaDeAngajati = angajatMock.cautaTot();
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
        twNumelePrenumele.setCellValueFactory(new PropertyValueFactory<>("numelePrenumele"));
        twDataNastere.setCellValueFactory(new PropertyValueFactory<>("dataDeNastere"));
        twSeriaBI.setCellValueFactory(new PropertyValueFactory<>("seriaBI"));
        twEliberatBI.setCellValueFactory(new PropertyValueFactory<>("eliberatBI"));
        twCNP.setCellValueFactory(new PropertyValueFactory<>("CNP"));
        twAdresaDomiciliu.setCellValueFactory(new PropertyValueFactory<>("adresaDomiciliu"));
        twTelMob.setCellValueFactory(new PropertyValueFactory<>("tel"));
        twEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        twApartenentaEtnica.setCellValueFactory(new PropertyValueFactory<>("apartenentaEtnica"));
        twSexul.setCellValueFactory(new PropertyValueFactory<>("sexul"));
        twStudiile.setCellValueFactory(new PropertyValueFactory<>("studiile"));
        twSpecializarea.setCellValueFactory(new PropertyValueFactory<>("specializarea"));
        twFunctiaDetinuta.setCellValueFactory(new PropertyValueFactory<>("functiaDetinuta"));
        twDataAngajarii.setCellValueFactory(new PropertyValueFactory<>("dataAngajarii"));
        twPremiiDistinctii.setCellValueFactory(new PropertyValueFactory<>("premiiDistinctii"));
        twAnulConferirii.setCellValueFactory(new PropertyValueFactory<>("anulConferirei"));
        twScopul.setCellValueFactory(new PropertyValueFactory<>("scopulPremiului"));
        twDataEliberarii.setCellValueFactory(new PropertyValueFactory<>("demisionare"));
    }
    
    private void loadDateForTableView() {
        List<Angajat> listaAngajats = new ArrayList<>();
        listaAngajats = angajatMock.cautaTot();
        
        String rind = null;
        while(rind != null) {
            Angajat angajat = CSVUtilAngajat.rindToAngajat(rind);
            listaAngajats.add(angajat);
        }
        ObservableList<Angajat> tableDate = FXCollections.observableArrayList();
        for (Angajat angajat : listaAngajats) {
            tableDate.add(new Angajat(angajat.getNrDeInregistrare(), angajat.getNumelePrenumele(),
            angajat.getDataDeNastere(), angajat.getSeriaBI(), angajat.getEliberatBI(), 
            angajat.getCNP(), angajat.getAdresaDomiciliu(), angajat.getTel(),
            angajat.getEmail(), angajat.getApartenentaEtnica(), angajat.getSexul(),
            angajat.getStudiile(), angajat.getSpecializarea(), angajat.getFunctiaDetinuta(),
            angajat.getDataAngajarii(), angajat.getPremiiDistinctii(), angajat.getAnulConferirei(),
            angajat.getScopulPremiului(), angajat.getDemisionare()));
        }
        tableView.setItems(tableDate);
    }
}
