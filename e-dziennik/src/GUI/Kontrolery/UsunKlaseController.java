package GUI.Kontrolery;

import DAO.KlasaService;
import DAO.RocznikService;
import GUI.SceneManager;
import Tabele.Klasa;
import Tabele.Rocznik;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class UsunKlaseController implements Initializable {

    @FXML
    private ComboBox<Rocznik> comboBox;
    @FXML
    private ListView<Klasa> listView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        wyswietlRoczniki();
        wyswietlKlasy();
    }

    public void usunKlase(ActionEvent event) {
        Klasa klasa = listView.getSelectionModel().getSelectedItem();
        KlasaService klasaService = new KlasaService();
        klasaService.delete(klasa);
        wyswietlKlasy();
    }

    public void wyswietlKlasy() {
        KlasaService klasaService = new KlasaService();
        if(comboBox.getSelectionModel().getSelectedItem() != null){
        List<Klasa> klasy = klasaService.findByRocznik(comboBox.getSelectionModel().getSelectedItem().getId_rocznika());
        listView.getItems().clear();
        for (Klasa klasa : klasy) {
            listView.getItems().add(klasa);
        }
        }
    }
    
    public void wyswietlRoczniki(){
        RocznikService rocznikService = new RocznikService();
        List<Rocznik> roczniki = rocznikService.findAll();
        for(Rocznik rocznik : roczniki){
            comboBox.getItems().add(rocznik);
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
