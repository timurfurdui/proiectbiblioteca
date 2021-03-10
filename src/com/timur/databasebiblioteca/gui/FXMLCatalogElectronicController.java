package com.timur.databasebiblioteca.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.timur.databasebiblioteca.Main;
import com.timur.databasebiblioteca.model.Carte;
import com.timur.databasebiblioteca.service.CarteIOIntF;
import com.timur.databasebiblioteca.service.CarteMockIntF;
import com.timur.databasebiblioteca.gui.FormIntF;
import com.timur.databasebiblioteca.service.impl.CarteIOExcelImpl;
import com.timur.databasebiblioteca.service.impl.CarteMockImpl;

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
import com.timur.databasebiblioteca.util.CSVUtilCarte;

/**
 * @author Timur
 */
public class FXMLCatalogElectronicController implements Initializable, FormIntF<Carte> {

    Main aRefMain;
    @FXML
    private TableView<Carte> tableView;
    @FXML
    private TableColumn<Carte, Integer> twNrDeInregistrare;
    @FXML
    private TableColumn<Carte, String> twTitlu;
    @FXML
    private TableColumn<Carte, String> twAutor;
    @FXML
    private TableColumn<Carte, String> twLoculPublicarii;
    @FXML
    private TableColumn<Carte, Date> twAnulPublicarii;
    @FXML
    private TableColumn<Carte, Long> twISBN;
    @FXML
    private TableColumn<Carte, String> twGen;
    @FXML
    private TableColumn<Carte, String> twClasificareCZU;
    @FXML
    private TableColumn<Carte, Integer> twNumarInventar;
    @FXML
    private TableColumn<Carte, Date> twDataprimirii;
    @FXML
    private TableColumn<Carte, String> twRepartizareoficii;
    @FXML
    private TableColumn<Carte, String> twTipDocument;
    @FXML
    private TableColumn<Carte, String> twLimbaEditare;
    @FXML
    private TableColumn<Carte, String> twDescriereBibliografica;

    public void setApp(Main aRefMain) {
        this.aRefMain = aRefMain;
    }

    @FXML
    private TextField tfNrDeInregistrare;
    @FXML
    private TextField tfTitlu;
    @FXML
    private TextField tfAutor;
    @FXML
    private TextField tfLoculPublicarii;
    @FXML
    private DatePicker dpAnulPublicarii;
    @FXML
    private TextField tfISBN;
    @FXML
    private TextField tfGen;
    @FXML
    private TextField tfClasificareCZU;
    @FXML
    private TextField tfNumarInventar;
    @FXML
    private DatePicker dpDataPrimirii;
    @FXML
    private ComboBox<String> cbRepartizareOficii;
    @FXML
    private ComboBox<String> cbTipDocument;
    @FXML
    private ComboBox<String> cbLimbaDeEditare;
    @FXML
    private TextField tfDescriereaBibliografica;

    public static final String OFICIU_CL_I_IV = "Imprumut la domiciliu prescolari si elevii cl. I-IV";
    public static final String OFICIU_CL_V_IX = "Imprumut la domiciliu prescolari si elevii cl. I-IX";
    public static final String OFICIU_LECT_COPII = "Sala de lectura copii";
    public static final String OFICIU_LECT_ADULT = "Sala de lectura adulti";
    public static final String OFICIU_IMPR_ADULT = "Imprumut la domiciliu adulti";
    public static final String OFICIU_LABTIC = "LabTIC";
    public static final String OFICIU_ASIST_SPEC = "Asistenta de specialitate";

    public static final String DOC_CARTE = "Carte";
    public static final String DOC_MUZ = "Document de muzica tiparit";
    public static final String DOC_MANUSCRIS = "Manuscris";
    public static final String DOC_AUDIOVIZUAL = "Document audiovizual";
    public static final String DOC_ELECTRONIC = "Document electronic (CD)";
    public static final String DOC_GRAFIC = "Document grafic";
    public static final String DOC_ALTE = "Alte";

    public static final String LIMBA_RO = "Română";
    public static final String LIMBA_RU = "Rusă";
    public static final String LIMBA_EN = "Engleză";
    public static final String LIMBA_FR = "Franceză";
    public static final String LIMBA_BG = "Bulgară";
    public static final String LIMBA_GA = "Găgăuză";
    public static final String LIMBA_IT = "Italiană";
    public static final String LIMBA_SP = "Spaniolă";
    public static final String LIMBA_EB = "Ebraică";
    public static final String LIMBA_ALT = "Alte";

