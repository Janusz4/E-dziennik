
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DodajKlaseController implements Initializable {

    @FXML
    private TextField klasaTF;
    @FXML
    private Label komunikat;
    @FXML
    private ComboBox<Rocznik> comboBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RocznikService rocznikService = new RocznikService();
        List<Rocznik> roczniki = rocznikService.findAll();

        for (Tabele.Rocznik rocznik : roczniki) {
            comboBox.getItems().add(rocznik);
        }
    }    

    // ZMIANA SCEN W MENU
    
    @FXML
    public void renderUczniowie(ActionEvent event){
        SceneManager.renderScene("scena1");
    }
    @FXML
    public void renderOceny(ActionEvent event){
        SceneManager.renderScene("scena2");
    }
    @FXML
    public void renderDodajUcznia(ActionEvent event){
        SceneManager.renderScene("scena3");
    }
    public void renderDodajPrzedmiot(ActionEvent event){
        SceneManager.renderScene("scena4");
    }
    public void renderDodajKlase(ActionEvent event){
        SceneManager.renderScene("scena5");
    }
    public void renderUsunUcznia(ActionEvent event){
        SceneManager.renderScene("scena6");
    }
    public void renderUsunPrzedmiot(ActionEvent event){
        SceneManager.renderScene("scena7");
    }
    public void renderUsunKlase(ActionEvent event){
        SceneManager.renderScene("scena8");
    }
    @FXML
    public void renderDodajRocznik(ActionEvent event){
        SceneManager.renderScene("scena9");
    }
    @FXML
    public void renderUsunRocznik(ActionEvent event){
        SceneManager.renderScene("scena10");
    }
    
// DODANIE KLASY
    public void dodajKlase(ActionEvent event){
        KlasaService klasaService = new KlasaService();
        Klasa klasa = new Klasa(klasaTF.getText(),comboBox.getSelectionModel().getSelectedItem().getId_rocznika());
        klasaService.persist(klasa);
        komunikat.setText("Pomyślnie dodano klasę");
    }
    
}
