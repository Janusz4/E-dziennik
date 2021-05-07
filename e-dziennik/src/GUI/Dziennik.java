
package GUI;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

public class Dziennik extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        SceneManager.setStage(primaryStage);
        SceneManager.addScene("scena1","/GUI/Sceny/Uczniowie.fxml");
        SceneManager.addScene("scena2","/GUI/Sceny/Oceny.fxml");
        SceneManager.addScene("scena3","/GUI/Sceny/dodajUcznia.fxml");
        SceneManager.addScene("scena4","/GUI/Sceny/dodajPrzedmiot.fxml");
        SceneManager.addScene("scena5","/GUI/Sceny/dodajKlase.fxml");
        SceneManager.addScene("scena6","/GUI/Sceny/usunUcznia.fxml");
        SceneManager.addScene("scena7","/GUI/Sceny/usunPrzedmiot.fxml");
        SceneManager.addScene("scena8","/GUI/Sceny/usunKlase.fxml");
        SceneManager.addScene("scena9","/GUI/Sceny/dodajRocznik.fxml");
        SceneManager.addScene("scena10","/GUI/Sceny/usunRocznik.fxml");
        
        SceneManager.exit();
        SceneManager.setTitle("e-dziennik");
        SceneManager.renderScene("scena1");
        
    }
    
}
