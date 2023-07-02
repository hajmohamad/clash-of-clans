package com.example.clash;


import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class allPageshow {

    public static Stage mainStage;
    public static void show_welcome() throws IOException {
        Scene scene = new Scene(new FXMLLoader(Main.class.getResource("welcome.fxml")).load(), 1366,763 );
        allPageshow.mainStage.setTitle("welcome");
        allPageshow.mainStage.setScene(scene);
        allPageshow.mainStage.show();
    }
    public static void show_login() throws IOException {
        Scene scene = new Scene(new FXMLLoader(Main.class.getResource("loginPage.fxml")).load(), 1366,763 );
        allPageshow.mainStage.setTitle("loginPage");
        allPageshow.mainStage.setScene(scene);
        allPageshow.mainStage.show();
    }
    public static void show_playerFirsPAGE() throws IOException {
        Scene scene = new Scene(new FXMLLoader(Main.class.getResource("playerPage.fxml")).load(), 1366,763 );
        allPageshow.mainStage.setTitle("loginPage");
        allPageshow.mainStage.setScene(scene);
        allPageshow.mainStage.show();

    }
    public static void show_attackChosePAGE() throws IOException {
        Scene scene = new Scene(new FXMLLoader(Main.class.getResource("attackChosePage.fxml")).load(), 1366,763 );
        allPageshow.mainStage.setTitle("loginPage");
        allPageshow.mainStage.setScene(scene);
        allPageshow.mainStage.show();

    }
}
