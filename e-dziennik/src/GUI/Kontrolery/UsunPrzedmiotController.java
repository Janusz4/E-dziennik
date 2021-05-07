package GUI.Kontrolery;

import DAO.PrzedmiotService;
import GUI.SceneManager;
import Tabele.Klasa;
import Tabele.Przedmiot;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class UsunPrzedmiotController implements Initializable {

    @FXML
    private ListView<Przedmiot> listView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        wyswietlPrzedmioty();
    }

    public void usunPrzedmiot(ActionEvent event) {
        Przedmiot przedmiot = listView.getSelectionModel().getSelectedItem();
        PrzedmiotService przedmiotService = new PrzedmiotService();
        przedmiotService.delete(przedmiot);
        listView.getItems().remove(przedmiot);
        wyswietlPrzedmioty();
    }

    public void wyswietlPrzedmioty() {

        PrzedmiotService przedmiotService = new PrzedmiotService();
        List<Przedmiot> przedmioty = przedmiotService.findAll();
        listView.getItems().clear();
        for (Przedmiot przedmiot : przedmioty) {
            listView.getItems().add(przedmiot);
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
