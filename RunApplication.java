package com.example.stickherogame;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RunApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent p = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        Scene scene = new Scene(p);
        stage.setTitle("Hello Stick Hero Game");
        stage.setScene(scene);
        stage.show();
    }
}
