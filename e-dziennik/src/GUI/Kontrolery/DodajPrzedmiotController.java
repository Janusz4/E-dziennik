
package GUI.Kontrolery;

import DAO.PrzedmiotService;
import GUI.SceneManager;
import Tabele.Przedmiot;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DodajPrzedmiotController implements Initializable {
    
    @FXML
    private TextField przedmiotTF;
    @FXML
    private Label komunikat;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    @FXML
    public void renderDodajPrzedmiot(ActionEvent event){
        SceneManager.renderScene("scena4");
    }
    @FXML
    public void renderDodajKlase(ActionEvent event){
        SceneManager.renderScene("scena5");
    }
    @FXML
    public void renderUsunUcznia(ActionEvent event){
        SceneManager.renderScene("scena6");
    }
    @FXML
    public void renderUsunPrzedmiot(ActionEvent event){
        SceneManager.renderScene("scena7");
    }
    @FXML
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
    
    public void dodajPrzedmiot(ActionEvent event){
        Przedmiot przedmiot = new Przedmiot(przedmiotTF.getText());
        PrzedmiotService przedmiotService = new PrzedmiotService();
        przedmiotService.persist(przedmiot);
        przedmiotTF.clear();
        komunikat.setText("Pomyślnie dodano przedmiot");
    }
    
}
