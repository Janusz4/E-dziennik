package GUI.Kontrolery;

import DAO.KlasaService;
import DAO.OcenaService;
import DAO.PrzedmiotService;
import DAO.RocznikService;
import DAO.UczenService;
import GUI.SceneManager;
import Tabele.Klasa;
import Tabele.Ocena;
import Tabele.Przedmiot;
import Tabele.Rocznik;
import Tabele.Uczen;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class OcenyController implements Initializable {

    @FXML
    private TableView<Uczen> tableView;
    @FXML
    private ComboBox<Przedmiot> comboBox;
    @FXML
    private ComboBox<Rocznik> comboRocznik;
    @FXML
    private ComboBox<Klasa> comboKlasa;
    @FXML
    private TableView<Ocena> tableOceny;
    @FXML
    private TableColumn ocena;
    @FXML
    private ComboBox<Integer> comboOceny;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // COMBOBOX PRZEDMIOTY
        PrzedmiotService przedmiotService = new PrzedmiotService();
        List<Przedmiot> przedmioty = przedmiotService.findAll();
        for (Przedmiot przedmiot : przedmioty) {
            comboBox.getItems().add(przedmiot);
        }
        // TABELA UCZNIOWIE
        TableColumn imie = new TableColumn("Imie");
        TableColumn nazwisko = new TableColumn("Nazwisko");
        imie.setCellValueFactory(
                new PropertyValueFactory("imie")
        );
        nazwisko.setCellValueFactory(
                new PropertyValueFactory("nazwisko")
        );
        tableView.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wyswietlOceny();
            }
        });
        tableView.setPlaceholder(new Label(""));
        tableView.getColumns().addAll(imie, nazwisko);
        // COMBOBOX OCENY
        for (int i = 1; i <= 6; i++) {
            comboOceny.getItems().add(i);
        }
        // TABELA OCENY
        TableColumn data = new TableColumn("Data");
        data.setCellValueFactory(
                new PropertyValueFactory("data")
        );
        ocena.setCellValueFactory(
                new PropertyValueFactory("ocena")
        );
        
        tableOceny.getColumns().addAll(data);
        tableOceny.setPlaceholder(new Label(""));
        // COMBOBOX ROCZNIKI
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

    public void dodajOcene(ActionEvent event) {
        OcenaService ocenaService = new OcenaService();
        Ocena ocena = new Ocena(
                comboBox.getSelectionModel().getSelectedItem().getId_przedmiotu(),
                tableView.getSelectionModel().getSelectedItem().getId_ucznia(),
                new Date(new java.util.Date().getTime()),
                comboOceny.getSelectionModel().getSelectedItem()
        );
        ocenaService.persist(ocena);
        wyswietlOceny();
    }

    public void usunOcene(ActionEvent event) {
        OcenaService ocenaService = new OcenaService();
        ocenaService.delete(tableOceny.getSelectionModel().getSelectedItem());
        wyswietlOceny();
    }

    public void wyswietlOceny() {
        if (comboBox.getSelectionModel().getSelectedItem() != null) {
            OcenaService ocenaService = new OcenaService();
            List<Ocena> oceny = ocenaService.findByUczenPrzedmiot(
                    tableView.getSelectionModel().getSelectedItem().getId_ucznia(),
                    comboBox.getSelectionModel().getSelectedItem().getId_przedmiotu()
            );

            final ObservableList<Ocena> dane
                    = FXCollections.observableArrayList(
                            oceny
                    );

            tableOceny.setItems(dane);
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