    CarteMockIntF carteMock;
    CarteIOIntF carteIOExcel;

    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carteMock = new CarteMockImpl();
        carteIOExcel = new CarteIOExcelImpl();
        cbRepartizareOficii.getItems().addAll(OFICIU_CL_I_IV, OFICIU_CL_V_IX, OFICIU_LECT_COPII,
                OFICIU_LECT_ADULT, OFICIU_IMPR_ADULT, OFICIU_LABTIC, OFICIU_ASIST_SPEC);
        cbRepartizareOficii.setValue("Selecteaza oficiul");
        cbTipDocument.getItems().addAll(DOC_CARTE, DOC_MUZ, DOC_MANUSCRIS, DOC_AUDIOVIZUAL,
                DOC_ELECTRONIC, DOC_GRAFIC, DOC_ALTE);
        cbTipDocument.setValue("Alege tip document");
        cbLimbaDeEditare.getItems().addAll(LIMBA_RO, LIMBA_RU, LIMBA_EN, LIMBA_FR,
                LIMBA_BG, LIMBA_GA, LIMBA_IT, LIMBA_SP, LIMBA_EB, LIMBA_ALT);
        cbLimbaDeEditare.setValue("Selecteaza limba");
    }
    
    public void tableView() {
        initTable();
        loadDateForTableView();
    }

    @FXML
    private void handleButtonActionActualizeaza(ActionEvent event) {
        Carte carte = readForm();
        carteMock.actualizeazaCarte(carte);
        clearForm();
        alertaMesaj("Cartea " + carte.getNrDeInregistrare() + " s-a actualizat cu succes", true);
        refreshListView();
    }

    @FXML
    private void handleButtonActionSalveaza(ActionEvent event) {
        Carte carteNoua = readForm();
        String idTitlu = tfTitlu.getText();
        List<Carte> lista = carteMock.cautaTot();
        if (!lista.contains(carteMock.cautare(idTitlu))) {
            carteMock.salveazaCarte(carteNoua);
            clearForm();
            tableView();
        } else {
            alertaMesaj("Carte cu asa titlu deja exista: " + tfNrDeInregistrare.getText(), true);
        }
    }

    @FXML
    private void handleButtonActionSterge(ActionEvent event) {
        Carte carte = readForm();
        alertaMesaj("Sigur doriti sa stergeti?", true);
        carteMock.stergeCarte(carte);
        refreshListView();
        clearForm();
    }

    @FXML
    private void handleButtonActionCurata(ActionEvent event) {
        clearForm();
    }

    @FXML
    private void handleButtonActionCautare(ActionEvent event) {
        String idTitlu = tfTitlu.getText();
        Carte carte = carteMock.cautare(idTitlu);
        try {
            fillForm(carte);
        } catch (Exception e) {
            alertaMesaj("Nu exista carte cu titlu", true);
        }
    }

    @FXML
    private void handleButtonActionCautaTot(ActionEvent event) {
        List<Carte> list = carteMock.cautaTot();
        tableView();
    }

    @FXML
    private void handleButtonActionImport(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        try {
            List<Carte> listaCarti = carteIOExcel.readFile(String.valueOf(file));
            carteMock = new CarteMockImpl(listaCarti);
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
            List<Carte> listCarti = carteMock.cautaTot();
            carteIOExcel.saveToFile(String.valueOf(file), listCarti);
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
    public Carte readForm() {
        Carte carteNoua = new Carte();
        carteNoua.setNrDeInregistrare(Integer.parseInt(tfNrDeInregistrare.getText()));
        carteNoua.setTitlu(tfTitlu.getText());
        carteNoua.setAutor(tfAutor.getText());
        carteNoua.setLoculPublicarii(tfLoculPublicarii.getText());
        carteNoua.setAnulPublicarii(Date.valueOf(dpAnulPublicarii.getValue().toString()));
        carteNoua.setISBN(Long.parseLong(tfISBN.getText()));
        carteNoua.setGen(tfGen.getText());
        carteNoua.setClasificareCZU(tfClasificareCZU.getText());
        carteNoua.setNumarInventar(Integer.parseInt(tfNumarInventar.getText()));
        carteNoua.setDataPrimirii(Date.valueOf(dpDataPrimirii.getValue().toString()));
        carteNoua.setRepartizareOficii(cbRepartizareOficii.getValue());
        carteNoua.setTipDocument(cbTipDocument.getValue());
        carteNoua.setLimbaDeEditare(cbLimbaDeEditare.getValue());
        carteNoua.setDescriereaBibliografica(tfDescriereaBibliografica.getText());
        return carteNoua;
    }

    @Override
    public void clearForm() {
        tfNrDeInregistrare.setText("");
        tfTitlu.setText("");
        tfAutor.setText("");
        tfLoculPublicarii.setText("");
        dpAnulPublicarii.setValue(null);
        tfISBN.setText("");
        tfGen.setText("");
        tfClasificareCZU.setText("");
        tfNumarInventar.setText("");
        dpDataPrimirii.setValue(null);
        cbRepartizareOficii.setValue(null);
        cbTipDocument.setValue(null);
        cbLimbaDeEditare.setValue(null);
        tfDescriereaBibliografica.setText("");
    }

    @Override
    public void fillForm(Carte carte) {
        tfNrDeInregistrare.setText("" + carte.getNrDeInregistrare());
        tfTitlu.setText(carte.getTitlu());
        tfAutor.setText(carte.getAutor());
        tfLoculPublicarii.setText("" + carte.getLoculPublicarii());
        dpAnulPublicarii.setValue(LocalDate.parse(carte.getAnulPublicarii().toString()));
        tfISBN.setText("" + carte.getISBN());
        tfGen.setText(carte.getGen());
        tfClasificareCZU.setText(carte.getClasificareCZU());
        tfNumarInventar.setText("" + carte.getNumarInventar());
        dpDataPrimirii.setValue(LocalDate.parse(carte.getDataPrimirii().toString()));
        cbRepartizareOficii.setValue("" + carte.getRepartizareOficii());
        cbTipDocument.setValue("" + carte.getTipDocument());
        cbLimbaDeEditare.setValue("" + carte.getLimbaDeEditare());
        tfDescriereaBibliografica.setText("" + carte.getDescriereaBibliografica());
    }

    public void refreshListView() {
        List<Carte> listaDeCarti = carteMock.cautaTot();
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
        twTitlu.setCellValueFactory(new PropertyValueFactory<>("titlu"));
        twAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        twLoculPublicarii.setCellValueFactory(new PropertyValueFactory<>("loculPublicarii"));
        twAnulPublicarii.setCellValueFactory(new PropertyValueFactory<>("anulPublicarii"));
        twISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        twGen.setCellValueFactory(new PropertyValueFactory<>("gen"));
        twClasificareCZU.setCellValueFactory(new PropertyValueFactory<>("clasificareCZU"));
        twNumarInventar.setCellValueFactory(new PropertyValueFactory<>("numarInventar"));
        twDataprimirii.setCellValueFactory(new PropertyValueFactory<>("dataPrimirii"));
        twRepartizareoficii.setCellValueFactory(new PropertyValueFactory<>("repartizareOficii"));
        twTipDocument.setCellValueFactory(new PropertyValueFactory<>("tipDocument"));
        twLimbaEditare.setCellValueFactory(new PropertyValueFactory<>("limbaDeEditare"));
        twDescriereBibliografica.setCellValueFactory(new PropertyValueFactory<>("descriereaBibliografica"));
    }

    private void loadDateForTableView() {
        List<Carte> listaCartes = new ArrayList<>();
        listaCartes = carteMock.cautaTot();
        
        String rind = null;
        while(rind != null) {
            Carte carte = CSVUtilCarte.rindToCarte(rind);
            listaCartes.add(carte);
        }
        ObservableList<Carte> tableDate = FXCollections.observableArrayList();
        for (Carte carte : listaCartes) {
            tableDate.add(new Carte(carte.getNrDeInregistrare(), carte.getTitlu(),
            carte.getAutor(), carte.getLoculPublicarii(), carte.getAnulPublicarii(), 
            carte.getISBN(), carte.getGen(), carte.getClasificareCZU(), 
            carte.getNumarInventar(), carte.getDataPrimirii(), carte.getRepartizareOficii(), 
            carte.getTipDocument(), carte.getLimbaDeEditare(), carte.getDescriereaBibliografica()));
        }
        tableView.setItems(tableDate);
    }
}
