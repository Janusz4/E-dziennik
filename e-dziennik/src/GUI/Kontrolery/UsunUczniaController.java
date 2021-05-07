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

public class UsunUczniaController implements Initializable {

    @FXML
    private TableView<Uczen> tableView;
    @FXML
    private ComboBox<Rocznik> comboRocznik;
    @FXML
    private ComboBox<Klasa> comboKlasa;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TABELA
        TableColumn imie = new TableColumn("Imie");
        TableColumn nazwisko = new TableColumn("Nazwisko");
        TableColumn pesel = new TableColumn("Pesel");
        TableColumn adres = new TableColumn("Adres");
        TableColumn tel = new TableColumn("Nr telefonu");

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
        tableView.setPlaceholder(new Label(""));
        tableView.getColumns().addAll(imie, nazwisko, pesel, adres, tel);

        wyswietlRoczniki();
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

    public void usunUcznia() {
        UczenService uczenService = new UczenService();
        if (tableView.getSelectionModel().getSelectedItem() != null) {
            uczenService.delete(tableView.getSelectionModel().getSelectedItem());
            wyswietlUczniow();
        }
    }

    // ZMIANA SCEN W MENU
    @FXML
    public void renderUczniowie(ActionEvent event) {
        SceneManager.renderScene("scena1");
    }

    @FXML
    public void renderOceny(ActionEvent event) {
        SceneManager.renderScene("scena2");
    }

    @FXML
    public void renderDodajUcznia(ActionEvent event) {
        SceneManager.renderScene("scena3");
    }

    @FXML
    public void renderDodajPrzedmiot(ActionEvent event) {
        SceneManager.renderScene("scena4");
    }

    @FXML
    public void renderDodajKlase(ActionEvent event) {
        SceneManager.renderScene("scena5");
    }

    @FXML
    public void renderUsunUcznia(ActionEvent event) {
        SceneManager.renderScene("scena6");
    }

    @FXML
    public void renderUsunPrzedmiot(ActionEvent event) {
        SceneManager.renderScene("scena7");
    }

    @FXML
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
