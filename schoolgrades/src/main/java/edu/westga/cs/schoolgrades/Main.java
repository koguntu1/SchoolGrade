package edu.westga.cs.schoolgrades;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the main clas of the project 
 * @author Iam
 * @version 1.0
 *
 */
public class Main extends Application {
    
    /**
     * This is the start method
     * @param primaryStage     
     * @throws Exception   
     */
    public void start(Stage primaryStage) throws Exception {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource("edu/westga/cs/schoolgrades/views/GradesGui.fxml");
        FXMLLoader loader = new FXMLLoader(resource);
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Grades Worksheet");
        primaryStage.show();
    }

    /**
     * This is the main method
     * @param args 
     */
    public static void main(String[] args) {
        launch(args);
    }
}
