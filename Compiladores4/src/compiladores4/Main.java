/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladores4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author leo
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader();
        try {
            BorderPane root = (BorderPane) loader.load(Main.class.getResource("interfacePrincipal.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setTitle("Trabalho 6!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Throwable e) {
            e.printStackTrace();

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
