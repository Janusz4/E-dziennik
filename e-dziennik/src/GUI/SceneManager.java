
package GUI;

import java.io.IOException;
import java.util.Hashtable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class SceneManager {
    private static Stage stage;
    private static Hashtable<String, String> view = new Hashtable<>();
    
    public static void addScene(String name, String path) throws IOException {
        view.put(name, path);
    }
    
    public static void removeScene(String name){
        view.remove(name);
    }
    
    public static void renderScene(String name){
        String path="";
        try{
            path = view.get(name);
            Parent root = FXMLLoader.load(SceneManager.class.getResource(path));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println("Nie można załadować pliku XML z widokiem: " + path);
        } catch (RuntimeException ex) {
            System.out.println("Nazwa widoku jest nieprawidłowa");
        }
    }
    
    public static void setStage(Stage _stage) {
        stage = _stage;
    }
    
    public static void setTitle(String title){
        stage.setTitle(title);
        Image icon = new Image("/GUI/icon.png");
        stage.getIcons().add(icon);
    }
    
    public static void exit(){
        stage.setOnCloseRequest(e ->{
            System.exit(0);
        }    );
        
    }
    
}
