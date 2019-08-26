/*
 * Lingwistyka Matematyczna Zadanie 4 - Odwrotna Notacja Polska.
 * Szymon Zawadzki 221515.
 */

package onp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Szaman
 */
public class Main extends Application 
{
    @Override
    public void start(Stage stage) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.setTitle("Odwrotna Notacja Polska");
    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
