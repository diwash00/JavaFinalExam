package com.georgiancollege.test2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("user-details-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Final Exam!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        String filePath = "users.json";//eta tmro file path hai json file ko
        User[] users = JsonParse.jsonFileParser(filePath);     //get an array of User object

        launch();
    }


}