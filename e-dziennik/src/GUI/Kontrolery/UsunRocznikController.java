package GUI.Kontrolery;

import DAO.PrzedmiotService;
import DAO.RocznikService;
import GUI.SceneManager;
import Tabele.Przedmiot;
import Tabele.Rocznik;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class UsunRocznikController implements Initializable {

    @FXML
    private ListView<Rocznik> listView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        wyswietlRoczniki();
    }

    public void usunRocznik(ActionEvent event) {
        Rocznik rocznik = listView.getSelectionModel().getSelectedItem();
        RocznikService rocznikService = new RocznikService();
        rocznikService.delete(rocznik);
        listView.getItems().remove(rocznik);
        wyswietlRoczniki();
    }

    public void wyswietlRoczniki() {
        RocznikService rocznikService = new RocznikService();
        List<Rocznik> roczniki = rocznikService.findAll();
        listView.getItems().clear();
        for (Rocznik rocznik : roczniki) {
            listView.getItems().add(rocznik);
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
