package GUI.Kontrolery;

import DAO.KlasaService;
import DAO.RocznikService;
import DAO.UczenService;
import GUI.SceneManager;
import Tabele.Klasa;
import Tabele.Rocznik;
import Tabele.Uczen;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class UczniowieController implements Initializable {

    @FXML
    private TableView<Uczen> tableView;
    @FXML
    private TableColumn imie;
    @FXML
    private TableColumn nazwisko;
    @FXML
    private TableColumn pesel;
    @FXML
    private TableColumn adres;
    @FXML
    private TableColumn tel;
    @FXML
    private ComboBox<Rocznik> comboRocznik;
    @FXML
    private ComboBox<Klasa> comboKlasa;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TABELA

        imie.setCellValueFactory(
                new PropertyValueFactory("imie")
        );
        nazwisko.setCellValueFactory(
                new PropertyValueFactory("nazwisko")
        );
        pesel.setCellValueFactory(
                new PropertyValueFactory("pesel")
        );
        adres.setCellValueFactory(
                new PropertyValueFactory("adres")
        );
        tel.setCellValueFactory(
                new PropertyValueFactory("nr_telefonu")
        );
        
        tableView.setEditable(true);
        imie.setCellFactory(TextFieldTableCell.forTableColumn());
        nazwisko.setCellFactory(TextFieldTableCell.forTableColumn());
        pesel.setCellFactory(TextFieldTableCell.forTableColumn());
        adres.setCellFactory(TextFieldTableCell.forTableColumn());
        tel.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.setPlaceholder(new Label(""));

        wyswietlRoczniki();
    }

    public void imieUpdate(TableColumn.CellEditEvent<Uczen,String> event){
        Uczen uczen = tableView.getSelectionModel().getSelectedItem();
        uczen.setImie(event.getNewValue());
        UczenService uczenService = new UczenService();
        uczenService.update(uczen);
    }
    
    public void nazwiskoUpdate(TableColumn.CellEditEvent<Uczen,String> event){
        Uczen uczen = tableView.getSelectionModel().getSelectedItem();
        uczen.setNazwisko(event.getNewValue());
        UczenService uczenService = new UczenService();
        uczenService.update(uczen);
    }
    
    public void peselUpdate(TableColumn.CellEditEvent<Uczen,String> event){
        Uczen uczen = tableView.getSelectionModel().getSelectedItem();
        uczen.setPesel(event.getNewValue());
        UczenService uczenService = new UczenService();
        uczenService.update(uczen);
    }
    
    public void adresUpdate(TableColumn.CellEditEvent<Uczen,String> event){
        Uczen uczen = tableView.getSelectionModel().getSelectedItem();
        uczen.setAdres(event.getNewValue());
        UczenService uczenService = new UczenService();
        uczenService.update(uczen);
    }
    
    public void telUpdate(TableColumn.CellEditEvent<Uczen,String> event){
        Uczen uczen = tableView.getSelectionModel().getSelectedItem();
        uczen.setNr_telefonu(event.getNewValue());
        UczenService uczenService = new UczenService();
        uczenService.update(uczen);
    }

    public void wyswietlRoczniki() {
        RocznikService rocznikService = new RocznikService();
        List<Rocznik> roczniki = rocznikService.findAll();
        for (Rocznik rocznik : roczniki) {
            comboRocznik.getItems().add(rocznik);
        }
    }

    public void wyswietlKlasy() {
        KlasaService klasaService = new KlasaService();
        if (comboRocznik.getSelectionModel().getSelectedItem() != null) {
            List<Klasa> klasy = klasaService.findByRocznik(comboRocznik.getSelectionModel().getSelectedItem().getId_rocznika());
            comboKlasa.getItems().clear();
            for (Klasa klasa : klasy) {
                comboKlasa.getItems().add(klasa);
            }
        }
        wyswietlUczniow();
    }

    public void wyswietlUczniow() {
        UczenService uczenService = new UczenService();
        if (comboKlasa.getSelectionModel().getSelectedItem() != null) {
            List<Uczen> uczniowie = uczenService.findByKlasa(comboKlasa.getSelectionModel().getSelectedItem().getId_klasy());
            tableView.getItems().clear();
            for (Uczen uczen : uczniowie) {
                tableView.getItems().add(uczen);
            }
        } else {
            List<Uczen> uczniowie = uczenService.findByRocznik(comboRocznik.getSelectionModel().getSelectedItem().getId_rocznika());
            tableView.getItems().clear();
            for (Uczen uczen : uczniowie) {
                tableView.getItems().add(uczen);
            }
        }
    }

    // ZMIANA SCEN W MENU
    public void renderUczniowie(ActionEvent event) {
        SceneManager.renderScene("scena1");
    }

    public void renderOceny(ActionEvent event) {
        SceneManager.renderScene("scena2");
    }

    public void renderDodajUcznia(ActionEvent event) {
        SceneManager.renderScene("scena3");
    }

    public void renderDodajPrzedmiot(ActionEvent event) {
        SceneManager.renderScene("scena4");
    }

    public void renderDodajKlase(ActionEvent event) {
        SceneManager.renderScene("scena5");
    }

    public void renderUsunUcznia(ActionEvent event) {
        SceneManager.renderScene("scena6");
    }

    public void renderUsunPrzedmiot(ActionEvent event) {
        SceneManager.renderScene("scena7");
    }

    public void renderUsunKlase(ActionEvent event) {
        SceneManager.renderScene("scena8");
    }

    @FXML
    public void renderDodajRocznik(ActionEvent event) {
        SceneManager.renderScene("scena9");
    }

    @FXML
    public void renderUsunRocznik(ActionEvent event) {
        SceneManager.renderScene("scena10");
    }

}
