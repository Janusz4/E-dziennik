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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DodajUczniaController implements Initializable {

    @FXML
    private ComboBox<Rocznik> comboRocznik;
    @FXML
    private ComboBox<Klasa> comboKlasa;
    @FXML
    private TextField imie;
    @FXML
    private TextField nazwisko;
    @FXML
    private TextField adres;
    @FXML
    private TextField tel;
    @FXML
    private TextField pesel;
    @FXML
    private Label komunikat;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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

// DODANIE UCZNIA
    public void dodajUcznia(ActionEvent event) {
        UczenService uczenService = new UczenService();
        if (pesel.getText().length() != 11) {
            alert();
        } else {
            Uczen uczen = new Uczen(imie.getText(), nazwisko.getText(), pesel.getText(), comboKlasa.getSelectionModel().getSelectedItem().getId_klasy(), adres.getText(), tel.getText());
            uczenService.persist(uczen);
            komunikat.setText("Pomyślnie dodano ucznia");
        }
    }

    public void alert() {
        Alert alert = new Alert(Alert.AlertType.NONE, "", ButtonType.OK);
        alert.setContentText("Podaj poprawne dane");
        alert.getDialogPane().setPrefSize(200, 100);
        alert.show();
    }

}
