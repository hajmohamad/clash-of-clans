package com.example.clash;

import Controller.AdminController;
import Model.Admin;
import Model.Building.ArcherDB;
import Model.Building.FireDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        AdminController.reedFromDataBase();
      allPageshow.mainStage=stage;
      allPageshow.show_welcome();

    }

    public static void main(String[] args) {
        Admin.addAdmin();


        launch();
    }
}